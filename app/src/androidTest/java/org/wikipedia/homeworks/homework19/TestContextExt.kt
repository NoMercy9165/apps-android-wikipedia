package org.wikipedia.homeworks.homework19

import androidx.annotation.StringRes
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

val TestContext<*>.steps: Steps
    get() = Steps(this)

fun TestContext<*>.getString(@StringRes resId: Int): String {
    return device.targetContext.getString(resId)
}