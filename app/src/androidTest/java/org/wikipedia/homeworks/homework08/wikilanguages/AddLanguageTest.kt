package org.wikipedia.homeworks.homework08.wikilanguages

import android.widget.ImageButton
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.text.KButton
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.onboarding.ListLanguageItem
import org.wikipedia.homeworks.homework08.onboarding.OnboardingPagerFirstItem
import org.wikipedia.homeworks.homework08.onboarding.OnboardingScreens
import org.wikipedia.main.MainActivity

class AddLanguageTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun test() {
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
                KButton {
                    isDescendantOfA { withId(R.id.toolbar) }
                    isInstanceOf(ImageButton::class.java)
                }.click()
            }
            step("Verifying that the added language has been added to the list on the onboarding screen") {
                OnboardingScreens.slider.childAt<OnboardingPagerFirstItem>(0) {
                    languages.childWith<ListLanguageItem> {
                        withText("3.\t\tEspañol")
                    }.isDisplayed()
                }
            }
        }
    }
}