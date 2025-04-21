package org.wikipedia.homeworks.homeworks22

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.wikipedia.R.*
import org.wikipedia.homeworks.homeworks20.ExploreScreenNew
import org.wikipedia.test.R

fun ExploreScreenNew.searchBlock(): KRecyclerItem<*> {
    return items.findById<KRecyclerItem<*>>(
        targetIndex = 0,
        targetId = id.search_container,
        limit = 5,
        blockName = "Search"
    )
}


fun ExploreScreenNew.customizeBlock(): KRecyclerItem<*> {
    return items.findById<KRecyclerItem<*>>(
        targetIndex = 1,
        targetId = id.view_announcement_container,
        limit = 5,
        blockName = "Customize"
    )
}