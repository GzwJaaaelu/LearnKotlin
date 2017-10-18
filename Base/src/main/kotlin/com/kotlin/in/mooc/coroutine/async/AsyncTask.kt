package com.kotlin.`in`.mooc.coroutine.async

import java.util.concurrent.Executors

private val pool by lazy {
    Executors.newCachedThreadPool()
}

class AsyncTask(private val block: () -> Unit) {

    fun execute() = pool.execute(block)
}