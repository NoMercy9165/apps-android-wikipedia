package org.wikipedia.homeworks.homeworks20

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndex(index: Int, function: T.() -> Unit) {
    val recycler = this
    childAt<T>(index) {
        name(recycler.name().withParent("$index"))
        function()
    }
}


inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtDescendantText(
    descendantText: String,
    function: T.() -> Unit
) {
    val recycler = this
    val item = childWith<T>(
        childMatcher = {
            withDescendant {
                withText(descendantText)
            }
        }
    )
    item.name(recycler.name().withParent(descendantText))
    item.function()
}