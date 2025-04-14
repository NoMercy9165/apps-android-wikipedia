package org.wikipedia.homeworks.homework19

import androidx.annotation.StringRes
import androidx.test.uiautomator.UiDevice
import com.kaspersky.components.kautomator.component.check.UiCheckableAssertions
import com.kaspersky.kaspresso.device.network.Network
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.homeworks20.getName

class Steps(val testContext: TestContext<*>) {

    private fun execute(textOfStep: String, action: (StepInfo) -> Unit) {
        testContext.step(textOfStep, action)
    }

    operator fun invoke(function: Steps.() -> Unit) {
        function()
    }

    fun click(item: BaseActions) {
        execute("Click ${item.getName()}") {
            item.click()
        }
    }

    fun isVisible(item: BaseAssertions) {
        execute("$item.ge is displayed") {
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

    fun setOrientationNatural(device: UiDevice) {
        execute("Set orientation to natural") {
            device.setOrientationNatural()
        }

    }

    fun setOrientationRight(device: UiDevice) {
        execute("Set orientation to right") {
            device.setOrientationRight()
        }
    }

    fun setOrientationLeft(device: UiDevice) {
        execute("Set orientation to left") {
            device.setOrientationLeft()
        }
    }

    fun setChecked(item: CheckableActions, checked: Boolean) {
        execute("Set checkbox to $checked") {
            item.setChecked(checked)
        }
    }

    fun hasText(item: TextViewAssertions, @StringRes resId: Int) {
        execute("Check if text is ${testContext.getString(resId)}") {
            item.hasText(resId)
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

    fun enableNetwork(device: Network) {
        execute("Enable network") {
            device.enable()
        }
    }

    fun disableNetwork(device: Network) {
        execute("Disable network") {
            device.disable()
        }
    }


    fun typeText(item: EditableActions, text: String) {
        execute("Type text $text") {
            item.typeText(text)
        }
    }



}