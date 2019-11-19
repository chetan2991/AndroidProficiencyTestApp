package com.chetan.home.ui.app
import com.chetan.home.ui.di.DaggerTestAppComponent
import com.chetan.test.ui.DaggerTestApplication
class TestApp : DaggerTestApplication() {
    override val component by lazy {
            DaggerTestAppComponent
            .factory()
            .create(this)
    }
}



