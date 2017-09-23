package com.kotlin.`in`.action.funcy

//  集合处理的一些方法
//  这里会涉及到 vararg（可变参数关键字）
//  中缀表达式（调用只有一个参数的函数时，使得代码更简练）
//  解构声明（用来把一个单独的组合值展开到多个变量中）


fun main(args: Array<String>) {
    //  无论是 listOf 还是 setOf 它们接收的参数都是 vararg elements: T
    //  也就是可变参数，所以才使得我们可以传递任意个数的参数
    println(listOf("first", "second", "fourteenth",
            "second", "fourteenth", "second", "fourteenth",
            "second", "fourteenth", "second", "fourteenth",
            "second", "fourteenth", "second", "fourteenth",
            "second", "fourteenth", "second", "fourteenth",
            "second", "fourteenth", "second", "fourteenth",
            "second", "fourteenth", "second", "fourteenth",
            "second", "fourteenth", "second", "fourteenth",
            "second", "fourteenth", "second", "fourteenth"))
    println(setOf(1, 5, 2).max())

    val array = arrayOf(1, 2, 3, 4, 5)
    //  Kotlin 中并不支持将已经打包好的数组传递给函数
    //  这时候就需要将其展开 关键字 * + 数组名
    //  * 也被称为展开运算符
    println(listOf(*array))

    //  1 to "A" 与 3.to("C") 的调用方式是一样的，这里的 to 其实是一种特殊的函数调用，被称为中缀调用
    //  一般情况下我们会使用 3.to("C") 这种函数调用的方式
    //  使用 infix 修饰后，方法可以使用中缀符号调用，即 1 to "A"
    println(mapOf(1 to "A", 2 to "B", 3.to("C")))

    //  调用
    println(2 toAny 3)

    //  这个功能称为解构声明
    val (number, name) = 2.toAny("B")
    //  这里的 withIndex() 也是解构声明
    for ((index, value) in (1..5).withIndex()) {
        println("$index -> $value")
    }
}

//  简单的自定义函数
//  当然中缀
infix fun Any.toAny(other:Any) = Pair(this, other)