package com.chetan.home.data.di

import com.chetan.base.data.network.NetworkClient
import com.chetan.home.data.HomeRepositoryImpl
import com.chetan.home.data.db.FactLocalCacheImpl
import com.chetan.home.data.db.FactLocalCahe
import com.chetan.home.data.network.HomeNetworkService
import com.chetan.home.data.network.HomeRemoteDataSource
import com.chetan.home.domain.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [FactDbModule::class])
abstract class HomeDataModule {

    @Binds
    abstract fun homeRepository(homeRepository: HomeRepositoryImpl): HomeRepository

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun homeService(client: NetworkClient) = client.create(HomeNetworkService::class)

        @Provides
        @JvmStatic
        fun homeCache(cahe: FactLocalCacheImpl): FactLocalCahe = cahe

        @Provides
        @JvmStatic
        fun provideRemoteDataSource(homeNetworkService: HomeNetworkService) =
            HomeRemoteDataSource(homeNetworkService)
    }
}
