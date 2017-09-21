package com.kotlin.`in`.mooc.demo

fun main(args: Array<String>) {
    while (true) {
        try {
            println("请输入类似的式子： 3 + 4 （参数一 操作符 参数二）")
            readLineAndGetArgs()
        } catch (e: NumberFormatException) {
            println("您确定输入的正确么？")
        } catch (e: IllegalArgumentException) {
            println("您确定您输入是用空格分割的么？")
        } catch (e: Exception) {
            println("其他错误 ${e.message}")
        }

        println("是否继续？[Y]")
        val cmd = readLine()
        if (cmd != null && cmd.toLowerCase() == "y") {
            continue
        } else {
            break
        }
    }

    println("感谢您使用我们的计算器")
}

fun readLineAndGetArgs() {
    //  readLine() 不为 null 则赋值，否则直接 break
    val input = readLine() ?: return
    //  必须要有空格才能分割
    val splits = input.trim().split(" ")
    if (splits.size < 3) {
        throw IllegalArgumentException("参数个数不对")
    }
    val arg1 = splits[0].toDouble()
    val op = splits[1]
    val arg2 = splits[2].toDouble()
    println("$arg1 $op $arg2 = ${Operator(op).apply(arg1, arg2)}")

}

class Operator(op: String) {
    private val opFun: (left: Double, right: Double) -> Double

    init {
        opFun = when (op) {
            "+" -> { l, r -> l + r }
            "-" -> { l, r -> l - r }
            "*" -> { l, r -> l * r }
            "/" -> { l, r -> l / r }
            "%" -> { l, r -> l % r }
            else -> throw UnsupportedOperationException("不支持的运算符 $op")
        }
    }

    fun apply(left: Double, right: Double): Double {
        return opFun(left, right)
    }
}