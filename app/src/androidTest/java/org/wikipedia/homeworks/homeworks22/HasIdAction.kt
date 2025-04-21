package org.wikipedia.homeworks.homeworks22

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HasIdAction(private val targetId: Int) : ViewAction {
    private var result: Boolean = false

    override fun getConstraints(): Matcher<View?>? {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String? {
        return "Checks if the view has the target ID."
    }

    override fun perform(
        uiController: UiController?,
        view: View?
    ) {
        val noNullView = requireNotNull(view) { "View must not be null" }
        result = when {
            noNullView.id == targetId -> true
            noNullView.findViewById<View>(targetId) != null -> true
            else -> false
        }
    }

    fun isMatched(): Boolean = result
}