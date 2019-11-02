package com.chetan.ui

import androidx.lifecycle.ViewModel
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * ViewModel for splash screen
 */
class SplashViewModel @Inject constructor() : ViewModel(){

    companion object{
        const val  SPLASH_TIME = 1L
        val SPLASH_TIME_UNIT = TimeUnit.SECONDS
    }
    val navigator = Navigator()
}

