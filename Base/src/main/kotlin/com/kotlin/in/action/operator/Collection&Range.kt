package com.kotlin.`in`.action.operator

import java.time.LocalDate

data class MutablePoint(var x: Int, var y: Int) {

    operator fun set(index: Int, value: Int) {
        when (index) {
            0 -> y = value
            1 -> y = value
            else -> IndexOutOfBoundsException("无效的下标")
        }
    }
}

fun main(args: Array<String>) {
    val map = mutableMapOf(1 to "A", 2 to "B", 3 to "C")
    //  通过 get / set 访问
    //  map[key] / map[key] = value
    println(map[1])
    map[2] = "2"
    println(map)

    val p = Point(1, 10)
    println(p[0])
    println(p[1])
//    println(p[2])

    val mp = MutablePoint(1, 20)
    mp[1] = 2
    println(mp)

    val r = Rectangle(Point(1, 1), Point(100, 100))
    //  in 运算符会被转为 contains
    //  a in b -> a.contains(b)
    println(p in r)

    //  rangeTo
    //  rangeTo 是 Comparable 的扩展函数
    //  rangeTo 运算符的优先级低于算数运算符
    //  start..end -> start.rangeTo(end)
    //  日期区间
    val now = LocalDate.now()
    //  未来十天
    val vacation = now..now.plusDays(10)
    println(now.plusDays(1) in vacation)
    (1..10).forEach(::println)

    //  for 循环中也可以使用 in 运算符，但这种情况下和上面的表示含义不同，它被用来执行迭代
    //  for (x in list) {...} 实际上被转为 list.iterator()，然后就像 Java 中一样，反复调用 hasNext 和 next
    for (x in 1..10) {
        print("$x ")
    }
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("无效的下标")
    }
}

data class Rectangle(private val upperLeft: Point, private val lowerRight: Point) {

    operator fun contains(p: Point): Boolean {
        //  until 用来构建一个开区间，然后用 in 判断是否在区间内
        //  10..20 表示闭区间为 10 - 20， 10 until 20 位开区间表示 10 - 19
        return p.x in upperLeft.x until lowerRight.x &&
                p.y in upperLeft.y until lowerRight.y
    }
}