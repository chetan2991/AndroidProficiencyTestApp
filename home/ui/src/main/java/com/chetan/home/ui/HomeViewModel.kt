package com.chetan.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.switchMap
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.chetan.base.ui.Message
import com.chetan.base.ui.Navigator
import com.chetan.base.ui.SnackbarEvent
import com.chetan.base.ui.Visibility
import com.chetan.home.domain.GetFacts
import com.chetan.home.domain.LiveDataHomeResult
import com.chetan.home.domain.model.Fact
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getFacts: GetFacts,
    private val palettes: HomeColorPalettes
) : ViewModel() {
    val navigator = Navigator()
    val viewState = HomeViewState()

    private val liveData = MutableLiveData<LiveDataHomeResult>()
    fun loadFactList() {
        liveData.postValue(getFacts.getFacts())
    }

    val liveDataFactList = switchMap(liveData) { it ->
        it.data
    }
    val netWorkState = switchMap(liveData) {
        it.networkState
    }
    val refreshState = switchMap(liveData) {
        it.refreshState
    }
    val title = switchMap(liveData) {
        it.title
    }

    fun refresh() {
        liveData.value?.refresh?.invoke()
    }

    fun retry() {
        liveData.value?.retry?.invoke()
    }

    fun loadFactListSucess(
        states: PagedList<Fact>,
        submitSubList: (states: PagedList<Fact>) -> Unit
    ) = with(viewState) {
        loaderVisibility = false
        errorVisibility = Visibility.GONE
        homeListVisibility = Visibility.VISIBLE
        submitSubList(states)
    }

    fun setPageTitle(title: String) = with(viewState) {
        pageTitle = title
    }

    fun noFactFound() = with(viewState) {
        loaderVisibility = false
        homeListVisibility = Visibility.GONE
        errorVisibility = Visibility.VISIBLE
        errorMessage = Message(R.string.no_fact_found_message)
        homeListStates = null
    }

    fun loadFactListError(error: Throwable) = with(viewState) {
        loaderVisibility = false
        if (homeListStates?.isEmpty() ?: false) {
            homeListVisibility = Visibility.GONE
            errorVisibility = Visibility.VISIBLE
            errorMessage = Message(R.string.generic_failure_message, error)
        } else {
            snackbar = SnackbarEvent(R.string.generic_failure_message, error)
        }
    }
}

