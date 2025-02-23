package org.wikipedia.homeworks.homework08.onboarding

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object OnboardingScreens : KScreen<OnboardingScreens>() {

    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = null

    val slider = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::OnboardingPagerFirstItem)
        }
    )

    val skipButton = KButton() {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val continueButton = KButton() {
        withId(R.id.fragment_onboarding_forward_button)
    }

    val getStartedButton = KButton() {
        withId(R.id.fragment_onboarding_done_button)
    }

}
