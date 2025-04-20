package org.wikipedia.homeworks.homeworks20

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.homeworks.homework07.CustomizeBlockCardItem
import org.wikipedia.homeworks.homework07.DateHeaderCardItem
import org.wikipedia.homeworks.homework07.SearchCardItem
import org.wikipedia.homeworks.homework07.TopReadCardItemNew

object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java
    override val screenName = "Главный Экран"


    val toolbarTitle by lazy {
        KImageView { withId(R.id.main_toolbar_wordmark) }
            .getName(withParent("Заголовок"))
    }



    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::SearchCardItem)
                itemType(::CustomizeBlockCardItem)
                itemType(::DateHeaderCardItem)
                itemType(::TopReadCardItemNew)
            }
        ).getName(withParent("Список блоков"))
    }

    fun topReadItem(index: Int, function: TopReadCardItemNew.() -> Unit) {
        items.invokeAtIndex(index, function)
    }


    fun topReadItemText(function: TopReadCardItemNew.() -> Unit) {
        items.invokeAtDescendantText("Top read", function)

    }
}