package org.wikipedia.homeworks.homeworks21

import io.github.kakaocup.kakao.image.ImageViewAssertions

fun ImageViewAssertions.hasAnyDrawable() {
    view.check(AnyDrawable())
}

fun ImageViewAssertions.noDrawable() {
    view.check(NoDrawable())
}