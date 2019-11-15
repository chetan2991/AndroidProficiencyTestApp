package com.chetan.home.data.network

import com.chetan.base.data.BaseDataSource
import com.chetan.base.data.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

interface HomeNetworkService {
    @GET("s/{key}/facts.json/")
    suspend fun getFactList(@Path("key")key:String=BuildConfig.API_KEY): Response<GetHomeListResponse>
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