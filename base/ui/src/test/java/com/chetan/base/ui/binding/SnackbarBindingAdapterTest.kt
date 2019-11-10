package com.chetan.base.ui.binding

import android.widget.FrameLayout
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chetan.base.domain.ErrorMessage
import com.chetan.base.domain.ExceptionWrapper
import com.chetan.base.ui.SnackbarEvent
import com.chetan.base.ui.event.consume
import com.chetan.test.ui.hasNoSnackbar
import com.chetan.test.ui.hasSnackbar
import com.chetan.test.ui.themedContext
import com.chetan.test.ui.withMessage
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SnackbarBindingAdapterTest {

    private val view = FrameLayout(themedContext())

    @Test
    fun shouldShowSnackbar_whenNoError() {
        val message = android.R.string.ok

        view.showSnackbar(SnackbarEvent(message))

        assertThat(view, hasSnackbar(withMessage(message)))
    }

    @Test
    fun shouldShowSnackbar_whenError() {
        val message = "Snackbar Message"
        val snackbarEvent = SnackbarEvent(
            android.R.string.ok,
            ExceptionWrapper(ErrorMessage(message), Throwable())
        )

        view.showSnackbar(snackbarEvent)

        assertThat(view, hasSnackbar(withMessage(message)))
    }

    @Test
    fun shouldNotShowSnackbar_whenMessageIsNone() {
        val snackbarEvent = SnackbarEvent.NONE

        view.showSnackbar(snackbarEvent)

        assertThat(view, hasNoSnackbar())
    }

    @Test
    fun shouldNotShowSnackbar_whenMessageIsConsumed() {
        val snackbarEvent = SnackbarEvent(android.R.string.ok)
        snackbarEvent.consume { }

        view.showSnackbar(snackbarEvent)

        assertThat(view, hasNoSnackbar())
    }
}
