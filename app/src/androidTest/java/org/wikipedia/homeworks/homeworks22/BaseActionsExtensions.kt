package org.wikipedia.homeworks.homeworks22

import io.github.kakaocup.kakao.common.actions.BaseActions

fun BaseActions.haIdAction(targetId: Int): Boolean {
    val checker = HasIdAction(targetId)
    view.perform(checker)
    return checker.isMatched()
}