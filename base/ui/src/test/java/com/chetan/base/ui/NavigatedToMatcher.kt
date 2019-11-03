package com.chetan.base.ui

import androidx.navigation.NavDirections
import com.chetan.base.ui.event.Event
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 * Returns matcher that checks that [Navigator] has navigated to given destination.
 */
fun navigatedTo(navigateTo: NavigateTo): Matcher<Navigator?> =
    NavigatedToMatcher(Event(navigateTo))

/**
 * Returns matcher that checks that [Navigator] has navigated to given direction.
 */
fun navigatedTo(direction: NavDirections): Matcher<Navigator?> = NavigatedToMatcher(
    Event(
        NavigateTo.Action(
            direction
        )
    )
)

/**
 * Returns matcher that checks that [Navigator] has not navigated to any destination.
 */
fun notNavigated(): Matcher<Navigator?> = NavigatedToMatcher(null)

/**
 * Matcher that checks if [Navigator] has navigated to specific destination.
 */
internal class NavigatedToMatcher(
    private val navigateToEvent: Event<NavigateTo>?
) : TypeSafeMatcher<Navigator?>() {

    override fun matchesSafely(item: Navigator?): Boolean {
        return navigateToEvent == item?.navigatedTo
    }

    override fun describeTo(description: Description) {
        description.appendValue(navigateToEvent)
    }

    override fun describeMismatchSafely(item: Navigator?, mismatchDescription: Description) {
        mismatchDescription.appendText("was ")
            .appendValue(item?.navigatedTo)
    }
}
