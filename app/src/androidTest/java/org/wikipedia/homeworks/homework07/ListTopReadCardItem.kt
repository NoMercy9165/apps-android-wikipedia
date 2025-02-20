package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ListTopReadCardItem(matcher: Matcher<View>) : KRecyclerItem<ListTopReadCardItem>(matcher) {

    val rank = KTextView(matcher) {
        withId(R.id.numberView)
    }

    val titles = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val descriptions = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }

    val cardImage = KImageView(matcher) {
        withId(R.id.view_list_card_item_image)
    }

    val graph = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val pageViews = KTextView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }
}