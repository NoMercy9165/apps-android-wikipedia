package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ModalWindowScreen : KScreen<ModalWindowScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null


    val titleText = KTextView {
        withId(R.id.reference_title_text)
    }

    val indicator = KView {
        withId(R.id.indicator_divider)
    }

    val tab = KTabLayout {
        withId(R.id.page_indicator_view)
    }

    val slider = KViewPager2(
        builder = {
            withId(R.id.reference_pager)
        },
        itemTypeBuilder = {
            itemType(::ModalWindowPagerItem)
        }
    )
}