package org.wikipedia.homeworks20

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndex(
    index: Int,
    function: T.() -> Unit
) {
    val recycler = this
    childAt<T>(index) {
        name(recycler.getName().withParent("$index"))
        function()
    }
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeWithText(
    text: String,
    function: T.() -> Unit
): T {
    val recycler = this
    return childWith<T> {
        withDescendant { withText(text) }
    }.apply {
        name(recycler.getName().withParent("withText $text"))
        function()
    }
}
