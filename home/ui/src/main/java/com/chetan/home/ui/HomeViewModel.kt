package com.chetan.home.ui

import androidx.lifecycle.ViewModel
import com.chetan.base.ui.Message
import com.chetan.base.ui.Navigator
import com.chetan.base.ui.SnackbarEvent
import com.chetan.base.ui.Visibility
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    val navigator = Navigator()
    val viewState = HomeViewState()

    fun loadHomeList() {

    }

    private fun loadHomeListSucess(states: List<HomeListItemViewState>) = with(viewState) {
        loaderVisibility = false
        errorVisibility = Visibility.GONE
        homeListVisibility = Visibility.INVISIBLE
        homeListStates = states
    }

    private fun noHomeListItemsFound() = with(viewState) {
        loaderVisibility = false
        homeListVisibility = Visibility.GONE
        errorVisibility = Visibility.VISIBLE
        errorMessage = Message(R.string.no_story_message)
        homeListStates = emptyList()
    }

    private fun loadHomeListError(error:Throwable) = with(viewState){
        loaderVisibility = false
        if(homeListStates.isEmpty()){
            homeListVisibility = Visibility.GONE
            errorVisibility = Visibility.VISIBLE
            errorMessage = Message(R.string.generic_failure_message,error)
        }
        else{
            snackbar = SnackbarEvent(R.string.generic_failure_message,error)
        }
    }
}

