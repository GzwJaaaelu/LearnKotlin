package com.kotlin.`in`.action.base

import java.util.*

//  while 和 do...while 的使用方式和 Java 中相同，这里不做介绍

//  for 循环


fun main(args: Array<String>) {
    //  .. 表示区间(闭区间)，oneToTen也就表示 1-10 的所有数
    val oneToTen = 1..10

    for (i in oneToTen) {
        print("$i   ")
    }

    println()

    //  从 100 到 1，且步长为 5
    //  100 downTo 1 也是闭区间的
    for (i in 100 downTo 1 step 5) {
        print("$i   ")
    }

    println()

    //  until 就是用来表示搬开区间的 [1, 6)
    for (i in 1 until 6) {
        print("$i   ")
    }

    println()

    //  迭代 map
    val binaryReps = TreeMap<Char, String>()

    for (ch in 'A'..'C') {
        val binary = Integer.toBinaryString(ch.toInt())
        //  这句相当于 binaryReps.put(ch, binary)
        binaryReps[ch] = binary
    }

    //  Key - Value
    for ((letter, binary) in binaryReps) {
        println("$letter - $binary")
    }

    val list = arrayListOf("A", "B", "C")
    //  不带下标的遍历
    for (word in list) {
        println(word)
    }
    //  带下表的遍历
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    //  上面我们看到了 in 可以用来遍历，同时 in 还可以用来检测某个值是否在某个区间内
    //  in 在不同的位置表示不同的函数
    if ("B" in list) {
        println("B 在 [A, B, C] 内")
    }
}