package com.chetan.splash.ui

import androidx.lifecycle.*
import com.chetan.base.ui.Navigator
import com.chetan.splash.ui.SplashDeepLinks.deepLinkToHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for splash screen
 */
class SplashViewModel @Inject constructor() : ViewModel() {
    val splashState: LiveData<SplashRedirectionState>
        get() = mutableSplashState
    private val mutableSplashState = MutableLiveData<SplashRedirectionState>()
    val navigator = Navigator()

    companion object {
        const val SPLASH_TIME_MILISECONDS = 3000L
    }

    fun performSplashAction() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(SPLASH_TIME_MILISECONDS)
            mutableSplashState.postValue(SplashRedirectionState.HomeState)
        }
    }

    fun navigate(splashRedirectionState: SplashRedirectionState) {
        when (splashRedirectionState) {
            SplashRedirectionState.HomeState -> navigator.navigate(deepLinkToHome())
        }
    }

    sealed class SplashRedirectionState {
        object HomeState : SplashRedirectionState()
    }
}

