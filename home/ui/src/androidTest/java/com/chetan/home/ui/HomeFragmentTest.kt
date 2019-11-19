package com.chetan.home.ui

import androidx.fragment.app.testing.FragmentScenario.launch
import com.chetan.test.ui.okReplayRule
import org.junit.Rule
import org.junit.Test
import okreplay.OkReplay


class HomeFragmentTest {
    @get:Rule
    val okReplayRule = okReplayRule()

    @Test
    @OkReplay
    fun shouldDisplayStories() = homeList {
        // WHEN
        launch()

        // THEN
        displayNameShouldBe("Alice")
        titleShouldBe("Story title")
        descriptionShouldBe("Story description")
    }
}







//@Test
//@OkReplay
//fun shouldShowErrorMessage_whenNoStoriesFound() = storyList {
//    // WHEN
//    launch()
//
//    // THEN
//    errorMessageShouldBe(R.string.no_story_message)
//    refreshButtonIsEnabled()
//}
//
//@Test
//@OkReplay
//fun shouldShowErrorMessage_whenApiResponseFails() = storyList {
//    // WHEN
//    launch()
//
//    // THEN
//    errorMessageShouldBe(R.string.generic_failure_message)
//    refreshButtonIsEnabled()
//}
//}