package com.chetan.home.ui

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class HomeViewStateTest {


    @Test
    fun shouldEnableRefresh_whenLoaderNotVisible(){
        //GIVEN
        val viewState = HomeViewState(
            initLoaderVisibility = true,
            initRefreshEnabled = false
        )
        //when
        viewState.loaderVisibility = false

        //THEN
        assertThat(viewState.refreshEnabled ,equalTo(true))
    }

    @Test
    fun shouldDisableRefresh_whenLoaderVisible() {
        // GIVEN
        val viewState = HomeViewState(
            initLoaderVisibility = false,
            initRefreshEnabled = true
        )

        // WHEN
        viewState.loaderVisibility = true

        // THEN
        assertThat(viewState.refreshEnabled, equalTo(false))
    }
}
