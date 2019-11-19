package com.chetan.home.ui

import androidx.annotation.StringRes
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.chetan.test.ui.launchFragmentInContainer
import org.hamcrest.CoreMatchers.allOf




inline fun homeList(init: HomeListRobot.()->Unit) = HomeListRobot().init()

class HomeListRobot {
    private lateinit var scenario : FragmentScenario<HomeFragment>

    fun launch(){
        scenario = launchFragmentInContainer()
    }

    fun descriptionShouldBe(description: String) {
        onView(withId(R.id.description_text_view))
            .check(matches(allOf(isDisplayed(), withText(description))))
    }

    fun titleShouldBe(title: String) {
        onView(withId(R.id.title_text_view))
            .check(matches(allOf(isDisplayed(), withText(title))))
    }

    fun displayNameShouldBe(displayName: String) {
        onView(withId(R.id.title_text_view))
            .check(matches(allOf(isDisplayed(), withText(displayName))))
    }

    fun errorMessageShouldBe(@StringRes errorMessage: Int) {
        onView(withId(R.id.error_message_text))
            .check(matches(allOf(isDisplayed(), withText(errorMessage))))
    }

    fun refreshButtonIsEnabled() {
        onView(withId(R.id.refresh_button))
            .check(matches(allOf(isDisplayed(), isEnabled())))
    }
}



