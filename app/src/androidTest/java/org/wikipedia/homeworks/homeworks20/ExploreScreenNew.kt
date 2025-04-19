//package org.wikipedia.homeworks.homeworks20
//
//import io.github.kakaocup.kakao.image.KImageView
//import io.github.kakaocup.kakao.recycler.KRecyclerView
//import org.wikipedia.R
//import org.wikipedia.feed.view.FeedView
//import org.wikipedia.homeworks.homework07.CustomizeBlockCardItem
//import org.wikipedia.homeworks.homework07.DateHeaderCardItem
//import org.wikipedia.homeworks.homework07.SearchCardItem
//import org.wikipedia.homeworks.homework07.TopReadCardItem
//
//object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
//    override val screenName = "Главная"
//    override val layoutId = R.layout.fragment_feed
//    override val viewClass = FeedView::class.java
//
//
//    val toolbarTitle by lazy {
//        KImageView {
//            withId(R.id.main_toolbar_wordmark)
//        }.name(withParent("Заголовок"))
//    }
//
//    val items = KRecyclerView(
//        builder = {
//            withId(R.id.feed_view)
//        },
//        itemTypeBuilder = {
//            itemType(::SearchCardItem)
//            itemType(::CustomizeBlockCardItem)
//            itemType(::DateHeaderCardItem)
//            itemType(::TopReadCardItem)
//        }
//    )
//
//    fun topReadItem(index: Int, function: TopReadCardItem.() -> Unit) {
//        items.childAt<TopReadCardItem>(index, function)
//    }
//
//    fun topReadItem(): TopReadCardItem {
//        return items.childWith<TopReadCardItem> {
//            withDescendant {
//                { withText("Top read") }
//            }
//        }
//    }
//}