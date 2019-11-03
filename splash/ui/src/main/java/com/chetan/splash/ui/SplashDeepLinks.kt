package com.chetan.ui

import androidx.navigation.navOptions
import com.chetan.ui.NavigateTo.DeepLink

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

