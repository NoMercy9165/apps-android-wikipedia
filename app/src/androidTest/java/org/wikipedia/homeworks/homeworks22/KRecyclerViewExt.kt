package org.wikipedia.homeworks.homeworks22

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.homeworks.homeworks20.name
import kotlin.math.min

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeById(
    targetIndex: Int,
    targetId: Int,
    blockName: String,
    limit: Int,
    function: T.() -> Unit
) {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limit, recycler.getSize())
    recycler.getSize()
    for (i in 0 until max) {
        childAt<T>(i) {
            if (haIdAction(targetId)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                name(recycler.name().withParent("$targetIndex block of $blockName"))
                function()
                return
            }
        }
    }
    throw NoSuchElementException("Not found block with $targetIndex index of $blockName")
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.findById(
    targetIndex: Int,
    targetId: Int,
    limit: Int,
    blockName: String,
): T {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limit, recycler.getSize())
    recycler.getSize()
    for (i in 0 until max) {
        childAt<T>(i) {
            if (haIdAction(targetId)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                name(recycler.name().withParent("$targetIndex block of $blockName"))
                return this
            }
        }
    }
    throw NoSuchElementException("Not found block with $targetIndex index of $blockName")
}