package com.chetan.home.data.di

import android.app.Application
import com.chetan.home.data.db.FactDao
import com.chetan.home.data.db.FactDatabase
import com.chetan.home.data.db.FactLocalCacheImpl

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
@Module
class FactDbModule {

    @Singleton
    @Provides
    fun providesRoomFactDatabase(application: Application): FactDatabase {
        return FactDatabase.getDatabase(application, CoroutineScope(Dispatchers.IO))
    }
    @Provides
    fun provideIoCoroutineScope() = CoroutineScope(Dispatchers.IO)
    @Singleton
    @Provides
    fun provideFactDao( factDatabase: FactDatabase): FactDao {
        return factDatabase.factDao();
    }
    @Singleton
    @Provides
    fun provideFactLocalCacheImpl(factDao:FactDao, scope: CoroutineScope): FactLocalCacheImpl {
        return FactLocalCacheImpl(factDao,scope = scope)
    }
}