package com.kotlin.`in`.mooc.coroutine

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

class BaseCoroutine : Continuation<Unit> {

    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resume(value: Unit) {
    }

    override fun resumeWithException(exception: Throwable) {
    }

}