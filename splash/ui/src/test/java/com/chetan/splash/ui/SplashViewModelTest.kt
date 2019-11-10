package com.chetan.splash.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.chetan.splash.ui.SplashDeepLinks.deepLinkToHome
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test

class SplashViewModelTest {

    @get:Rule
    val instantTaskExecuterRule = InstantTaskExecutorRule()

    @Test
    fun navigateToHomeScreen_whenSplashActionComplete(){
        //given
        val viewModel = SplashViewModel()

        //when
        runBlocking {
            viewModel.performSplashAction()
        }
        assertThat(viewModel.navigator, navigatedTo(deepLinkToHome()))
    }

}


