package com.chetan.test.ui

import android.content.Context
import android.view.ContextThemeWrapper
import androidx.test.core.app.ApplicationProvider.getApplicationContext

/**
 * Returns ContextThemeWrapper with AppCompat theme.
 */
fun themedContext(): ContextThemeWrapper {
    val context = getApplicationContext<Context>()
    return ContextThemeWrapper(context, R.style.Theme_AppCompat)
}
