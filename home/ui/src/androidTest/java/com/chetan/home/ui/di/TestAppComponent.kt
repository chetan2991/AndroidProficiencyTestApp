package com.chetan.home.ui.di

import android.app.Application
import com.chetan.base.data.di.BaseDataModule
import com.chetan.base.domain.di.BaseDomainModule
import com.chetan.base.ui.di.BaseUiModule
import com.chetan.home.data.di.HomeDataModule
import com.chetan.home.domain.di.HomeDomainModule
import com.chetan.home.ui.app.TestApp
import com.chetan.test.ui.OkReplayInterceptorProvider
import com.chetan.test.ui.di.OkReplayInterceptorModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        OkReplayInterceptorModule::class,
        BaseUiModule::class,
        BaseDomainModule::class,
        BaseDataModule::class,
        HomeUiModule::class,
        HomeDomainModule::class,
        HomeDataModule::class
    ]
)
interface TestAppComponent : AndroidInjector<TestApp>, OkReplayInterceptorProvider {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): TestAppComponent
    }
}








