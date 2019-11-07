package com.chetan.base.data.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Dagger module for declaring [HttpLoggingInterceptor] for debug build.
 */
@Module
object LoggingInterceptorModule {

    @IntoSet
    @Provides
    @JvmStatic
    fun loggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }
    }
}
