package com.kotlin.`in`.mooc.coroutine.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.ContinuationInterceptor

class AsyncContext: AbstractCoroutineContextElement(ContinuationInterceptor), ContinuationInterceptor {

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return UiContinuationWrapper(continuation.context.fold(continuation) {
            continuation, element ->
            if (element != this && element is ContinuationInterceptor) {
                element.interceptContinuation(continuation)
            } else continuation
        })
    }
}