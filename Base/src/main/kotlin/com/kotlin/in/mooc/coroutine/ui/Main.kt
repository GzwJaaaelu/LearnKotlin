package com.kotlin.`in`.mooc.coroutine.ui

import com.kotlin.`in`.mooc.coroutine.async.DownloadContext
import com.kotlin.`in`.mooc.coroutine.common.LOGO_URL
import com.kotlin.`in`.mooc.coroutine.common.log
import com.kotlin.`in`.mooc.coroutine.longRunning
import com.kotlin.`in`.mooc.coroutine.start
import com.kotlin.`in`.mooc.coroutine.startLoadingPic
import javax.swing.JFrame.EXIT_ON_CLOSE

fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.title = "Coroutine@Bennyhuo"
    frame.setSize(200, 150)
    frame.isResizable = true
    frame.defaultCloseOperation = EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true

    frame.onButtonClick {
        log("协程之前")
        start(DownloadContext(LOGO_URL)) {
            val imageData = longRunning {
                startLoadingPic(this[DownloadContext]!!.url)
            }
            log("拿到图片")
            frame.setLogo(imageData)
        }
        log("协程之后")
    }

}