package com.chetan.home.ui

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(): ViewModel(){
}


//package umon.story.ui
//
//import io.reactivex.rxkotlin.subscribeBy
//import umon.domain.RxSchedulers
//import umon.domain.invoke
//import umon.story.domain.GetStories
//import umon.story.domain.SupportStory
//import umon.story.domain.model.Story
//import umon.story.domain.model.StorySupport
//import umon.story.ui.StoryListFragmentDirections.Companion.actionStoryListToPostStory
//import umon.story.ui.StoryListFragmentDirections.Companion.actionStoryListToStory
//import umon.ui.BaseViewModel
//import umon.ui.Message
//import umon.ui.Navigator
//import umon.ui.SnackbarEvent
//import umon.ui.Visibility
//import javax.inject.Inject
//
//class StoryListViewModel @Inject constructor(
//    private val getStories: GetStories,
//    private val supportStory: SupportStory,
//    private val palettes: StoryColorPalettes,
//    private val schedulers: RxSchedulers
//) : BaseViewModel() {
//
//    val navigator = Navigator()
//    val viewState = StoryListViewState()
//
//    fun loadStories() {
//        getStories()
//            .map {
//                it.mapIndexed { i, s -> StoryItemViewState(s, palettes.get(i)) }
//            }
//            .observeOn(schedulers.main)
//            .doOnSubscribe { viewState.loaderVisible = true }
//            .subscribeBy(
//                onSuccess = { if (it.isEmpty()) noStoriesFound() else loadStoriesSuccess(it) },
//                onError = { loadStoriesError(it) }
//            )
//            .autoDispose()
//    }
//
//    fun supportStory(story: Story, support: Boolean) {
//        if (story.supportedByMe == support) {
//            // already supported/unsupported - no change
//            return
//        }
//
//        supportStory(StorySupport(story.id, support))
//            .observeOn(schedulers.main)
//            .subscribeBy(onError = { /* ignore */ })
//            .autoDispose()
//    }
//
//    fun navigateToPostStory() {
//        navigator.navigate(actionStoryListToPostStory())
//    }
//
//    fun navigateToStory(viewState: StoryItemViewState) {
//        navigator.navigate(
//            actionStoryListToStory(
//                // passing local view state too
//                story = viewState.story.copy(
//                    noOfSupports = viewState.noOfSupports,
//                    supportedByMe = viewState.supportedByMe
//                ),
//                palette = viewState.palette
//            )
//        )
//    }
//
//    private fun loadStoriesSuccess(states: List<StoryItemViewState>) = with(viewState) {
//        loaderVisible = false
//        errorVisibility = Visibility.GONE
//        storyVisibility = Visibility.VISIBLE
//        storyStates = states
//    }
//
//    private fun noStoriesFound() = with(viewState) {
//        loaderVisible = false
//        storyVisibility = Visibility.GONE
//        errorVisibility = Visibility.VISIBLE
//        errorMessage = Message(R.string.no_story_message)
//        storyStates = emptyList()
//    }
//
//    private fun loadStoriesError(error: Throwable) = with(viewState) {
//        loaderVisible = false
//        if (storyStates.isEmpty()) {
//            storyVisibility = Visibility.GONE
//            errorVisibility = Visibility.VISIBLE
//            errorMessage = Message(R.string.generic_failure_message, error)
//        } else {
//            snackbar = SnackbarEvent(R.string.generic_failure_message, error)
//        }
//    }
//}
