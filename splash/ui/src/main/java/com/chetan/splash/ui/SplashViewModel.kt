package com.chetan.ui

import androidx.lifecycle.*
import com.chetan.ui.SplashDeepLinks.deepLinkToHome
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for splash screen
 */
class SplashViewModel @Inject constructor() : ViewModel() {
    fun navigate(it: SplashRedirectionState) {
        when (it) {
            SplashRedirectionState.HomeState -> navigator.navigate(deepLinkToHome())
        }
    }

    companion object {
        const val SPLASH_TIME_MILISECONDS = 3000L
    }

    val splashState: LiveData<SplashRedirectionState>
        get() = mutableSplashState
    private val mutableSplashState = MutableLiveData<SplashRedirectionState>()

    val navigator = Navigator()

    init {
        viewModelScope.launch {
            delay(SPLASH_TIME_MILISECONDS)
            mutableSplashState.postValue(SplashRedirectionState.HomeState)
        }
    }

    sealed class SplashRedirectionState {
        object HomeState : SplashRedirectionState()
        object LoginState : SplashRedirectionState()
        object ErrorState : SplashRedirectionState()
    }
}

