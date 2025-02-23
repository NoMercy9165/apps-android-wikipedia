package org.wikipedia.homeworks.homework08.wikilanguages

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object WikipediaLanguagesScreens : KScreen<WikipediaLanguagesScreens>() {
    override val layoutId: Int = R.layout.fragment_wikipedia_languages
    override val viewClass: Class<*>? = null

    val toolbar = KToolbar {
        withId(R.id.toolbar)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.wikipedia_languages_recycler)
        },
        itemTypeBuilder = {
            itemType(::HeaderItem)
            itemType(::WikiLanguagesItem)
            itemType(::AddButtonItem)
        }
    )
}