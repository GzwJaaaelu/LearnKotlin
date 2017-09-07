package com.gzw.kotlin

fun main(args: Array<String>) {
    try {
        val arg1 = args[0].toInt()
        val arg2 = args[1].toInt()
        println("返回？")
        println("$arg1 + $arg2 = ${sumArg(arg1, arg2)}")
        println("返回")
    } catch (e: NumberFormatException) {
        println("您确定您输入的整数么？")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("您好像没有输入参数...")
    } catch (e: Exception) {
        println("未知异常~ + ${e.message}")
    } finally {
        //  不管有无异常 finally 都会执行
        println("感谢您的使用！")
    }

    //  try 也是表达式
    val result = try {
        args[0].toInt() / args[1].toInt()
    } catch (e: Exception) {
        0
    }
    println(result)
}

fun sumArg(arg1: Int, arg2: Int): Int {
    return arg1 + arg2
}