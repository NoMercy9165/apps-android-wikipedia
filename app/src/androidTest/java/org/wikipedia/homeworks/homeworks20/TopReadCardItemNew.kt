package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homeworks20.invokeAtIndex
import org.wikipedia.homeworks.homeworks20.name
import org.wikipedia.homeworks.homeworks20.withParent


class TopReadCardItemNew(matcher: Matcher<View>) : KRecyclerItem<TopReadCardItemNew>(matcher) {

    val cardHeader by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Header"))
    }

    val languageCode by lazy {
        KTextView(matcher) {
            withId(R.id.langCodeText)
        }.name(withParent("Language code"))
    }

    val cardHeaderMenu by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Header menu"))
    }

    val topReadList by  lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::ListTopReadCardItem)
            }
        ).name(withParent("Список"))
    }

    val footerButton = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }

    fun listTopRead(index: Int, function: ListTopReadCardItem.() -> Unit) {
        topReadList.invokeAtIndex(index, function)
    }


}