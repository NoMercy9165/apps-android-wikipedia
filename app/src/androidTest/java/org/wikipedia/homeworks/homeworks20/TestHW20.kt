package org.wikipedia.homeworks.homeworks20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.onboarding.OnboardingScreens
import org.wikipedia.homeworks.homework13.ArticleViewScreen
import org.wikipedia.homeworks.homework13.ArticleViewScreen.header
import org.wikipedia.main.MainActivity

class TestHW20: TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun test() = run {
        namedSteps {
            click(OnboardingScreens.skipButton)
            ExploreScreenNew.topReadItemText {
                isVisible(cardHeader)
                isVisible(cardHeaderMenu)
                listTopRead(2) {
                    isVisible(rank)
                    isVisible(titles)
                    isVisible(cardImage)
                    click(cardImage)
                }
            }
            ArticleViewScreen.webView {
                isVisible(header)
            }
            pressBack(device)
            ExploreScreenNew {
                isVisible(toolbarTitle)
            }
        }
    }
}