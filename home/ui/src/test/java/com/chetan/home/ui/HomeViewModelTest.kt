//package com.chetan.home.ui
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.chetan.base.ui.Visibility
//import com.chetan.home.domain.model.HomeListItem
//import com.nhaarman.mockitokotlin2.any
//import com.nhaarman.mockitokotlin2.mock
//import com.nhaarman.mockitokotlin2.whenever
//import org.hamcrest.CoreMatchers.equalTo
//import org.junit.Assert.assertThat
//import org.junit.Rule
//import org.junit.Test
//
//
//class HomeViewModelTest {
//
//    @get:Rule
//    val instantExecutor = InstantTaskExecutorRule()
//
//    private val palette = HomeColorPalette(0xfff, 0xfff)
//    private val mockedGetStories = mock<GetHomeList>()
//    private val mockedPalettes = mock<HomeColorPalette> {
//        on { get(any()) } doReturn palette
//    }
//
//    @Test
//    fun shouldShowHomeList_whenGetStoriesIsSuccessful() {
//        // GIVEN
//        val homeListItem = homeListItem()
//        val stories = listOf(homeListItem)
//        val expectedStoryStates = listOf(HomeListItemViewState(homeListItem = homeListItem, palette))
//        givenSuccessfulGetStories(stories)
//        val testScheduler = TestScheduler()
//        val viewModel = HomeViewModel(
//            mockedGetStories,
//            mockedSupportStory,
//            mockedPalettes,
//            testRxSchedulers(main = testScheduler)
//        )
//
//        // WHEN
//        viewModel.loadHomeList()
//
//        // THEN
//        assertThat(viewModel.viewState.loaderVisibility, equalTo(true))
//        testScheduler.triggerActions()
//        assertThat(viewModel.viewState.loaderVisibility, equalTo(false))
//        assertThat(viewModel.viewState.homeListVisibility, equalTo(Visibility.VISIBLE))
//        assertThat(viewModel.viewState.homeListStates, equalTo(expectedStoryStates))
//    }
//
//    @Test
//    fun shouldShowEmptyState_whenNoListItemFound() {
//        // GIVEN
//        val testScheduler = TestScheduler()
//        givenSuccessfulGetStories(emptyList())
//        val viewModel = StoryListViewModel(
//            mockedGetStories,
//            mockedSupportStory,
//            mockedPalettes,
//            testRxSchedulers(main = testScheduler)
//        )
//
//        // WHEN
//        viewModel.loadStories()
//
//        // THEN
//        assertThat(viewModel.viewState.loaderVisible, equalTo(true))
//        testScheduler.triggerActions()
//        assertThat(viewModel.viewState.loaderVisible, equalTo(false))
//        assertThat(viewModel.viewState.storyVisibility, equalTo(GONE))
//        assertThat(viewModel.viewState.errorVisibility, equalTo(VISIBLE))
//        assertThat(viewModel.viewState.errorMessage, equalTo(Message(R.string.no_story_message)))
//    }
//
//    @Test
//    fun shouldShowErrorState_whenGetHomeListReturnsError() {
//        // GIVEN
//        val testScheduler = TestScheduler()
//        val error = RuntimeException()
//        givenUnsuccessfulGetStories(error)
//        val viewModel = StoryListViewModel(
//            mockedGetStories,
//            mockedSupportStory,
//            mockedPalettes,
//            testRxSchedulers(main = testScheduler)
//        )
//
//        // WHEN
//        viewModel.loadStories()
//
//        // THEN
//        assertThat(viewModel.viewState.loaderVisible, equalTo(true))
//        testScheduler.triggerActions()
//        assertThat(viewModel.viewState.loaderVisible, equalTo(false))
//        assertThat(viewModel.viewState.storyVisibility, equalTo(GONE))
//        assertThat(viewModel.viewState.errorVisibility, equalTo(VISIBLE))
//        assertThat(viewModel.viewState.errorMessage, equalTo(Message(R.string.generic_failure_message, error)))
//    }
//
//
//
//    private fun givenSuccessfulGetStories(stories: List<Story>) {
//        whenever(mockedGetStories())
//            .thenReturn(Single.just(stories))
//    }
//
//    private fun givenUnsuccessfulGetStories(error: RuntimeException) {
//        whenever(mockedGetStories())
//            .thenReturn(Single.error(error))
//    }
//
//
//    fun homeListItem() = HomeListItemViewState(
//            homeListItem = HomeListItem(
//                title = "Beavers",
//                description = "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
//                imageHref = "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"
//            ),
//            palette = HomeColorPalette(0xfff, 0xfff)
//        )
//
//}
