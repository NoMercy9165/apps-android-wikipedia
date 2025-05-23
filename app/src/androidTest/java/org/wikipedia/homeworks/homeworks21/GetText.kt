package org.wikipedia.homeworks.homeworks21

import android.view.View
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class GetText: ViewAction {
    private var text: String = ""

    fun getText() = text

    override fun getConstraints(): Matcher<View?>? {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String? {
        return "get text"
    }

    override fun perform(
        uiController: UiController?,
        view: View?
    ) {
        text = (view as TextView).text.toString()
    }
}