package com.chetan.base.ui

import android.content.Context
import androidx.annotation.StringRes
import com.chetan.base.domain.ExceptionWrapper

/**
 * Data class to represent a [message resource][messageId] with a optional [failure][error].
 */
data class Message(
    @StringRes val messageId: Int,
    val error: Throwable? = null
)

/**
 * To resolve a message as a [String].
 */
fun Message.resolve(context: Context): String {
    return if (error is ExceptionWrapper) {
        error.errorMessage.message
    } else {
        context.getString(messageId)
    }
}
