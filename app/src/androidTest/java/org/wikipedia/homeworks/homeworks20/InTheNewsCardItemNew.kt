package org.wikipedia.homeworks.homeworks20

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsCardItemNew(matcher: Matcher<View>) : KRecyclerItem<InTheNewsCardItemNew>(matcher) {

    val header by lazy {
        KTextView(matcher) { withId(R.id.view_card_header_title) }.name(withParent("Заголовок"))
    }

    val languageCode by lazy {
        KTextView(matcher) { withId(R.id.langCodeText) }.name(withParent("Код языка"))
    }

    val listMenu by lazy {
        KImageView(matcher) { withId(R.id.view_list_card_header_menu) }.name(withParent("Меню"))
    }

    val items by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { withId(R.id.news_cardview_recycler_view) },
            itemTypeBuilder = {
                itemType(::NewsCardTabItem)
            }
        ).name(withParent("Таб новостей"))
    }

    fun tabNewsItem(index: Int, function: NewsCardTabItem.() -> Unit) {
        items.invokeAtIndex(index, function)
    }

}
