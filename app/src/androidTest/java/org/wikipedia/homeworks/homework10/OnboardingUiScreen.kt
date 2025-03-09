package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen : UiScreen<OnboardingUiScreen>() {
    override val packageName: String
        get() = "org.wikipedia.alpha"


    val viewPager = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "fragment_pager")
    }

    val imageView = UiView {
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }


    val primaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val secondaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val items = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "languagesList")
    }

    val addLanguageButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "addLanguageButton")
    }

    val skipButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }


    val getStartedButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_done_button")
    }




}