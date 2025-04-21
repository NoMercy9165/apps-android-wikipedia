package org.wikipedia.homeworks.homeworks20

import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.homeworks.homeworks21.CustomViewAction

val actionsNames = mutableMapOf<BaseActions, NameHierarchy>()

fun <T : BaseActions> T.name(nameHierarchy: NameHierarchy): T {
    actionsNames[this] = nameHierarchy
    return this
}

fun BaseActions.name(): NameHierarchy {
    return actionsNames[this] ?: throw IllegalStateException("Name not set")
}


fun BaseActions.withParent(elementName: String) = name().withParent(elementName)


fun BaseActions.customClick() {
    view.perform(CustomViewAction())
}