package com.chetan.assignments.di

import android.app.Application
import com.chetan.assignments.App
import com.chetan.base.data.di.BaseDataModule
import com.chetan.base.domain.di.BaseDomainModule
import com.chetan.base.ui.di.BaseUiModule
import com.chetan.home.data.di.HomeDataModule
import com.chetan.home.domain.di.HomeDomainModule
import com.chetan.home.ui.di.HomeUiModule
import com.chetan.splash.ui.di.SplashUiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        BaseUiModule::class,
        BaseDomainModule::class,
        BaseDataModule::class,
        SplashUiModule::class,
        HomeUiModule::class,
        HomeDomainModule::class,
        HomeDataModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            app: Application
        ): AppComponent
    }
}