package com.gzw.kotlin

fun main(args: Array<String>) {
    //  基本类型
    val intArray: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val hello: CharArray = charArrayOf('h', 'e', 'l', 'l', 'o')
    //  其他的引用类型
    val stringArray: Array<String> = arrayOf("a", "b", "c", "d")

    println(intArray.size)
    println(intArray[3])

    for (word in stringArray) {
        println(word)
    }

    //  拼起来
    println(intArray.joinToString(""))
    println(hello.joinToString(""))
    println(stringArray.joinToString(""))

    //  去 [1-2] 位置对应的元素
    println(intArray.slice(1..2))
}