package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeBlockCardItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeBlockCardItem>(matcher) {

    val headerImage = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }

    val textInBlock = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }

    val buttonCustomize = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
    }

    val gotItButton = KButton(matcher) {
        withText(R.string.view_announcement_card_negative_action)
    }


}