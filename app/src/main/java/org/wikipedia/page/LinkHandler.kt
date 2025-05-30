package org.wikipedia.page

import android.app.Activity
import android.content.Context
import android.net.Uri
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.wikipedia.bridge.CommunicationBridge.JSEventListener
import org.wikipedia.dataclient.WikiSite
import org.wikipedia.page.LinkMovementMethodExt.UrlHandlerWithText
import org.wikipedia.places.PlacesActivity
import org.wikipedia.util.FeedbackUtil
import org.wikipedia.util.StringUtil
import org.wikipedia.util.UriUtil
import org.wikipedia.util.log.L

abstract class LinkHandler(protected val context: Context) : JSEventListener, UrlHandlerWithText {
    abstract fun onPageLinkClicked(anchor: String, linkText: String)
    abstract fun onInternalLinkClicked(title: PageTitle)
    abstract fun onMediaLinkClicked(title: PageTitle)
    abstract fun onDiffLinkClicked(title: PageTitle, revisionId: Long)
    abstract var wikiSite: WikiSite

    // message from JS bridge:
    override fun onMessage(messageType: String, messagePayload: JsonObject?) {
        messagePayload?.let {
            onUrlClick(UriUtil.decodeURL(it["href"]?.jsonPrimitive?.content.orEmpty()),
                it["title"]?.jsonPrimitive?.content,
                it["text"]?.jsonPrimitive?.content.orEmpty())
        }
    }

    override fun onUrlClick(url: String, titleString: String?, linkText: String) {
        var href = url
        if (href.startsWith("mailto:")) {
            val emailAddress = href.removePrefix("mailto:")
            FeedbackUtil.composeEmail(context, emailAddress = emailAddress)
            return
        }

        if (href.startsWith("//")) {
            // for URLs without an explicit scheme, add our default scheme explicitly.
            href = wikiSite.scheme() + ":" + href
        } else if (href.startsWith("./")) {
            href = href.replace("./", "/wiki/")
        }

        // special: returned by page-library when clicking Read More items in the footer.
        val eventLoggingParamIndex = href.indexOf("?event-logging-label")
        if (eventLoggingParamIndex > 0) {
            href = href.substring(0, eventLoggingParamIndex)
        }
        var uri = Uri.parse(href)
        uri.fragment?.run {
            if (contains("cite")) {
                onPageLinkClicked(this, linkText)
                return@onUrlClick
            }
        }
        val knownScheme = KNOWN_SCHEMES.any { href.startsWith("$it:") }
        if (!knownScheme) {
            // for URLs without a known scheme, add our default scheme explicitly.
            uri = uri.buildUpon()
                    .scheme(wikiSite.scheme())
                    .authority(wikiSite.authority())
                    .path(href)
                    .build()
        }

        // TODO: remove this after the endpoint supporting language variants
        val convertedText = UriUtil.getTitleFromUrl(href)
        var titleStr = titleString
        if (convertedText != titleStr) {
            titleStr = convertedText
        }
        var site = WikiSite(uri)
        if (site.subdomain() == wikiSite.subdomain() && site.languageCode != wikiSite.languageCode) {
            // override the languageCode from the parent WikiSite, in case it's a variant.
            site = WikiSite(uri.authority!!, wikiSite.languageCode)
        }
        L.d("Link clicked was $uri")
        val supportedAuthority = uri.authority?.run { WikiSite.supportedAuthority(this) } == true
        when {
            uri.path?.run { matches(("^${UriUtil.WIKI_REGEX}.*").toRegex()) } == true && supportedAuthority -> {
                val newTitle = if (titleStr.isEmpty()) {
                    PageTitle.titleForInternalLink(uri.path, site)
                } else PageTitle.withSeparateFragment(titleStr, uri.fragment, site)
                if (newTitle.isFilePage) {
                    onMediaLinkClicked(newTitle)
                } else {
                    onInternalLinkClicked(newTitle)
                }
            }
            !uri.fragment.isNullOrEmpty() && supportedAuthority -> {
                onPageLinkClicked(uri.fragment!!, linkText)
            }
            !uri.getQueryParameter("title").isNullOrEmpty() && !uri.getQueryParameter("diff").isNullOrEmpty() && supportedAuthority -> {
                val diffAttr = uri.getQueryParameter("diff").orEmpty()
                var diffRev = diffAttr.toLongOrNull() ?: -1
                if (diffAttr == "next" || diffAttr == "prev") {
                    diffRev = uri.getQueryParameter("oldid")?.toLongOrNull() ?: -1
                }
                onDiffLinkClicked(PageTitle(uri.getQueryParameter("title"), site), diffRev)
            }
            else -> {
                onExternalLinkClicked(uri)
            }
        }
    }

    open fun onExternalLinkClicked(uri: Uri) {
        if (uri.authority.orEmpty().contains("geohack") && context is Activity) {
            StringUtil.geoHackToLocation(uri.getQueryParameter("params"))?.let {
                context.startActivity(PlacesActivity.newIntent(context, null, it))
                return
            }
        }
        UriUtil.handleExternalLink(context, uri)
    }

    companion object {
        private val KNOWN_SCHEMES = listOf("http", "https", "geo", "file", "content")
    }
}
