package com.chetan.test.ui

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 *
 * Base application class for instrumented tests.
 *
 */
abstract class DaggerTestApplication : DaggerApplication(){
    abstract val component : AndroidInjector<out DaggerApplication>
    public override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }
}