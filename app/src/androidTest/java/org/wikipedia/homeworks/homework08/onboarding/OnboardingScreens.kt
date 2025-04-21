package org.wikipedia.homeworks.homework08.onboarding

import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homeworks20.NamedKScreen
import org.wikipedia.homeworks.homeworks20.name

object OnboardingScreens : NamedKScreen<OnboardingScreens>() {

    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = null
    override val screenName = "Onboarding"

    val slider = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::OnboardingPagerFirstItem)
        }
    )

    val skipButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_skip_button)
        }.name(withParent("Skip button"))
    }

    val continueButton = KButton() {
        withId(R.id.fragment_onboarding_forward_button)
    }

    val getStartedButton = KButton() {
        withId(R.id.fragment_onboarding_done_button)
    }

}
