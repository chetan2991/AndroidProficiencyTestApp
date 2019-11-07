package com.chetan.home.domain.di

import com.chetan.home.domain.GetFacts
import com.chetan.home.domain.GetFactsImpl
import dagger.Binds
import dagger.Module

@Module
abstract class HomeDomainModule {
    @Binds
    abstract fun getFacts(getHomeList: GetFactsImpl) : GetFacts
}
