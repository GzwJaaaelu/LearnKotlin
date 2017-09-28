package com.kotlin.`in`.mooc.someNew

import com.kotlin.`in`.action.base.b
import java.io.OutputStream
import java.nio.charset.Charset

//  科理化 将多参数函数变化为一系列单参数函数的变换

fun log(tag: String, target: OutputStream, message: Any?) {

    target.write("[$tag] $message \n".toByteArray())
}

//  log 的科理化
//fun log(tag: String)
//        = fun(target: OutputStream)
//        = fun(message: Any?)
//                = target.write("[$tag] $message \n".toByteArray())


fun main(args: Array<String>) {
    log("Gzw", System.out, "Hello")
//    log("Gzw")(System.out)("HelloAgain")

    ::log.curried()("Gzw")(System.out)("HelloAgain")

    //  这样的话每次只需要传入想要打印的传入即可
    //  这个函数就是原来函数的一个偏函数
    val consoleLogWithTag = (::log.curried()("Gzw")(System.out))

    consoleLogWithTag("Hello")
    consoleLogWithTag("HelloAgain")

    val bytes = "我是中国人".toByteArray(charset("GBK"))
    println(makeStringFromGBK(bytes))
}

//  自动的科理化（对于三个参数的来说）
fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried()
        = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)

val makeString = fun(byteArray: ByteArray, charset: Charset): String {
    return String(byteArray, charset)
}

//  固定了第二个参数
val makeStringFromGBK = makeString.partial2(charset("GBK"))

fun <P1, P2, R> Function2<P1, P2, R>.partial2(p2: P2)
        = fun(p1: P1) = this(p1, p2)

fun <P1, P2, R> Function2<P1, P2, R>.partial1(p1: P1)
        = fun(p2: P2) = this(p1, p2)
