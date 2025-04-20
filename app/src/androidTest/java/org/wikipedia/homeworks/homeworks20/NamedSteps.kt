package org.wikipedia.homeworks.homeworks20

import com.kaspersky.kaspresso.device.Device
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions

class NamedSteps(val testContext: TestContext<*>) {

    private fun execute(textOfStep: String, action: (StepInfo) -> Unit) {
        testContext.step(textOfStep, action)
    }

    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
    }

    fun click(item: BaseActions) {
        execute("Click to ${item.getName()}") {
            item.click()
        }
    }

    fun isVisible(item: BaseAssertions) {
        execute("Check that is visible '${(item as BaseActions).getName()}'") {
            item.isVisible()
        }
    }

    fun pressBack(device: Device) {
        execute("Press back") {
            device.uiDevice.pressBack()
        }
    }
}