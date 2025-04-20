package org.wikipedia.homeworks.homeworks21

import io.github.kakaocup.kakao.common.assertions.BaseAssertions


fun BaseAssertions.customCheckText(text: String) {
    view.check(CustomViewAssertions(text))
}