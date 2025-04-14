package org.wikipedia.homeworks20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.onboarding.OnboardingScreens
import org.wikipedia.homeworks.homework19.steps

import org.wikipedia.main.MainActivity

class TestForHomeworks20: TestCase() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    fun simpleTest() = run {
        steps {
            click(OnboardingScreens.skipButton)
            ExploreScreenNew.inTheNewsCardItem {
                tabNewsItem(3) {
                    click(this)
                }
            }
        }
    }
}