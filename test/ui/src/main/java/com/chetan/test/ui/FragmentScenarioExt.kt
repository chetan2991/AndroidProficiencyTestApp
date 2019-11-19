package com.chetan.test.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.setViewNavController
import androidx.navigation.fragment.findNavController
import com.chetan.base.ui.NavigateTo
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify

/**
 * To launch the fragment using [launchFragment], also sets mocked [NavController] to fragment to assert navigation
 * events.
 */
inline fun <reified F : Fragment> launchFragment(
    navController: NavController = mock(),
    args: Bundle? = null,
    crossinline factory: () -> F
): FragmentScenario<F> {
    return launchFragment(args, R.style.AppTheme, factory)
        .onFragment {
            setViewNavController(it.requireView(), navController)
        }
}

/**
 * To launch the fragment using [launchFragment], also sets mocked [NavController] to fragment to assert navigation
 * events.
 */
inline fun <reified F : Fragment> launchFragment(
    navController: NavController = mock(),
    args: Bundle? = null
): FragmentScenario<F> {
    return launchFragment<F>(args, R.style.AppTheme)
        .onFragment {
            setViewNavController(it.requireView(), navController)
        }
}

/**
 * To launch the fragment in container using [launchFragmentInContainer], also sets mocked [NavController] to fragment
 * to assert navigation events.
 */
inline fun <reified F : Fragment> launchFragmentInContainer(
    navController: NavController = mock(),
    args: Bundle? = null,
    crossinline factory: () -> F
): FragmentScenario<F> {
    return launchFragmentInContainer(args, R.style.AppTheme, factory)
        .onFragment {
            setViewNavController(it.requireView(), navController)
        }
}

/**
 * To launch the fragment in container using [launchFragmentInContainer], also sets mocked [NavController] to fragment
 * to assert navigation events.
 */
inline fun <reified F : Fragment> launchFragmentInContainer(
    navController: NavController = mock(),
    args: Bundle? = null
): FragmentScenario<F> {
    return launchFragmentInContainer<F>(args, R.style.AppTheme)
        .onFragment {
            setViewNavController(it.requireView(), navController)
        }
}

/**
 * To assert the fragment of [FragmentScenario] is navigated to given [NavDirections].
 */
fun <F : Fragment> FragmentScenario<F>.assertNavigatedTo(direction: NavDirections) {
    onFragment {
        it.findNavController()
            .assertNavigatedTo(direction)
    }
}

/**
 * To assert the fragment of [FragmentScenario] is navigated to given [DeepLink].
 */
fun <F : Fragment> FragmentScenario<F>.assertNavigatedTo(deepLink: NavigateTo.DeepLink) {
    onFragment {
        it.findNavController()
            .assertNavigatedTo(deepLink)
    }
}

/**
 * To assert the fragment of [FragmentScenario] is navigated to back.
 */
fun <F : Fragment> FragmentScenario<F>.assertNavigatedBack() {
    onFragment {
        it.findNavController()
            .assertNavigatedBack()
    }
}

/**
 * To assert the fragment of [FragmentScenario] is navigated to back to specific destination.
 */
fun <F : Fragment> FragmentScenario<F>.assertNavigatedBack(backTo: NavigateTo.BackTo) {
    onFragment {
        it.findNavController()
            .assertNavigatedBack(backTo)
    }
}

/**
 * To assert the [NavController] is navigated to given [NavDirections].
 */
fun NavController.assertNavigatedTo(direction: NavDirections) {
    verify(this).navigate(direction)
}

/**
 * To assert the [NavController] is navigated to given [DeepLink].
 */
fun NavController.assertNavigatedTo(deepLink: NavigateTo.DeepLink) {
    verify(this).navigate(deepLink.uri(), deepLink.navOptions)
}

/**
 * To assert the [NavController] is navigated to back.
 */
fun NavController.assertNavigatedBack() {
    verify(this).popBackStack()
}

/**
 * To assert the [NavController] is navigated to back to specific destination.
 */
fun NavController.assertNavigatedBack(backTo: NavigateTo.BackTo) {
    verify(this).popBackStack(backTo.destinationId, backTo.inclusive)
}
