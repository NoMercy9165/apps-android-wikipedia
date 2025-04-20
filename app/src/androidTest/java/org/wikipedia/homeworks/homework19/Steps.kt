package org.wikipedia.homeworks.homework19

import androidx.annotation.StringRes
import androidx.test.uiautomator.UiDevice
import com.kaspersky.components.kautomator.component.check.UiCheckableAssertions
import com.kaspersky.kaspresso.device.Device
import com.kaspersky.kaspresso.device.network.Network
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions


class Steps(val testContext: TestContext<*>) {

    private fun execute(textOfStep: String, action: (StepInfo) -> Unit) {
        testContext.step(textOfStep, action)
    }

    operator fun invoke(function: Steps.() -> Unit) {
        function()
    }

    fun click(item: BaseActions, name: String) {
        execute("$name click") {
            item.click()
        }
    }

    fun isVisible(item: BaseAssertions, name: String) {
        execute("$name is visible") {
            item.isVisible()
        }
    }

    fun sleep(millis: Long) {
        execute("$millis pause") {
            Thread.sleep(millis)
        }
    }

    fun isDisplayed(item: BaseAssertions, name: String) {
        execute("$name is displayed") {
            item.isDisplayed()
        }
    }

    fun setOrientationNatural(device: Device) {
        execute("Set orientation to natural") {
            device.uiDevice.setOrientationNatural()
        }

    }

    fun setOrientationRight(device: Device) {
        execute("Set orientation to right") {
            device.uiDevice.setOrientationRight()
        }
    }

    fun setOrientationLeft(device: Device) {
        execute("Set orientation to left") {
            device.uiDevice.setOrientationLeft()
        }
    }

    fun setChecked(item: CheckableActions, checked: Boolean) {
        execute("Set checkbox to $checked") {
            item.setChecked(checked)
        }
    }

    fun hasText(item: TextViewAssertions, string: String) {
        execute("Check if text is $string") {
            item.hasText(string)
        }
    }

    fun hasAnyText(item: TextViewAssertions) {
        execute("Check if text is $item}") {
            item.hasAnyText()
        }
    }

    fun isChecked(item: UiCheckableAssertions) {
        execute("Check if checkbox is checked") {
            item.isChecked()
        }
    }

    fun isNotChecked(item: UiCheckableAssertions) {
        execute("Check if checkbox is unchecked") {
            item.isNotChecked()
        }
    }

    fun containsText(item: TextViewAssertions, text: String) {
        execute("Check if text is $text") {
            item.containsText(text)
        }
    }

    fun enableNetwork(device: Device) {
        execute("Enable network") {
            device.network.enable()
        }
    }

    fun disableNetwork(device: Device) {
        execute("Disable network") {
            device.network.disable()
        }
    }


    fun typeText(item: EditableActions, text: String) {
        execute("Type text $text") {
            item.typeText(text)
        }
    }


    fun pressBack(device: Device) {
        execute("Press back") {
            device.uiDevice.pressBack()
        }
    }


}