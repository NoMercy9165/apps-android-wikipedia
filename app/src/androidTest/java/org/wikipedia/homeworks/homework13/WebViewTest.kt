package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework08.onboarding.OnboardingScreens
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
            step("Click skip on Onboadrinding screen") {
                OnboardingScreens.skipButton.click()
            }
            step("Click on the article in the Featured block") {
                ExploreScreen.items.childWith<InTheNewsCardItem> {
                    withDescendant { withText("Territorial Force") }
                }.perform {
                    click()
                }
            }
            step("Scroll to element with id Bibliography") {
                ArticleViewScreen.webView {
                    withElement(Locator.XPATH, "//h2[@id='Bibliography']") {
                        this.scroll()
                    }
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
                    withElement(Locator.XPATH, "//a[@id='back_link_cite_note-5']") {
                        this.click()
                    }
                }
            }
            step("Click on the fifth link in the article") {
                flakySafely(timeoutMs = 3000) {
                    ArticleViewScreen.webView {
                        withElement(Locator.XPATH, "//*[@id='cite_ref-5']/a") {
                            this.click()
                        }
                    }
                }
            }
            step("Check for compliance of title text and line number") {
                ModalWindowScreen.slider.childAt<ModalWindowPagerItem>(1) {
                    referenceId.isDisplayed()
                    referenceId.containsText("5")

                    referenceText.isDisplayed()
                    referenceText.containsText("Hay pp.")
                }
            }
            step("Use the back button to close the pop-up window") {
                repeat(2) {
                    device.uiDevice.pressBack()
                }
            }
            step("Find the second link with the CSS class mw-redirect and click on it") {
                ArticleViewScreen.webView {
                    withElement(Locator.XPATH, "//a[@class='mw-redirect' and text()='Gallipoli']") {
                        this.click()
                    }
                }
            }
            step("Click the button to go to a new article") {
                BottomSheetArticleScreen.readArticleButton.click()
                Thread.sleep(6000)
            }
        }
    }
}