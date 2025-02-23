package org.wikipedia.homeworks.homework03

import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.views.AppTextView


object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId = null
    override val viewClass: Class<*>? = null

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }
}


//val skipButton = OnboardingScreen(
//    viewClass = Button::class.java,
//    id = "fragment_onboarding_skip_button",
//    contentDescription = "onboarding_skip"
//)
//
//val continueButton = OnboardingScreen(
//    viewClass = Button::class.java,
//    id = "fragment_onboarding_forward_button",
//    contentDescription = "onboarding_continue"
//)
//
//val addLanguageButton = OnboardingScreen(
//    viewClass = Button::class.java,
//    id = "addLanguageButton",
//    contentDescription = "onboarding_multilingual_add_language_text"
//)
//
//val tabLayout = OnboardingScreen(
//    viewClass = TabLayout::class.java,
//    id = "view_onboarding_page_indicator"
//)
//
//val listLanguages = OnboardingScreen(
//    viewClass = RecyclerView::class.java,
//    id = "languagesList"
//)
//
//val centralLogo = OnboardingScreen(
//    viewClass = ImageView::class.java,
//    id = "imageViewCentered"
//)
//
//val headerUnderLogo = OnboardingScreen(
//    viewClass = AppTextView::class.java,
//    id = "primaryTextView"
//)
//
//val subtitle = OnboardingScreen(
//    viewClass = AppTextView::class.java,
//    id = "secondaryTextView",
//    contentDescription = "onboarding_multilingual_secondary_text"
//)
//
//val languageLabel = OnboardingScreen(
//    viewClass = AppTextView::class.java,
//    id = "option_label"
