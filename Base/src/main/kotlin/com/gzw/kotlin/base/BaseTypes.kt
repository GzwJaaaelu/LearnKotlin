package com.gzw.kotlin.base

/**
 * Created by jilinlin on 2017/8/5.
 */
fun main(args: Array<String>) {
    //  相当于 Java 中的 boolean 或 Boolean
    val aBoolean: Boolean = true
    //  32 位
    val aInt: Int = 1
    //  64 位
    val aLong: Long = 1111111111111111111
    //  16 位
    val aShort: Short = 1
    //  8 位
    val aByte: Byte = 1
    //  32 位
    val aFloat: Float = 2f
    //  64 位
    val aDouble: Double = 1.0
    //  字符 16 位 Unicode
    val aChar: Char = ' '

    val aString: String = "hello"
    val aOtherString: String = String(charArrayOf('h', 'e', 'l', 'l', 'o'))
    //  两个 = 相当于 Java 中 equal
    println(aString == aOtherString)
    //  三个 = 相当于 Java 中 == 对比地址
    println(aString === aOtherString)

    val arg1: Int = 0
    val arg2: Int = 2
    //  Java 写法
    println("" + arg1 + " + " + arg2 + " = " + (arg1 + arg2))
    //  Kotlin 写法
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    //  """ 表示原始字符串 无法使用转移字符串
    val rawString: String = """
    /t
    /n
    $arg2
    """
    println(rawString)
    println(rawString.length)
    //  区间
    //  表示 [0, 1024] 闭区间
    val ranger: IntRange = 0..1024
    //  表示 [0, 1024) = [0, 1023] 半开区间
    val rangerEndOpen: IntRange = 0 until 1024
    //  空区间前大于后
    val emptyRanger: IntRange = 0..-1
    println(emptyRanger.isEmpty())
    println(ranger.contains(500))
    //  这两句话等价
    println(500 in ranger)
}
