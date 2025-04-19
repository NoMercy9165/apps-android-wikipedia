package org.wikipedia.homeworks.homework19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.onboarding.OnboardingScreens
import org.wikipedia.homeworks.homework09.CardItem
import org.wikipedia.homeworks.homework09.ExploreScreens
import org.wikipedia.homeworks.homework09.InTheNewCardItem
import org.wikipedia.main.MainActivity

class TestClass: TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testing() = run {
        steps {
            click(OnboardingScreens.skipButton, "Skip button")
            ExploreScreens.feedList.childAt<InTheNewCardItem>(7) {
                hasText(header, "In the news")
                isVisible(headerMenu, "Header menu")
                isVisible(sliderCard, "Slider card")
            }
            ExploreScreens.feedList.childAt<InTheNewCardItem>(7) {
                sliderCard.childAt<CardItem>(2) {
                    isVisible(listText, "List text")
                    isVisible(listImage, "List image")
                }
            }
            disableNetwork(device)
            enableNetwork(device)
            setOrientationLeft(device)
            setOrientationRight(device)
            setOrientationNatural(device)
        }
    }
}