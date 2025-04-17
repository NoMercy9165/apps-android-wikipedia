package org.wikipedia.homeworks.homework18

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.common.views.KView
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.onboarding.ListLanguageItem
import org.wikipedia.homeworks.homework08.onboarding.OnboardingPagerFirstItem
import org.wikipedia.homeworks.homework08.onboarding.OnboardingScreens
import org.wikipedia.homeworks.homework08.wikilanguages.AddButtonItem
import org.wikipedia.homeworks.homework08.wikilanguages.LanguageListItem
import org.wikipedia.homeworks.homework08.wikilanguages.LanguagesListScreen
import org.wikipedia.homeworks.homework08.wikilanguages.WikipediaLanguagesScreens
import org.wikipedia.homeworks.homework09.CardItem
import org.wikipedia.homeworks.homework09.ExploreScreens
import org.wikipedia.homeworks.homework09.InTheNewCardItem
import org.wikipedia.homeworks.homework09.NewsStoryItem
import org.wikipedia.homeworks.homework09.StoryList
import org.wikipedia.main.MainActivity

class EndToEndTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

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

    @Test
    fun addLanguageTest() {
        run {
            step("Click on the add language button on the onboarding screen") {
                OnboardingScreens.slider.childAt<OnboardingPagerFirstItem>(0) {
                    addLanguageButton.click()
                }
            }
            step("Click on the add language button on the list of languages") {
                WikipediaLanguagesScreens.items.childWith<AddButtonItem> {
                    withDescendant { withText("Add language") }
                }.languageTitle.click()
            }
            step("Select a language from the list and click on it") {
                LanguagesListScreen.listLanguages.childWith<LanguageListItem> {
                    withDescendant { withText("Spanish") }
                }.click()
            }
            step("Click on the back button in the toolbar to return to the onboarding screen") {
                WikipediaLanguagesScreens.backButton.click()
            }

            step("Verifying that the added language has been added to the list on the onboarding screen") {
                OnboardingScreens.slider.childAt<OnboardingPagerFirstItem>(0) {
                    languages.childAt<ListLanguageItem>(0) {
                        containsText("English")
                    }
                }
            }
        }
    }
}