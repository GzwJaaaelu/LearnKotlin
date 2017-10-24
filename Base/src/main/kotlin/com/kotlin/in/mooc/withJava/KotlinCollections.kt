package com.kotlin.`in`.mooc.withJava

//  Kotlin 中分为可变集合和不可变集合，但最终映射到 Java 中都对应着 List、Map、Set

fun main(args: Array<String>) {
    //  listOf 生成的 list 是个不可变的 List，没有 Add 和 Remove 方法
    var list = listOf("A", "B")
    //  没有 put，也不可变
    var map = mapOf("A" to 1, "B" to 2)
}