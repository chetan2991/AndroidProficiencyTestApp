package com.chetan.base.ui

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

/**
 * To hide the keyboard.
 */
fun View.hideKeyboard() {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

/**
 * To hide the keyboard using currently focused view on activity.
 */
fun Activity.hideKeyboard() {
    currentFocus?.hideKeyboard()
}

/**
 * To hide the keyboard using view of fragment.
 */
fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}
