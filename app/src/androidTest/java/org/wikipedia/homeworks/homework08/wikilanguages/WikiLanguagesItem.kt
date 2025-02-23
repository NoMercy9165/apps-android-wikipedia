package org.wikipedia.homeworks.homework08.wikilanguages

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class WikiLanguagesItem(matcher: Matcher<View>) : KRecyclerItem<WikiLanguagesItem>(matcher) {

    val languageOrder = KTextView(matcher) {
        withId(R.id.wiki_language_order)
    }

    val checkBox = KCheckBox(matcher) {
        withId(R.id.wiki_language_checkbox)
    }

    val languageCode = KTextView(matcher) {
        withId(R.id.langCodeText)
    }

    val languageTitle = KTextView(matcher) {
        withId(R.id.wiki_language_title)
    }

    val dragHandle = KImageView(matcher) {
        withId(R.id.wiki_language_drag_handle)
    }
}