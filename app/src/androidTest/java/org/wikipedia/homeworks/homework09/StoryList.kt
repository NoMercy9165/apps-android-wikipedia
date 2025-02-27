package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object StoryList: KScreen<StoryList>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null


    val text = KTextView {
        withId(R.id.story_text_view)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.news_story_items_recyclerview)
        },
        itemTypeBuilder = {
            itemType(::NewsStoryItem)
        }
    )



}