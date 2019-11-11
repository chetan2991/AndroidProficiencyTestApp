package com.chetan.home.data

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.chetan.base.data.Result
import com.chetan.base.data.network.NetworkState
import com.chetan.home.data.db.FactLocalCahe
import com.chetan.home.data.network.HomeRemoteDataSource
import com.chetan.home.domain.HomeRepository
import com.chetan.home.domain.LiveDataHomeResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 *
 * Repository class that works with local and remote data sources of facts.
 *
 */
class HomeRepositoryImpl @Inject constructor(
    private val service: HomeRemoteDataSource,
    private val cache: FactLocalCahe,
    private val scope: CoroutineScope
) : HomeRepository {


    private var isRequestInProgress = false
    @MainThread
    private fun refresh(): LiveData<NetworkState> {
        val networkState = MutableLiveData<NetworkState>()
        if (networkState.value != NetworkState.LOADING) {
            scope.launch {
                networkState.postValue(NetworkState.LOADING)
                val response = service.getFactList()
                if (response.status == Result.Status.SUCCESS) {
                    val result = response.data!!.rows.filter {
                        if (it.title == null && it.description == null && it.imageHref == null) {
                            false
                        } else {
                            true
                        }
                    }.map {
                        it.copy(
                            title = it.title?.trim(),
                            description = it.description?.trim(),
                            imageHref = it.imageHref?.trim()
                        )
                    }
                    cache.deleteAll {
                    }
                    cache.insert(result) {
                        networkState.postValue(NetworkState.LOADED)
                    }
                    isRequestInProgress = false
                } else if (response.status == Result.Status.ERROR) {
                    Timber.e("An error happened: ${response.message}")
                    networkState.postValue(NetworkState.error("An error happened : ${response.message}"))
                }
            }
        }
        return networkState
    }


    override fun getFacts(): LiveDataHomeResult {
        //we are loading data source from database
        val dataSourceFactory = cache.getFacts()
        val boundaryCallback = BoundaryCallback(service, cache, scope)
        val refreshTrigger = MutableLiveData<Unit>()
        val refreshState = Transformations.switchMap(refreshTrigger) {
            refresh()
        }
        val data = LivePagedListBuilder(
            dataSourceFactory,
            pagedListConfig()
        ).setBoundaryCallback(boundaryCallback).build()
        return LiveDataHomeResult(
            title = boundaryCallback.pageTitle,
            data = data,
            networkState = boundaryCallback.networkState,
            refreshState = refreshState,
            refresh = {
                refreshTrigger.value = null
            },
            retry = {
                refresh()
            }
        )
    }


    companion object {
        private const val DATABASE_PAGE_SIZE = 20
        fun pagedListConfig() = PagedList.Config.Builder()
            .setInitialLoadSizeHint(DATABASE_PAGE_SIZE)
            .setPageSize(DATABASE_PAGE_SIZE)
            .setEnablePlaceholders(true)
            .build()
    }
}



