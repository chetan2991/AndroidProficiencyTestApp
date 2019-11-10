package com.chetan.base.data.network

/**
 * Denotes that the annotated class is JSON entity and should not be removed when the code is minified at build time.
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation class Json
