package com.kotlin.`in`.mooc.someNew

import java.io.OutputStream

//  科理化 将多参数函数变化为一系列单参数函数的变换

fun log(tag: String, target: OutputStream, message: Any?) {

    target.write("[$tag] $message \n".toByteArray())
}

//  log 的科理化
fun log(tag: String)
        = fun(target: OutputStream)
        = fun(message: Any?)
                = target.write("[$tag] $message \n".toByteArray())


fun main(args: Array<String>) {
    log("Gzw", System.out, "Hello")
    log("Gzw")(System.out)("HelloAgain")

//    ::log.curried()("Gzw")(System.out)("HelloAgain")
}

//  自动的科理化（对于三个参数的来说）
fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried()
        = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)