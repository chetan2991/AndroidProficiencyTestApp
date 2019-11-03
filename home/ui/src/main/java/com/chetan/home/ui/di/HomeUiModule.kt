package com.chetan.home.ui.di

import androidx.lifecycle.ViewModel
import com.chetan.base.ui.di.ViewModelKey
import com.chetan.home.ui.HomeFragment
import com.chetan.home.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeUiModule {

    @ContributesAndroidInjector
    abstract fun homeFragment() : HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun homeViewModel(viewModel: HomeViewModel) : ViewModel

}
