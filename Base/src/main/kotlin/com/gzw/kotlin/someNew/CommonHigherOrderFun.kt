package com.learn.kotlin

//  常见高阶函数
//  foreach


fun main(args: Array<String>) {
    //  正常情况下 Java 中我们都这么写
    val list = listOf(1, 2, 3, 4, 5, 6)

    val newList = ArrayList<Int>()

    list.forEach {
        newList.add(it * 2 + 3)
    }

//    newList.forEach(::println)

    //  这里直接使用 map 就可以了
    //  并不要求返回值
    val otherList = list.map(Int::toDouble)

    otherList.forEach(::println)

    //  整形集合的集合
    val lll = listOf(
            1..20,
            2..5,
            100..233
    )

    //  想变为打平之后的一个集合 [1，2，3，...,233]
    val lllFlat = lll.flatMap {
        //  只是 it 就可以打平了
//        it
        //  转为 List<String>
        it.map {
            "No.$it"
        }
    }

    //  上面写法其实也就是这中写法
    val lllOtherFlat = lll.flatMap { intRange ->
        intRange.map { intElement ->
            "No.$intElement"

        }
    }

    lllFlat.forEach(::println)

    //  求和
    //  acc 是上一次结果，s 是这一次的元素值
    println(list.reduce { acc, s -> acc + s })
    //  求阶乘
    println((1..5).reduce { acc, i -> acc * i })

    (0..6).map(::factorial).forEach(::println)
    //  求和且有一个初始值为 5
    println((0..6).map(::factorial).fold(5) { acc, i ->
        acc + i
    })

    println((0..6).map(::factorial).fold(StringBuilder()) { acc, i ->
        acc.append(i).append("/")
    })
}

fun factorial(n: Int): Int {
    if (n == 0) return 1
    return (1..n).reduce { acc, i -> acc * i }
}