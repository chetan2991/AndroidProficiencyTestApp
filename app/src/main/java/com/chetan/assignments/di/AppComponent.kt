package com.chetan.assignments.di

import android.app.Application
import com.chetan.assignments.App
import com.chetan.splash.ui.di.SplashUiModule
import com.chetan.ui.di.BaseUiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
AndroidSupportInjectionModule::class,
    BaseUiModule::class,
    SplashUiModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            application: Application
        ): AppComponent
    }
}