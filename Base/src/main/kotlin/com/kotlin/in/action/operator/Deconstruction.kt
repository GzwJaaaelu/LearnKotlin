package com.kotlin.`in`.action.operator

//  解构声明和组件函数


fun main(args: Array<String>) {
    //  解构声明允许你展开单个复合值，并使用他来初始化多个单独的变量
    val p = Point(10, 20)
    //  解构声明看起来显示普通的变量声明
    //  每个变量的都会调用对应的 componentN 函数，N 时声明中的变量为止
    //  如这里的 val (x, y) = p，其实被转换为 val x = p.component1() / val y = p.component2()
    val (x, y) = p
    println(x)
    println(y)

    val c1 = C1(1, 2)
    //  解构声明的主要使用场景之一，是从一个函数返回多个值
    val (a, b) = c1
    println(a)
    println(b)

    //  使用解构声明来返回多个值
    val (name, ext) = splitFileName("Hello.kt")
    println(name)
    println(ext)

}

data class NameComponents(val name: String, val extension: String)

fun splitFileName(fullName: String): NameComponents {
    //  componentN 在集合和数组上也有定义
    val (name, ext) = fullName.split('.', limit = 2)
    return NameComponents(name, ext)
}

data class C(val a: Int, val b: Int)
data class D(val a: Int, val b: Int, val c: Int, val d: Int, val e: Int, val f: Int, val g: Int)

//  非数据类中也就是相当于这种写法
class C1(val a: Int, val b: Int) {

    operator fun component1() = a
    operator fun component2() = b
}

fun printMap(map: Map<String, String>) {
    //  用解构声明来遍历 map
    for ((key, value) in map) {
        println("$key -> $value")
    }
    //  实际上，上面的代码被转换为了这样的代码
    for (e in map.entries) {
        val key = e.component1()
        val value = e.component2()
    }
}

class A() {

    init {
        println("Init")
    }

    constructor(c: String) {

    }
}