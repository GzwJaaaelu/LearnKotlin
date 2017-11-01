package com.kotlin.`in`.action.operator

//  可重载的二元算数运算符
//  a * b -> times
//  a / b -> div
//  a % b -> mod
//  a + b -> plus
//  a - b -> minus

//  特殊运算符
//  shl -> 带符号左移
//  shr -> 带符号右移
//  ushr -> 无符号右移
//  and -> 按位与
//  or -> 按位或
//  xor -> 按位异或
//  inv -> 按位取反

//  一元运算符
//  +a -> unaryPlus
//  -a -> unaryMinus
//  !a -> not
//  ++a, a++ -> inc
//  --a, a-- -> dec

data class Point(val x: Int, val y: Int) {
    //  重载 plus 运算符
    //  且并不要求两个运算数是相同类型，返回值也可以不同
    //  不支持交换性
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }
}

fun main(args: Array<String>) {
    //  也相当于 Point(10, 20).plus(Point(20, 10))
    println(Point(10, 20) + Point(20, 10))
    println('a' * 3)
    var point = Point(10, 20)
    //  复合运算符
    //  += 可以被转换为 plus 或者 plusAssign（但最好不要同时重载这两个方法）
    //  point = point + Point(10, 20)
    point += Point(10, 20)
    println(point)

    //  有些情况下，定义 += 可以修改使用它的变量所引用的对象，但不会重新分配引用
    val numbers = ArrayList<Int>()
    numbers += 42
    numbers += 48
    println(numbers[0])
    println(numbers[1])

    //  对于集合来说 + 和 - 总会返回一个新的集合
    //  当+= 和 -= 用于可变集合时，始终就地修改它们，而用于只读集合时，会返回一个修改过的副本（只读集合被声明成 var 才能使用）

    //  一元运算符
    println(-point)
}

//  把运算符定义为扩展方法
operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}

operator fun Char.times(count: Int): String {
    return toString().repeat(3)
}