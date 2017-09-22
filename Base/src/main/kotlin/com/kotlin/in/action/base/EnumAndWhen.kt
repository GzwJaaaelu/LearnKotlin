package com.kotlin.`in`.action.base

//  enum class 是声明一个枚举类

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

//  当然枚举也可以声明属性与方法

enum class ColorWithValue(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(256, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    //  如果声明方法，需要在最后一个元素的位置添加分号
    fun rgb() = (r * 256 + g) * 256 + b
}

fun main(args: Array<String>) {
    val color = Color.ORANGE
    println("$color ${getMnemonic(color)}")
    println("$color ${getWarmth(color)}")
    println("BLUE + VIOLET = ${mix(Color.VIOLET, Color.BLUE)}")
}

//  when 表达式是 Java 中 switch 的替代
//  不需要为每一个分支都写一个 break

fun getMnemonic(color: Color): String {
    return when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }
}

//  多个分支指向一个结果

fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

//  Java 中 switch 需要使用常量作为分支条件
//  Kotlin 中循序任意对象作为分支条件

fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> throw Exception("没有找打合成的颜色")
}

//  不带参数的 when
//  这时候分支条件就需要是任意的 Boolean 表达式了

fun mixOptimize(c1: Color, c2: Color) = when {
    (c1 == Color.RED && c2 == Color.YELLOW) ||
            (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
    (c1 == Color.BLUE && c2 == Color.YELLOW) ||
            (c1 == Color.YELLOW && c2 == Color.BLUE) -> Color.GREEN
    (c1 == Color.BLUE && c2 == Color.VIOLET) ||
            (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
    else -> throw Exception("没有找打合成的颜色")
}