package org.wikipedia.homeworks.homework08.onboarding

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class FirstScreenOnboardingTests : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun checkLanguageInList() {
        run {
            step("Opening the first screen and checking the language display") {
                OnboardingScreens.slider.childAt<OnboardingPagerFirstItem>(0) {
                    languages.childWith<ListLanguageItem> {
                        withText("1.\t\tEnglish")
                    }.isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkImage() {
        run {
            step("Opening the first screen and checking the image display") {
                OnboardingScreens.slider.childAt<OnboardingPagerFirstItem>(0) {
                    image.isDisplayed()
                }
            }
        }
    }


    @Test
    fun checkHeader() {
        run {
            step("Opening the first screen and checking the language display") {
                OnboardingScreens.slider.childAt<OnboardingPagerFirstItem>(0) {
                    header.isDisplayed()
                }
            }
        }
    }


    @Test
    fun checkDescription() {
        run {
            step("Opening the first screen and checking the language display") {
                OnboardingScreens.slider.childAt<OnboardingPagerFirstItem>(0) {
                    description.isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkSkipButton() {
        run {
            step("Opening the first screen and checking the skip button") {
//                OnboardingScreens.skipButton
            }
        }
    }


    @Test
    fun checkContinueButton() {
        run {
            step("Opening the first screen and checking the continue button") {
                OnboardingScreens.continueButton.isDisplayed()
            }
        }
    }


    @Test
    fun checkGetStartButton() {
        run {
            step("Opening the fourth screen") {
                OnboardingScreens.slider.childAt<OnboardingPagerFirstItem>(3) {
                    isDisplayed()
                }
            }
            step("Checking the get started button") {
                OnboardingScreens.getStartedButton.isDisplayed()
            }
        }
    }

    @Test
    fun checkButtonAddLanguage() {
        run {
            step("Opening the first screen and checking the add language button") {
                OnboardingScreens.slider.childAt<OnboardingPagerFirstItem>(0) {
                    addLanguageButton.isDisplayed()
                }
            }
        }
    }
}