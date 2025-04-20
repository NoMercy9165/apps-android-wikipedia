package org.wikipedia.homeworks.homeworks20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val namedStepMap = mutableMapOf<TestContext<*>, NamedSteps>()

val TestContext<*>.namedSteps: NamedSteps
    get() {
        return namedStepMap.getOrPut(this) { NamedSteps(this) }
    }
