package com.kotlin.`in`.action.lambda.collectionLambda

import com.kotlin.`in`.action.lambda.Person

//  groupBy 把列表转为分组的 map

fun main(args: Array<String>) {
    val people = listOf(Person("A", 11),
            Person("B", 22),
            Person("C", 33),
            Person("D", 33))
    //  按照不同年龄进行分组，groupBy 返回的是一个 map
    println(people.groupBy { it.age })

    val list = listOf("a", "ab", "b")
    //  按照首字母分类
    println(list.groupBy(String::first))
}