package org.wikipedia.homeworks.homeworks21

import io.github.kakaocup.kakao.text.TextViewActions

fun TextViewActions.getText(): String {
    val getter = GetText()
    view.perform(getter)
    return getter.getText()
}