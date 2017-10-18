package com.kotlin.`in`.mooc.coroutine.async

import javax.swing.SwingUtilities
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

class UiContinuationWrapper<T>(val continuation: Continuation<T>):Continuation<T> {

    override val context: CoroutineContext
        get() = continuation.context

    override fun resume(value: T) {
        SwingUtilities.invokeLater {
            //  拿到数据再切换回主线程
            continuation.resume(value)
        }
    }

    override fun resumeWithException(exception: Throwable) {
        SwingUtilities.invokeLater {
            continuation.resumeWithException(exception)
        }
    }
}