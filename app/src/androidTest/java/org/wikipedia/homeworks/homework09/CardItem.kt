package org.wikipedia.homeworks.homework09

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CardItem(matcher: Matcher<View>) : KRecyclerItem<CardItem>(matcher) {

    val listText = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }

    val listImage = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }
}