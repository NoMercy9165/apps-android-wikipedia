package org.wikipedia.homeworks.homework08.wikilanguages

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguageListItem(matcher: Matcher<View>) : KRecyclerItem<LanguageListItem>(matcher) {


    val languageName = KTextView(matcher) {
        withId(R.id.localized_language_name)
    }

    val languageSubtitle = KTextView(matcher) {
        withId(R.id.language_subtitle)
    }

}