package com.chetan.home.data.network

import com.chetan.base.data.BaseDataSource
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject

interface HomeNetworkService {
    @GET("s/2iodh4vg0eortkl/facts.json/")
    suspend fun getFactList(): Response<GetHomeListResponse>
}

/**
 * work with fact API TO GET DATA.
 *
 */
open class HomeRemoteDataSource @Inject constructor(private val service: HomeNetworkService) :
    BaseDataSource() {
    suspend fun getFactList() = getResult {
        service.getFactList()
    }
}