package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks20.name
import org.wikipedia.homeworks20.withParent

class TopReadCardItem(matcher: Matcher<View>) : KRecyclerItem<TopReadCardItem>(matcher) {

    val cardHeader by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }

    val languageCode = KTextView(matcher) {
        withId(R.id.langCodeText)
    }

    val cardHeaderMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val topReadList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::ListTopReadCardItem)
        }
    )

    val footerButton = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }

}