package com.chetan.base.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.chetan.base.ui.Visibility
import com.chetan.base.ui.hideKeyboard

/**
 * Sets [visibility][View.setVisibility] of the given view.
 */
@BindingAdapter("visibility")
fun View.setVisibility(visibility: Visibility) {
    when (visibility) {
        Visibility.VISIBLE -> this.visibility = View.VISIBLE
        Visibility.INVISIBLE -> this.visibility = View.INVISIBLE
        Visibility.GONE -> this.visibility = View.GONE
    }
}

/**
 * Binding adapter for on-click listener for view which also hide the keyboard before dispatching the event.
 */
@BindingAdapter("onClickHideKeyboard")
fun View.setOnClickHideKeyboardListener(listener: View.OnClickListener) {
    setOnClickListener {
        hideKeyboard()
        listener.onClick(it)
    }
}
