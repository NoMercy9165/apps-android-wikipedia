package org.wikipedia.homeworks.homework08.onboarding

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ListLanguageItem(matcher: Matcher<View>) : KRecyclerItem<ListLanguageItem>(matcher) {

    val language = KTextView(matcher) {
        withId(R.id.option_label)
    }
}