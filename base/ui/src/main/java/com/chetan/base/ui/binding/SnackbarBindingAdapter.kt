package com.chetan.base.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.chetan.base.ui.SnackbarEvent
import com.chetan.base.ui.event.consume
import com.chetan.base.ui.resolve
import com.google.android.material.snackbar.Snackbar

/**
 * Shows snackbar with the string resource id wrapped inside an event.
 *
 * Note: The string resource is wrapped inside an event because showing a snackbar is an event, which should be
 * consumed only once.
 */
@BindingAdapter("snackbar")
fun View.showSnackbar(event: SnackbarEvent) {
    if (event != SnackbarEvent.NONE) {
        event.consume {
            val message = it.message.resolve(context)
            Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
        }
    }
}
