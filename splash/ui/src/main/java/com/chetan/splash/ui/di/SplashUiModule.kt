package com.chetan.ui.di

import androidx.lifecycle.ViewModel
import com.chetan.ui.SplashFragment
import com.chetan.ui.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Dagger module for declaring UI layer dependencies for splash modue.
 */
@Module
abstract class SplashUiModule {

    @ContributesAndroidInjector
    abstract fun splashFragment() : SplashFragment

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun splashViewModel(viewModel: SplashViewModel) : ViewModel

}