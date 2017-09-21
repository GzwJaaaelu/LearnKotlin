package com.kotlin.`in`.mooc.someNew

/**
 * Created by jilinlin on 2017/8/6.
 */

fun getName(): String? {
    return null
}

fun main(args: Array<String>) {
    //  如果为 null，则打印 nuill，否则调用 name 的长度
    println(getName()?.length)
    //  如果 getName 不为 null，则赋值给 name
    //  否则将 "" 复制
    val name: String = getName() ?: ""
    println(name.length)

    val value: String? = "Gzw"
    //  类型不安全，但是加了 !! 表示我知道这个是可以用的
    println(value!!.length)
}