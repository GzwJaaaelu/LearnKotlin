package com.kotlin.`in`.mooc.coroutine

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

class ContextCoroutine(override val context: CoroutineContext = EmptyCoroutineContext) : Continuation<Unit> {

    override fun resume(value: Unit) {
    }

    override fun resumeWithException(exception: Throwable) {
    }

}