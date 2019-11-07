package com.chetan.base.ui

import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import java.util.concurrent.Executor

fun <T>emptyPagedList() : PagedList<T>{
    val myConfig:PagedList.Config  =  PagedList.Config.Builder()
        .setInitialLoadSizeHint(1)
        .setPageSize(1)
        .build()
    val myList :List<T>  =  ArrayList<T>();
    val provider :StringListProvider<T> =  StringListProvider(myList);
    val dataSource :StringDataSource<T> =  StringDataSource(provider);
    val pagedList =  PagedList.Builder<Int,T>(dataSource,myConfig)
        .setInitialKey(1)
        .build()
     return pagedList
}
class StringListProvider<T>(val list: List<T>) {


    fun getStringList(page: Int, pageSize: Int): List<T> {

        val initialIndex = page * pageSize
        val finalIndex = initialIndex + pageSize
        //TODO manage index out of range
        return list.subList(initialIndex, finalIndex)
    }
}
class StringDataSource<T>(val provider: StringListProvider<T>) : PageKeyedDataSource<Int, T>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, T>) {
        val list = provider.getStringList(0, params.requestedLoadSize)
        callback.onResult(list, 1, 2)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        val list = provider.getStringList(params.key, params.requestedLoadSize)
        callback.onResult(list, params.key + 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        val list = provider.getStringList(params.key, params.requestedLoadSize)
        val nextIndex = if (params.key > 1) params.key - 1 else null
        callback.onResult(list, nextIndex)
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}


