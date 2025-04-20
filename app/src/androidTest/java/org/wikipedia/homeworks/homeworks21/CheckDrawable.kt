package org.wikipedia.homeworks.homeworks21

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert

class AnyDrawable: ViewAssertion {
    override fun check(
        view: View?,
        noViewFoundException: NoMatchingViewException?
    ) {
        if (view is ImageView) {
            Assert.assertNotNull(view.drawable)
        } else throw (noViewFoundException ?: IllegalArgumentException("Не изображение"))
    }
}


class NoDrawable: ViewAssertion {
    override fun check(
        view: View?,
        noViewFoundException: NoMatchingViewException?
    ) {
        if (view is ImageView) {
            Assert.assertNull(view.drawable)
        } else throw (noViewFoundException ?: IllegalArgumentException("Не изображение"))
    }

}