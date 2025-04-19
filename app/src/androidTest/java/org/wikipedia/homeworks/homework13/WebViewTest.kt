package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework07.TopReadCardItem
import org.wikipedia.homeworks.homework08.onboarding.OnboardingScreens
import org.wikipedia.homeworks.homework19.Steps
import org.wikipedia.homeworks.homework19.steps
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.default().apply {
        viewActionWatcherInterceptors.add(AutoScrollViewInterceptor())
    }
) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun test() {
        run {
            steps {
                click(OnboardingScreens.skipButton, "Skip button")
                ExploreScreen.items.childAt<TopReadCardItem>(3) {
                    isVisible()
                    click()
                }

            }

            step("Check the text in the element with the id References") {
                ArticleViewScreen.webView {
                    withElement(Locator.XPATH, "//h2[@id='References']") {
                        hasText("References")
                        this.click()
                    }
                }
            }
            step("Сlick on the fifth link") {
                ArticleViewScreen.webView {
                    withElement(Locator.XPATH, "//*[@id=\"back_link_cite_note-Ivins1-5\"]") {
                        this.click()
                    }
                }
            }
            step("Click on the fifth link in the article") {
                flakySafely(timeoutMs = 3000) {
                    ArticleViewScreen.webView {
                        withElement(Locator.XPATH, "//*[@id=\"cite_ref-Ivins1_5-0\"]/a") {
                            this.click()
                        }
                    }
                }
            }
            step("Use the back button to close the pop-up window") {
                repeat(2) {
                    device.uiDevice.pressBack()
                }
            }
        }
    }
}