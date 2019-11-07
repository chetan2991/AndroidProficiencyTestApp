package com.chetan.home.data

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.chetan.base.PagingRequestHelper
import com.chetan.base.data.network.NetworkState
import com.chetan.home.data.db.FactLocalCahe
import com.chetan.home.data.network.HomeRemoteDataSource
import com.chetan.home.domain.model.Fact
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.Executor
import javax.inject.Inject

/***
 * this is boundaryCall back which trigger method  if zeroItemLoaded when no item is load
 * and onItemAtEndLoaded when last visible item is loaded
 */
class BoundaryCallback @Inject constructor(
    private val remoteDataSource: HomeRemoteDataSource,
    private val cache: FactLocalCahe,
    private val scope: CoroutineScope
) : PagedList.BoundaryCallback<Fact>() {

    // avoid triggering multiple requests in the same time
    private var isRequestInProgress = false

    val networkState = MutableLiveData<NetworkState>()
    val pageTitle = MutableLiveData<String>()

    override fun onZeroItemsLoaded() {
        fetchData()
    }


    private fun fetchData() {
        if (isRequestInProgress) return
        else {
            scope.launch(getJobErrorHandler()) {
                isRequestInProgress = true
                networkState.postValue(NetworkState.LOADING)
                val response = remoteDataSource.getFactList()
                if (response.status == com.chetan.base.data.Result.Status.SUCCESS) {
                    val result  = response.data!!.rows.filter {
                        if(it.title==null&&it.description==null&&it.imageHref==null){false}
                        else {true}
                    }.map {
                        it.copy(title = it.title?.trim(),description = it.description?.trim(), imageHref = it.imageHref?.trim())
                    }
                    cache.insert(result) {
                    }
                    networkState.postValue(NetworkState.LOADED)
                    pageTitle.postValue(response.data!!.title)
                    isRequestInProgress = false
                } else if (response.status == com.chetan.base.data.Result.Status.ERROR) {
                    postError(response.message!!)
                    isRequestInProgress = false
                }
            }
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        postError(e.message ?: e.toString())
    }

    private fun postError(errorMessage: String) {
        Timber.e("An error happened: $errorMessage")
        networkState.postValue(NetworkState.error("An error happened : $errorMessage"))
    }
}








