package com.chetan.splash.ui

import androidx.navigation.navOptions
import com.chetan.ui.NavigateTo.DeepLink
import com.chetan.ui.fadeAnimation

/**
 *
 * Deep-links for navigating from [SplashFragment]
 */
object SplashDeepLinks {
    private val deepLinkToHome = DeepLink(
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

