package org.wikipedia.examples

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.ListTopReadCardItem
import org.wikipedia.homeworks.homework07.SearchCardItem
import org.wikipedia.homeworks.homework07.TopReadCardItem
import org.wikipedia.main.MainActivity

class ExploreScreenTests : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        run {
            step("Skipping") {
                OnboardingScreen.skipButton.click()
            }
            step("Проверяет отображение тулбара") {
                ExploreScreen.toolbarTitle.isDisplayed()
            }
            step("Checking logo of mic in search") {
                ExploreScreen.items.childAt<SearchCardItem>(0) {
                    voice.isDisplayed()
                }
            }
            step("Checking has logo in 2nd child in topRead") {
                ExploreScreen.items.swipeUp()
                ExploreScreen.items.childAt<TopReadCardItem>(4) {
                    step("TopReadCardViewItem.isDisplayed()") {
                        isDisplayed()
                    }
                    topReadList.childAt<ListTopReadCardItem>(1) {
                        cardImage.isDisplayed()
                    }
                }
            }
        }
    }
}
