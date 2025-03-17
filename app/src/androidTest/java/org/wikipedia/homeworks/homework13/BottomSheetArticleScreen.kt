package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object BottomSheetArticleScreen: KScreen<BottomSheetArticleScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val image = KImageView {
        withId(R.id.link_preview_thumbnail)
    }

    val title = KTextView {
        withId(R.id.link_preview_title)
    }

    val actionButton = KImageView {
        withId(R.id.link_preview_overflow_button)
    }


    val openNewTabButton = KButton {
        withId(R.id.link_preview_secondary_button)
    }

    val readArticleButton = KButton {
        withId(R.id.link_preview_primary_button)
    }

}