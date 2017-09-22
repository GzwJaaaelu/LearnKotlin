package com.kotlin.`in`.action.base

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
class Other : Expr

//  计算 （1 + 2）+ 4

fun eval(e: Expr): Int {
    return when (e) {
    //  这里进行了类型判断之后如果是就不需要自己手动做类型转换了，编译器已经自动帮我们做了
    //  且代码块中最后的表达式就是结果
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("未知类型")
    }
}

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(3))))
}