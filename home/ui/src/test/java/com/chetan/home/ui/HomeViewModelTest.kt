package com.chetan.home.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.android.example.livedatabuilder.util.observeForTesting
import com.chetan.base.data.network.NetworkState
import com.chetan.base.ui.Visibility
import com.chetan.home.domain.GetFacts
import com.chetan.home.domain.LiveDataHomeResult
import com.chetan.home.domain.model.Fact
import com.chetan.test.ui.asPagedList
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    private val palette = HomeColorPalette(0xfff, 0xfff)
    private val mockedGetFacts = mock<GetFacts>()
    private val mockedPalettes = mock<HomeColorPalettes> {
        on { get(any()) } doReturn palette
    }

    @Test
    fun shouldShowHomeList_whenGetFactsIsSuccessful() {
        // GIVEN
        givenSuccessfulGetFacts()
        val viewModel = HomeViewModel(mockedGetFacts, mockedPalettes)

        // WHEN
        viewModel.loadFactList()
        viewModel.liveDataFactList.observeForTesting {
            assertEquals(viewModel.liveDataFactList.value, listOf(Fact.EMPTY).asPagedList())
            viewModel.loadFactListSucess(viewModel.liveDataFactList?.value!!, {})
        }
        viewModel.netWorkState.observeForTesting {
            assertEquals(viewModel.netWorkState.value, NetworkState.LOADED)
        }
        viewModel.title.observeForTesting {
            assertEquals(viewModel.title.value, "About Canada")
        }
        viewModel.refreshState.observeForTesting {
            assertEquals(viewModel.refreshState.value, NetworkState.LOADED)
        }

        // THEN
        assertThat(viewModel.viewState.loaderVisibility, equalTo(false))
        assertThat(viewModel.viewState.errorVisibility, equalTo(Visibility.GONE))
        assertThat(viewModel.viewState.homeListVisibility, equalTo(Visibility.VISIBLE))
        assertThat(viewModel.viewState.homeListStates, equalTo(listOf(Fact.EMPTY).asPagedList()))

    }

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

//    @Test
//    fun shouldShowErrorState_whenGetHomeListReturnsError() {
//        // GIVEN
//        givenNetworkStateFailGetFacts()
//        val viewModel = HomeViewModel(mockedGetFacts, mockedPalettes)
//
//        // WHEN
//        viewModel.loadFactList()
//        viewModel.liveDataFactList.observeForTesting {
//            assertEquals(viewModel.liveDataFactList.value, null)
//        }
//        viewModel.netWorkState.observeForTesting {
//            assertEquals(viewModel.netWorkState.value,NetworkState.error("FAiled"))
//        }
//        viewModel.title.observeForTesting {
//            assertEquals(viewModel.title.value, null)
//        }
//        viewModel.refreshState.observeForTesting {
//            assertEquals(viewModel.refreshState.value,null)
//        }
//
//        // THEN
//        assertThat(viewModel.viewState.loaderVisibility, equalTo(false))
//        assertThat(viewModel.viewState.errorVisibility, equalTo(Visibility.GONE))
//        assertThat(viewModel.viewState.homeListVisibility, equalTo(Visibility.VISIBLE))
//        assertThat(viewModel.viewState.homeListStates, equalTo(listOf(Fact.EMPTY).asPagedList()))
//    }



    private fun givenSuccessfulGetFacts() {
        whenever(mockedGetFacts.getFacts())
            .thenReturn(getSucessResult())
    }

    private fun givenNetworkStateFailGetFacts(){
        whenever(mockedGetFacts.getFacts())
            .thenReturn(getNetworkStateFailResult())
    }


    fun getNetworkStateFailResult(): LiveDataHomeResult{
        return LiveDataHomeResult(
            title = MutableLiveData<String>("About Canada"),
            data = MutableLiveData<PagedList<Fact>>(listOf(Fact.EMPTY).asPagedList()),
            networkState = MutableLiveData<NetworkState>(NetworkState.LOADED),
            refreshState = MutableLiveData<NetworkState>(NetworkState.LOADED),
            refresh = {},
            retry = {}
        )
    }
    fun getSucessResult(): LiveDataHomeResult {
        return LiveDataHomeResult(
            title = MutableLiveData<String>(),
            data = MutableLiveData<PagedList<Fact>>(),
            networkState = MutableLiveData<NetworkState>(NetworkState.error("Network Failure")),
            refreshState = MutableLiveData<NetworkState>(NetworkState.LOADED),
            refresh = {},
            retry = {}
        )
    }
}











