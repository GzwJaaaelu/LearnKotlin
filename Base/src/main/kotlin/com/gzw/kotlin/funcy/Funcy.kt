package com.gzw.kotlin.funcy

//  默认返回 Unit 相当于 Java 中的 void，默认不写
fun main(args: Array<String>) {

    println("hello ${args[0]}")

    println("3 + 5 = ${sum(3, 5)}")
    println("3 + 5 = ${simpleSum(3, 5)}")
    println("3 toLong ${Int2Long(3)}")
}

fun sum(arg1: Int, arg2: Int): Int {
    return arg1 + arg2
}

/**
 * 简化版的 sum
 */
fun simpleSum(arg1: Int, arg2: Int) = arg1 + arg2

//  使用的函数必须要有一个名字，但如果使用变量接收就不需要了
//  函数也是一种类型，与 String Int 一样，可以赋值，可以传递，只不过它本身是代码块
val Int2Long = fun(x:Int) = x.toLong()