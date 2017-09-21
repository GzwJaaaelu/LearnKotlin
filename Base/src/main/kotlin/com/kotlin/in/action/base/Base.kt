package com.kotlin.`in`.action.base

//  在 Kotlin 中，if 是表达式，而不是语句。表达式与语句的区别在于，表达式有值，且能作为另一个表达式的一部分使用

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

//  表达式函数体
//  可以让前面的函数变得更简单，这里函数体由单个表达式构成
fun max2(a: Int, b: Int): Int = if (a > b) a else b
//  可以可以省去返回类型声明，而是采用类型推导
//  单只有表达式体函数乐意省略返回值，有返回值的代码块函数不可省略
fun max3(a: Int, b: Int) = if (a > b) a else b

//  7.5 * （10 的 6次方）
//  val 不可变引用（初始化后不可变）
//  且注意是引用不可变，而不是值不可变，如一个对象的引用不能变，但是成员属性可以改变
//  尽可能使用 val 而不是 var
val a = 7.5e6
//  val 可以变引用
val b = "b"

fun main(args: Array<String>) {
    println(max(1, 2))
    println(max2(3, 2))
    println(max3(3, 3))
}