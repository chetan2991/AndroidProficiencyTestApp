package com.chetan.base.ui

import com.chetan.base.ui.event.BaseEvent


/**
 * Data class that represents a Snackbar event.
 */
data class SnackbarEvent(
    val message: Message,
    override var consumed: Boolean = false
) : BaseEvent() {

    constructor(
        messageId: Int,
        error: Throwable? = null
    ) : this(Message(messageId, error))

    companion object {
        val NONE = SnackbarEvent(-1)
    }
}
