package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homeworks20.getName
import org.wikipedia.homeworks.homeworks20.withParent

class ListTopReadCardItem(matcher: Matcher<View>) : KRecyclerItem<ListTopReadCardItem>(matcher) {

    val rank by lazy {
        KTextView(matcher) {
            withId(R.id.numberView)
        }.getName(withParent("Rank"))
    }

    val titles by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.getName(withParent("Titles"))
    }

    val descriptions = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }

    val cardImage by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.getName(withParent("Card image"))
    }

    val graph = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val pageViews = KTextView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }
}