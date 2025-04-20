package org.wikipedia.homeworks.homeworks21

import io.github.kakaocup.kakao.check.CheckableActions


fun CheckableActions.switchCheck() {
    view.perform(CheckBoxChecked())
}