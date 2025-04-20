package org.wikipedia.homeworks.homeworks20

import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import org.wikipedia.homeworks.homeworks21.CustomViewAction

val actionsNames = mutableMapOf<BaseActions, NameHierarchy>()
val assertionsNames = mutableMapOf<BaseAssertions, NameHierarchy>()

fun <T : BaseActions> T.getName(nameHierarchy: NameHierarchy): T {
    actionsNames[this] = nameHierarchy
    return this
}

fun BaseActions.getName(): NameHierarchy {
    return actionsNames[this] ?: throw IllegalStateException("Name not set")
}


fun BaseActions.withParent(elementName: String) = getName().withParent(elementName)


fun BaseActions.customClick() {
    view.perform(CustomViewAction())
}