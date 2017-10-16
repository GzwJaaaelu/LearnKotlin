package com.kotlin.`in`.action.kotlin

//  String = String，不能存储 null 引用
//  所以默认情况下类型都是非空的
fun strLen(s: String) = s.length

//  String? = String or null
//  这里是显式的标记出使用可空的 String
//  s?.length 表示如果 s 不为空会返回 s.length 否则返回 null
//  相当于 if (s != null) s.length else null
fun strLenCanNullNoException(s: String?) = s?.length

//  带有默认值 ?. 后面跟的就是默认值
fun strLenCanNullNoExceptionAndWithDefault(s: String?) = s?.length ?: 0

//  虽然可以用作默认值，当然也可以用于其他功能，如抛出异常
fun strLenThrowException(s: String?) = s?.length ?: throw NullPointerException("字符串为空")

//  s!!.length 表示如果 s 为 null 会直接抛出空指针异常，不为 null 则可以返回 s.length
//  一般情况下，只有我们知道 s 一定不为 null 的时候使用
//  !! 也叫做非空断言，尽量在一行代码中使用多个非空断言，因为你很难分清除是哪个 !! 让你程序抛出空指针异常
fun strLenCanNullWillException(s: String?) = s!!.length

fun main(args: Array<String>) {
    //  方接收的是一个不能为空的 String
    //  如果传入空会提示 Null can not be a value of a non-null type String
    println(strLen("A B C"))
    println(strLenCanNullWillException("A B C"))
    println(strLenCanNullNoException(null))
    println(strLenCanNullNoExceptionAndWithDefault(null))
    println(strLenCanNullNoExceptionAndWithDefault(null))
    println(strLenThrowException(null))
}