package org.wikipedia.homeworks.homework08.wikilanguages

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class HeaderItem(matcher: Matcher<View>) : KRecyclerItem<HeaderItem>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.section_header_text)
    }
}