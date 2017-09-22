package com.kotlin.`in`.action.base

//  和 Java 中的异常机制类似
//  抛出异常然后抓住异常，以防程序崩溃

fun main(args: Array<String>) {

    //  try 还可以作为表达式
    //  如果没有异常发生那么 try 中的最后一个表达式就是结果
    //  如果发生了异常则 catch 中的最后一个表达式为结果
    val number = try {
        val v = readLine()
        Integer.parseInt(readLine())
    } catch (e: NumberFormatException) {
        println("输入的好像不是整数...程序终止。")
        //  如果输入的不对，那么就返回 -1024
        -1024
    }

    println(number)

    try {
        println("执行可能有问题的代码前")
        eval(Other())
        println("执行可能有问题的代码后")
    } catch (e: IllegalArgumentException) {
        println("遇到了异常 -> ${e.message}")
    } finally {
        println("一定会执行的代码块")
    }
}