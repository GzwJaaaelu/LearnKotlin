package com.kotlin.`in`.mooc.coroutine.other

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.CoroutineContext

class DownloadContext(val url: String): AbstractCoroutineContextElement(Key){
    companion object Key: CoroutineContext.Key<DownloadContext>
}