package com.kotlin.`in`.mooc.demo

import java.io.File
import java.util.*

//  统计某个文件的字符出现的个数

fun main(args: Array<String>) {
    val map = TreeMap<Char, Int>()
    //  读文件并且过滤掉空白字符
    //  方式一
//    File("build.gradle").readText()
//            .toCharArray()
//            .filterNot(Char::isWhitespace)
//            .forEach {
//                val count = map[it]
//                if (count == null) map[it] = 1
//                else map[it] = count + 1
//            }
//    map.forEach(::println)
    //  方式二
    //  Kotlin 风格
    File("build.gradle").readText()
            .toCharArray()
            .filterNot(Char::isWhitespace)
            .groupBy { it }
            .map {
                it.key to it.value.count()
            }.forEach(::println)
}