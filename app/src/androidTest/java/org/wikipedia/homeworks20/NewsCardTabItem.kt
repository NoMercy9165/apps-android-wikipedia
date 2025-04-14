package org.wikipedia.homeworks20

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R


class NewsCardTabItem(matcher: Matcher<View>) : KRecyclerItem<NewsCardTabItem>(matcher) {

    val image by lazy {
        KImageView(matcher) { withId(R.id.horizontal_scroll_list_item_image) }.name(withParent("Image"))
    }

    val text by lazy {
        KTextView(matcher) { withId(R.id.horizontal_scroll_list_item_text) }.name(withParent("Text"))
    }

}