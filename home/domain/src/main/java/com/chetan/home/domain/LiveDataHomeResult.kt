package com.chetan.home.domain

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.chetan.base.data.network.NetworkState
import com.chetan.home.domain.model.Fact

data class LiveDataHomeResult(
    val title: LiveData<String>,
    // the LiveData of paged lists for the UI to observe
    val data: LiveData<PagedList<Fact>>,
    // represents the network request status to show to the user
    val networkState: LiveData<NetworkState>,
    // represents the refresh status to show to the user. Separate from networkState, this
    // value is importantly only when refresh is requested.
    val refreshState: LiveData<NetworkState>,
    // refreshes the whole data and fetches it from scratch.
    val refresh: () -> Unit,
    // retries
    val retry: () -> Unit
)
