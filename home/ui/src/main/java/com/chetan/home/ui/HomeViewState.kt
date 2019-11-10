package com.chetan.home.ui

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.paging.PagedList
import com.chetan.base.ui.Message
import com.chetan.base.ui.SnackbarEvent
import com.chetan.base.ui.Visibility
import com.chetan.base.ui.binding.bind
import com.chetan.home.domain.model.Fact

class HomeViewState(
    initHomeListStates: PagedList<Fact>? = null,
    initHomeListVisibility: Visibility = Visibility.GONE,
    initLoaderVisibility: Boolean = false,
    initErrorVisibility: Visibility = Visibility.GONE,
    initErrorMessage: Message = Message(R.string.empty),
    initRefreshEnabled: Boolean = true,
    initSnackbar: SnackbarEvent = SnackbarEvent.NONE,
    initPageTitle: String = ""

) : BaseObservable() {

    @get:Bindable
    var loaderVisibility by bind(BR.loaderVisibility, initLoaderVisibility) { _, new ->
        refreshEnabled = !new
    }
    @get:Bindable
    var homeListStates by bind(BR.homeListStates, initHomeListStates)

    @get:Bindable
    var homeListVisibility by bind(BR.homeListVisibility, initHomeListVisibility)

    @get:Bindable
    var errorVisibility by bind(BR.errorVisibility, initErrorVisibility)

    @get:Bindable
    var errorMessage by bind(BR.errorMessage, initErrorMessage)

    @get:Bindable
    var pageTitle by bind(BR.pageTitle, initPageTitle)

    @get:Bindable
    var refreshEnabled by bind(BR.refreshEnabled, initRefreshEnabled)

    @get:Bindable
    var snackbar by bind(BR.snackbar, initSnackbar)

}

