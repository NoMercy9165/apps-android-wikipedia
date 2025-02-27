package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ExploreScreen

object ExploreScreens: KScreen<ExploreScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null


    val toolBar = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }


    val feedList = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::InTheNewCardItem)
        }
    )

}