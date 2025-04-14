package org.wikipedia.homeworks20

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.screen.Screen

abstract class NamedKScreen<out T : KScreen<T>> : KScreen<T>() {

    abstract val screenName: String
    val hierarchyClass by lazy { HierarchyClass(screenName) }

    fun withParent(newName: String) = hierarchyClass.withParent(newName)

}