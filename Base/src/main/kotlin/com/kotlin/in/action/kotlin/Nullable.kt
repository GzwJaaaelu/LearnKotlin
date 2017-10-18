package com.kotlin.`in`.action.kotlin

import com.kotlin.`in`.action.lambda.Person
import com.kotlin.`in`.action.lambda.sendEmail

//  安全的处理方式有 ?. ?: as?
//  非安全的处理方式有 !!

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
//    println(strLenThrowException(null))

    val p: Person? = Person("Gzw", 23)
    //  sendEmail 接收一个非空类型的 Person，所以需要先进行空判断，判断通过再继续
    if (p != null) sendEmail(p, "啦啦啦啦啦啦")
    //  还可以使用另一种方式 let
    //  如果 p 不为空，那么 it 就不为空，如果 p 为空什么都不会发生
    //  这里必须是 ?. 的调用方式，否则会报错
    p?.let { sendEmail(it, "，，，，，") }

    val s: String? = null
    println(s.isNullOrBlank())

    //  T 被推导为 Any?
    printlnHashCode(null)
    printlnHashCodeNotNull("")
}

//  可空类型的扩展方法
fun String?.isNullOrBlank(): Boolean {
    //  不过由于可能存在 null 的可能性，所以必须要有显示的非空检查
    return this == null || this.isBlank()
}

//  Kotlin 中所以泛型类和泛型函数的类型参数默认都是可空的
fun <T> printlnHashCode(t: T) {
    println(t?.hashCode())
}

//  为类型参数添加非空上界后，现在的 T 就不是可空的了
fun <T: Any> printlnHashCodeNotNull(t: T) {
    println(t.hashCode())
}