package org.wikipedia.homeworks.homework05

import android.widget.LinearLayout
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

class FontSettingsScreen {
    val sansSerifButton = KButton {
        withId(R.id.button_font_family_sans_serif)
        withText(R.string.font_family_sans_serif)
    }

    val serifButton = KButton {
        withId(R.id.button_font_family_serif)
        withText(R.string.font_family_serif)
    }

    val textSizeSeekBar = KSeekBar {
        withId(R.id.text_size_seek_bar)
        withParent { isInstanceOf(LinearLayout::class.java) }
    }

    val textSize = KTextView {
        withId(R.id.text_size_percent)
    }

    val readingModeToggle = KSwitch {
        withId(R.id.theme_chooser_reading_focus_mode_switch)
        withText(R.string.reading_focus_mode)
    }

    val colorThemeLabel = KTextView {
        withText(R.string.color_theme_select)
    }

    val buttonThemeLight = KButton {
        withId(R.id.button_theme_light)
    }

    val buttonThemeDark = KButton {
        withId(R.id.button_theme_dark)
    }

    val buttonThemeSepia = KButton {
        withId(R.id.button_theme_sepia)
    }

    val buttonThemeBlack = KButton {
        withId(R.id.button_theme_black)
    }

    val themeButtons = listOf(buttonThemeLight, buttonThemeSepia, buttonThemeDark, buttonThemeBlack)

    val systemThemeMatchSwitch = KSwitch {
        withId(R.id.theme_chooser_match_system_theme_switch)
        withText(R.string.theme_chooser_dialog_match_system_theme_switch_label)
    }

    val imageDimmingSwitch = KSwitch {
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
        withText(R.string.theme_chooser_dialog_image_dimming_switch_label)
    }


}