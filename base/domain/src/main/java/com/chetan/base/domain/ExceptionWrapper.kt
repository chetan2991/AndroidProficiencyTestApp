package com.chetan.base.domain

/**
 * Wrapper for [error][Throwable] with a [message][ErrorMessage].
 */
class ExceptionWrapper(
    val errorMessage: ErrorMessage,
    cause: Throwable
) : Exception("${cause.message} ${errorMessage.message}", cause)
