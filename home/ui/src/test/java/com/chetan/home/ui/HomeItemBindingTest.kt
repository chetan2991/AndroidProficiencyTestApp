package com.chetan.home.ui

import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chetan.home.domain.model.Fact
import com.google.common.base.Predicates.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import umon.ui.test.binding.bind
import umon.ui.test.binding.inflate
import java.lang.Short.valueOf

@RunWith(AndroidJUnit4::class)
class HomeItemBindingTest {

    @Test
    fun shouldUpdateViewOnStateChange() = inflate<HomeListItemBinding>(R.layout.item_list_home) {
        // GIVEN
        val state = homeListItemViewState()

        // WHEN
        bind { this.viewState = state.fact }

        // THEN
        assertThat(titleTextView, withText(state.fact.title))
        assertThat(descriptionTextView, withText(state.fact.description))
//        assertThat(fact_card_view.cardBackgroundColor, equalTo(valueOf(state.palette.primary)))
    }



    private fun homeListItemViewState(supportedByMe: Boolean = true) = HomeListItemViewState(
        Fact(
            title = "Beavers",
            description = "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
            imageHref = "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"
        ),
        palette = HomeColorPalette(0xfff, 0xfff)

    )
}
