package org.wikipedia.homeworks.homework08.wikilanguages

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object LanguagesListScreen: KScreen<LanguagesListScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null
w
    val searchEmptyText = KTextView {
        withId(R.id.search_empty_text)
    }

    val lope = KImageView {
        withDrawable(R.drawable.ic_search_white_24dp)
    }

    val listLanguages = KRecyclerView(
        builder = {
            withId(R.id.languages_list_recycler)
        },
        itemTypeBuilder = {
            itemType(::LanguageHeaderItem)
            itemType(::LanguageListItem)

        }
    )
}