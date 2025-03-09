package org.wikipedia.homeworks.homework10

import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiTest: TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun textFirstElement() {
        run {
            step("First screen elements") {
                OnboardingUiScreen.imageView.isDisplayed()
                OnboardingUiScreen.primaryText.isDisplayed()
                OnboardingUiScreen.secondaryText.isDisplayed()
                OnboardingUiScreen.items.isDisplayed()
                OnboardingUiScreen.addLanguageButton.isDisplayed()
                OnboardingUiScreen.skipButton.isDisplayed()
                OnboardingUiScreen.continueButton.isDisplayed()
                OnboardingUiScreen.getStartedButton.isDisplayed()
            }
        }
    }


    @Test
    fun testCheckingTextSecondScreen() {
        run {
            step("Checking text on first screen tab") {
                OnboardingUiScreen {
                    step("Next button click") {
                        continueButton.click()
                    }
                    step("Checking text on second screen") {
                        primaryText.hasAnyText()
                    }
                }
            }
        }
    }


    @Test
    fun testCheckingTextThirdScreen() {
        run {
            step("Checking text on first screen tab") {
                OnboardingUiScreen {
                    step("Next button click") {
                        continueButton.click()
                    }
                    step("Next button click") {
                        continueButton.click()
                    }
                    step("Checking text on third screen") {
                        primaryText.hasText("New ways to explore")
                    }
                }
            }
        }
    }


    @Test
    fun testContinueButtonDoubleClick() {
        run {
            OnboardingUiScreen {
                step("Continue Button Click go to Second Tab") {
                    continueButton.click()
                }
                step("Continue Button Click go to Third tab") {
                    continueButton.click()
                }
                step("Continue Button Click go to Fourth tab") {
                    continueButton.click()
                }
                step("Checking four screen") {
                    items.isNotDisplayed()
                    getStartedButton.isDisplayed()
                }
            }
        }
    }
}