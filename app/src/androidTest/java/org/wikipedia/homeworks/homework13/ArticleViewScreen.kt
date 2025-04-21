package org.wikipedia.homeworks.homework13

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.homeworks.homeworks20.NamedKScreen
import org.wikipedia.homeworks.homeworks20.name

object ArticleViewScreen : NamedKScreen<ArticleViewScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null
    override val screenName = "Web view list top read"

    val webView = KWebView {
        withId(R.id.page_web_view)
    }

    val image by lazy {
        KImageView {
            withId(R.id.articleImage)
        }.name(withParent("Image in web view"))
    }

    val header by lazy {
        KTextView {
            withId(R.id.articleTitle)
        }.name(withParent("Header in web view"))
    }

}