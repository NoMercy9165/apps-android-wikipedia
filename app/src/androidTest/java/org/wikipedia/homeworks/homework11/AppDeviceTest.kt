package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.onboarding.OnboardingScreens
import org.wikipedia.homeworks.homework09.ExploreScreens
import org.wikipedia.main.MainActivity
import java.util.Locale

class AppDeviceTest : TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @After
    fun tearDown() {
        device.uiDevice.setOrientationNatural()
        device.network.enable()
        device.language.switchInApp(Locale.getDefault())
        device.uiDevice.wakeUp()
    }


    @Test
    fun orientationTest() {
        run {
            step("Onboarding skip button click") {
                OnboardingScreens.skipButton.click()
            }
            step("Rotate screen and check orientation") {
                device.uiDevice.setOrientationLeft()
                Thread.sleep(5000)
            }
            step("Check orientation not Natural") {
                assert(!device.uiDevice.isNaturalOrientation)
            }
            step("Rotate screen to Natural") {
                device.uiDevice.setOrientationNatural()
                Thread.sleep(5000)
            }
            step("Check orientation Natural") {
                assert(device.uiDevice.isNaturalOrientation)
            }
        }
    }


    @Test
    fun testScreenOffOn() {
        run {
            step("Onboarding skip button click") {
                OnboardingScreens.skipButton.click()
            }
            step("Turn display off and on") {
                device.uiDevice.sleep()
                Thread.sleep(5000)
                device.uiDevice.wakeUp()
                Thread.sleep(5000)
            }
            step("Check screen is on") {
                assert(device.uiDevice.isScreenOn)
            }
        }
    }


    @Test
    fun testCurrentActivity() {
        run {
            step("Onboarding skip button click") {
                OnboardingScreens.skipButton.click()
            }
            step("Check current activity") {
                device.activities.isCurrent(MainActivity::class.java)
            }
        }
    }


    @Test
    fun testAppMinimizeAndRestore() {
        run {
            step("Onboarding skip button click") {
                OnboardingScreens.skipButton.click()
            }
            step("Minimize and restore app") {
                step("Press home button") {
                    device.uiDevice.pressHome()
                }
                step("Double tap on RecentApps button") {
                    device.uiDevice.pressRecentApps()
                    device.uiDevice.pressRecentApps()
                }
                ExploreScreens.toolBar.isDisplayed()
            }
            step("Check toolbar is displayed") {
                ExploreScreens.toolBar.isDisplayed()
            }
        }
    }


    @Test
    fun testLanguageChange() {
        before { }.after { device.language.switchInApp(Locale.getDefault()) }.run {
            step("Change app language") {
                step("Change app language to Germany") {
                    device.language.switchInApp(Locale.GERMANY)
                }
                step("Check continue button text") {
                    OnboardingScreens.continueButton.hasText("Fortfahren")
                }
            }
        }
    }
}