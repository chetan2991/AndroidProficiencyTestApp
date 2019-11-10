package com.chetan.base.ui

import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.chetan.base.ui.event.Event
import com.chetan.base.ui.event.consume

/**
 * Navigator is build on top on [MutableLiveData]. Use [navigate] methods to post navigation events on live-data using
 * [NavigateTo] or [NavDirections]. Use [navigateBy] method to observe the navigation events in views.
 */
class Navigator {

    private val navLiveData = MutableLiveData<Event<NavigateTo>>()

    @VisibleForTesting
    val navigatedTo: Event<NavigateTo>?
        get() = navLiveData.value

    /**
     * To navigate to specific destination.
     *
     * To navigate between modules use [DeepLink] with an [Uri]. Deep-links in navigation graph do not support
     * navigation options, so pass them manually using [DeepLink.navOptions].
     */
    fun navigate(navigateTo: NavigateTo) {
        navLiveData.value = Event(navigateTo)
    }

    /**
     * To navigate using the type-safe [NavDirections]. Use it to navigate between screens within a module.
     */
    fun navigate(direction: NavDirections) {
        navLiveData.value = Event(NavigateTo.Action(direction))
    }

    /**
     * To observe the [Navigator], uses [NavController] to navigate to specific destination.
     */
    fun navigateBy(fragment: Fragment) {
        navLiveData.observe(fragment, Observer { event ->
            event.consume {

                val navController = fragment.findNavController()
                when (val navigateTo = it.data) {
                    is NavigateTo.Back -> navController.popBackStack()
                    is NavigateTo.BackTo -> navController.popBackStack(navigateTo.destinationId, navigateTo.inclusive)
                    is NavigateTo.Action -> navController.navigate(navigateTo.direction)
                    is NavigateTo.DeepLink -> navController.navigate(navigateTo.uri(), navigateTo.navOptions)
                }
            }
        })
    }
}