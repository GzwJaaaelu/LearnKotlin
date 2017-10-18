package com.kotlin.`in`.mooc.coroutine

import com.kotlin.`in`.mooc.coroutine.async.AsyncContext
import com.kotlin.`in`.mooc.coroutine.async.AsyncTask
import com.kotlin.`in`.mooc.coroutine.common.HttpError
import com.kotlin.`in`.mooc.coroutine.common.HttpException
import com.kotlin.`in`.mooc.coroutine.common.HttpService
import com.kotlin.`in`.mooc.coroutine.common.log
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine

fun start(context: CoroutineContext = EmptyCoroutineContext, block: suspend () -> Unit) {
    block.startCoroutine(ContextCoroutine(context + AsyncContext()))
}

suspend fun <T> longRunning(block: CoroutineContext.() -> T) = suspendCoroutine<T> {
    //  这里是最新耗时操作的地方
    continuation ->
    AsyncTask {
        try {
            continuation.resume(block(continuation.context))
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }
    }.execute()

}

//  suspendCoroutine<ByteArray> 泛型的数据类型表示表示你想要的数据结果
fun startLoadingPic(url: String): ByteArray {
    log("开始下载图片数据")

    val responseBody = HttpService.service.getLogo(url).execute()
    if (responseBody.isSuccessful) {
        //  把读到的数据丢给 continuation 的 resume 方法
        responseBody.body()?.byteStream()?.readBytes()?.let {
            return it
        }
        throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
    } else {
        throw HttpException(responseBody.code())
    }
}