package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.common.views.KView
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.onboarding.OnboardingScreens
import org.wikipedia.main.MainActivity

class EndToEndTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun check() {
        run {
            step("Skip onboarding screen") {
                OnboardingScreens.skipButton.click()
            }
            step("Find the block In the news") {
                ExploreScreens.feedList.childWith<InTheNewCardItem> {
                    withDescendant {
                        withText(R.string.view_card_news_title)
                    }

                }.perform {
                    step("Check header in the block news") {
                        header.hasText("In the news")
                    }
                    step("Click on the third article in the list") {
                        sliderCard.childAt<CardItem>(2) {
                            listImage.click()
                        }
                    }
                }
            }
            step("Click on the second article in the list") {
                StoryList.items.childAt<NewsStoryItem>(1) {
                    title.click()
                }
            }
            step("Check that the element with the identifier page_web_view is displayed") {
                KView { withId(R.id.page_web_view) }.isDisplayed()
            }
        }
    }
}



