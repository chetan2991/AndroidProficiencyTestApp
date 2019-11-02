package com.chetan.ui.di

import androidx.lifecycle.ViewModelProvider
import com.chetan.ui.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Dagger [module][Module] for ViewModel factory that declares [ViewModelProvider.Factory] to be bind into application
 * level object graph.
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
