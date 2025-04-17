package org.wikipedia.homeworks.homeworks20

import io.github.kakaocup.kakao.common.actions.BaseActions

val names = mutableMapOf<BaseActions, HierarchyClass>()

fun <T: BaseActions> T.name(hierarchyClass: HierarchyClass): T {
    names[this] = hierarchyClass
    return this
}

fun BaseActions.getName(): HierarchyClass {
    return names[this] ?: throw IllegalStateException("Name is not set")
}

fun BaseActions.withParent(newName: String) = getName().withParent(newName)
