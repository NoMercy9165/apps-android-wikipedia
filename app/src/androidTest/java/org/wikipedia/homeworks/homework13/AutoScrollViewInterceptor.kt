package org.wikipedia.homeworks.homework13

import android.content.res.Resources
import android.view.View
import androidx.test.espresso.ViewAction
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewActionWatcherInterceptor

class AutoScrollViewInterceptor : ViewActionWatcherInterceptor {
    override fun intercept(viewAction: ViewAction, view: View) {
        if (!view.isCompletelyVisibleOnScreen()) {
            view.scrollToView()  // Выполняем автоскролл
        }
    }

    private fun View.scrollToView() {
        this.parent?.requestChildFocus(this, this)  // Прокрутка к элементу без Espresso
    }

    private fun View.isCompletelyVisibleOnScreen(): Boolean {
        val location = IntArray(2)
        this.getLocationOnScreen(location)   // Получаем координаты элемента
        val screenHeight = Resources.getSystem().displayMetrics.heightPixels  // Высота экрана
        return location[1] in 0..screenHeight  // Проверяем, полностью ли элемент виден
    }
}