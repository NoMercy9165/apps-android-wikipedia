package org.wikipedia.homeworks.homeworks20

class HierarchyClass(val name: String, val parent: HierarchyClass? = null) {

    fun withParent(newName: String): HierarchyClass {
        return HierarchyClass(newName, this)
    }

    override fun toString(): String {
        return if (parent == null) name
        else "$parent : $name"
    }
}