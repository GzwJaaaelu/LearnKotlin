package com.kotlin.`in`.action.kotlin

import java.util.*

//  创建可空性的集合时，需要注意的时候，要小心决定什么是可空的，是元素可空还是集合本身可空，还是两者都可为空？
//  List<Int?>、List<Int>?、List<Int?>?

//  Kotlin 中把访问集合数据的接口和修改集合数据的接口分开了（只读集合 Collection 与可变集合 MutableCollection）
//  kotlin.collections.Collection 只读集合提供了 size、iterator、contains 等操作来查看读取数据
//  kotlin.collections.MutableCollection 可变的集合提供了 add、remove、clear 等修改集合的操作，不过 MutableCollection
//  继承自 Collection，所有也拥有那些读取操作
//  如果函数接收 Collection 而不是 MutableCollection，那么就很容易知道这个方法不会修改集合，只会读取集合数据。

//  只读集合并一定是不可变的，当只读集合和可变集合指向同一个集合对象的时候，可变可以进行操作，然后只读读取操作后的集合。
//  只读集合并不总是线程安全的。
//  即使在 Kotlin 中将集合声明成只读，Java 代码也能够修改这个集合，因为 Java 中并不区分只读集合和可变集合。

//  List 创建集合函数，只读 -> listOf，可变 -> mutableListOf、arrayListOf
//  Set 创建集合函数，只读 -> setOf，可变 -> mutableSetOf、hashSetOf、linkedSetOf、sortedSetOf
//  Map 创建集合函数，只读 -> mapOf，可变 -> mutableMapOf、hashMapOf、linkedMapOf、sortedMapOf

fun main(args: Array<String>) {
    addValidNumbers(listOf(1, 2, 3, null, null))

    val list = listOf(1, 2, 3, 4, 5)
    var mutable: MutableCollection<Int> = MutableList(list.size, { x: Int -> x * x })
    copyElements(list, target = mutable)
    println(mutable)
    //  只读集合并一定是不可变的
    val c: Collection<Int> = mutable
    var m: MutableCollection<Int> = mutable
    m.clear()
    println(c)
    printlnListReverse(listOf("A", "B", "C"))

    //  创建字符数组
    val letters = Array(26) { i -> ('A' + i).toString() }
    println(letters.joinToString(""))

    Array<Int>(26) { i -> (26 + i) }

    val strings = listOf("a", "b", "c")
    //  *strings 表示将 strings 展开
    println("%s/%s/%s".format(*strings.toTypedArray()))

    //  Array<Int> 将会是一个包含装箱整型的数组
    //  IntArray 是基础类型 int 的数组，也就是 Java 中的 int[]，这样效率会更高一些

    //  forEachIndexed
    letters.forEachIndexed { index, element ->
        println("Argument $index is: $element")
    }
}

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun <T> copyElements(source: Collection<T>,
                     target: MutableCollection<T>) {
    target += source
}

fun printlnListReverse(list: List<String>) {
    //  通过 Java 方法操作了只读集合
    Collections.reverse(list)
    println(list)
}