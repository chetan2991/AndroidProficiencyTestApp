package com.chetan.home.ui

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chetan.base.ui.Message
import com.chetan.base.ui.SnackbarEvent
import com.chetan.base.ui.Visibility
import com.chetan.home.domain.model.Fact
import com.chetan.test.hasSnackbar
import com.chetan.test.withMessage
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import umon.ui.test.binding.bind
import umon.ui.test.binding.inflate
import umon.ui.test.binding.parent


@RunWith(AndroidJUnit4::class)
class HomeFragmentBindingTest {

    @Test
    fun shouldCalloadHomeList() = inflate<HomeFragmentBinding>(R.layout.fragment_home) {
        // GIVEN
        val mockedViewModel = mock<HomeViewModel>()
        homeRecyclerView.adapter = HomePageListAdapter(mockedViewModel)
        bind {
            viewState = HomeViewState()
            viewModel = mockedViewModel
        }

        // WHEN
        refreshButton.performClick()

        // THEN
        verify(mockedViewModel).loadFactList()
    }

    @Test
    fun shouldUpdateViewOnStateChange() = inflate<HomeFragmentBinding>(R.layout.fragment_home) {
        // GIVEN
        val expectedStates = homeModelViewState()
        val expectedMessage = R.string.generic_failure_message
        val adapter = HomePageListAdapter(mock())
        homeRecyclerView.adapter = adapter
        bind {
            viewState = HomeViewState(
                initHomeListStates = null,
                initHomeListVisibility = Visibility.INVISIBLE,
                initLoaderVisibility = false,
                initErrorVisibility = Visibility.INVISIBLE,
                initErrorMessage = Message(R.string.empty),
                initRefreshEnabled = true,
                initSnackbar = SnackbarEvent.NONE
            )
        }

        // WHEN
        bind(viewState) {
            homeListStates = null
            homeListVisibility = Visibility.GONE
            loaderVisibility = true
            errorVisibility = Visibility.GONE
            errorMessage = Message(expectedMessage)
            refreshEnabled = false
            snackbar = SnackbarEvent(expectedMessage)
        }

        // THEN
        assertThat(adapter.currentList, equalTo(expectedStates))
        assertThat(homeRecyclerView.visibility, equalTo(View.GONE))
        assertThat(homeSwipeRefresh.isRefreshing, equalTo(true))
        assertThat(errorView.visibility, equalTo(View.GONE))
        assertThat(errorMessageText, withText(expectedMessage))
        assertThat(refreshButton, not(isEnabled()))
        assertThat(parent, hasSnackbar(withMessage(expectedMessage)))
    }

    private fun homeModelViewState() = listOf(
            fact = Fact(
                title = "Beavers",
                description = "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
                imageHref = "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"
            ),
            palette = HomeColorPalette(0xfff, 0xfff)
    )
}
