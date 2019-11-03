package com.chetan.splash.ui

import androidx.navigation.navOptions
import com.chetan.base.ui.NavigateTo
import com.chetan.base.ui.fadeAnimation


/**
 *
 * Deep-links for navigating from [SplashFragment]
 */
object SplashDeepLinks {
    private val deepLinkToHome = NavigateTo.DeepLink(
        "assignment://chetan/home",
        navOptions {
            popUpTo(R.id.splashFragment) {
                inclusive = true
            }
            fadeAnimation()
        }
    )
    fun deepLinkToHome() = deepLinkToHome
}

