package org.wikipedia.homeworks.homework03

import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView


data class UiElement(
    val viewClass: Class<*>,
    val id: String,
    val contentDescription: String = ""
)

val skipButton = UiElement(
    viewClass = Button::class.java,
    id = "fragment_onboarding_skip_button",
    contentDescription = "onboarding_skip"
)

val continueButton = UiElement(
    viewClass = Button::class.java,
    id = "fragment_onboarding_forward_button",
    contentDescription = "onboarding_continue"
)

val addLanguageButton = UiElement(
    viewClass = Button::class.java,
    id = "addLanguageButton",
    contentDescription = "onboarding_multilingual_add_language_text"
)

val tabLayout = UiElement(
    viewClass = TabLayout::class.java,
    id = "view_onboarding_page_indicator"
)

val listLanguages = UiElement(
    viewClass = RecyclerView::class.java,
    id = "languagesList"
)

val centralLogo = UiElement(
    viewClass = ImageView::class.java,
    id = "imageViewCentered"
)

val headerUnderLogo = UiElement(
    viewClass = AppTextView::class.java,
    id = "primaryTextView"
)

val subtitle = UiElement(
    viewClass = AppTextView::class.java,
    id = "secondaryTextView",
    contentDescription = "onboarding_multilingual_secondary_text"
)

val languageLabel = UiElement(
    viewClass = AppTextView::class.java,
    id = "option_label"
)