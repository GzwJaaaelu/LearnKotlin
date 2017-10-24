package com.kotlin.`in`.mooc.withJava

//  类型别名
typealias Runnable = () -> Unit

class SAMInKotlin {

    fun addTask(runnable: Runnable) {
        //  省略
    }
}

fun main(args: Array<String>) {

    val sam = SAMInKotlin()
    //  这时候就可以传入 Lambda 了
    sam.addTask { println("Kotlin") }
}