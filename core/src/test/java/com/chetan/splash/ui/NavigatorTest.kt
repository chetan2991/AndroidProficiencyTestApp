package com.chetan.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.ON_RESUME
import androidx.lifecycle.LifecycleRegistry
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigatorTest {

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()
    private val mockedNavController = mock<NavController>()
    private val mockedFragment = mock<NavHostFragment>()
        .apply { whenever(navController).thenReturn(mockedNavController) }
    private val lifecycle = LifecycleRegistry(mockedFragment)
        .apply { whenever(mockedFragment.lifecycle).thenReturn(this) }

    @Test
    fun shouldNavigateToDeepLink(){
        //GIVEN
        val deepLink = NavigateTo.DeepLink("assignment://chetan/home",
            navOptions {  })
        val navigator = Navigator()
        //WHEN
        navigator.navigateBy(mockedFragment)
        navigator.navigate(deepLink)

        //THEN
        assertThat(navigator, navigatedTo(deepLink))
        lifecycle.handleLifecycleEvent(ON_RESUME)
        verify(mockedNavController).navigate(deepLink.uri(),deepLink.navOptions)
    }
    @Test
    fun shouldNavigateToDirection() {
        // GIVEN
        val direction = mock<NavDirections>()
        val navigator = Navigator()

        // WHEN
        navigator.navigateBy(mockedFragment)
        navigator.navigate(direction)

        // THEN
        assertThat(navigator, navigatedTo(direction))
        lifecycle.handleLifecycleEvent(ON_RESUME)
        verify(mockedNavController).navigate(direction)
    }

    @Test
    fun shouldNavigateBack() {
        // GIVEN
        val navigator = Navigator()

        // WHEN
        navigator.navigateBy(mockedFragment)
        navigator.navigate(NavigateTo.Back)

        // THEN
        Assert.assertThat(navigator, navigatedTo(NavigateTo.Back))
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        verify(mockedNavController).popBackStack()
    }

//    @Test
//    fun shouldNavigateBackTo() {
//        // GIVEN
//        val navigator = Navigator()
//        val backTo = NavigateTo.BackTo(R.id.container, false)
//
//        // WHEN
//        navigator.navigateBy(mockedFragment)
//        navigator.navigate(backTo)
//
//        // THEN
//        Assert.assertThat(navigator, navigatedTo(backTo))
//        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
//        verify(mockedNavController).popBackStack(backTo.destinationId, backTo.inclusive)
//    }


}



