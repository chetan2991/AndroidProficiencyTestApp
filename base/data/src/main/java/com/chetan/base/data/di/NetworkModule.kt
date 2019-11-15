package com.chetan.base.data.di

import com.chetan.base.domain.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module(includes = [LoggingInterceptorModule::class])
object NetworkModule {
    private const val CONNECT_TIMEOUT = 30L
    private const val READ_TIMEOUT = 30L
    private const val WRITE_TIMEOUT = 30L
    const val BASE_URL = BuildConfig.BASE_URL

    @Provides
    @JvmStatic
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @JvmStatic
    fun okHttpClient(
        interceptors: Set<@JvmSuppressWildcards Interceptor>,
        logger: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(logger)
            .apply {
                interceptors.forEach { addInterceptor(it) }
            }
            .build()
    }

    @Provides
    @JvmStatic
    fun logger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().run {
            level = HttpLoggingInterceptor.Level.BASIC
            this
        }
    }
}

