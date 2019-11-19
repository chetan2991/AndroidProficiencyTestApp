package com.chetan.test.ui

import okreplay.OkReplayInterceptor

/**
 * Interface that provides [OkReplayInterceptor].
 */
interface OkReplayInterceptorProvider {
    val interceptor: OkReplayInterceptor
}
