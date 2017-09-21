package com.kotlin.`in`.mooc.someNew

fun main(args: Array<String>) {
    args.isEmpty()

    //  这样就可以直接通过字符串调用这个方法了
    println("Jaaaelu ".multiply(8))
    //  操作符的拓展
    println("Jaaaelu " * 8)

    println("abc".test)
    println("abc".testVar)
}

//  扩展方法或者扩展成员是可以在某个原有类基础上
//  无需写若干 xxxUtil
//  如：为 String 扩展一个 重复多次的字符串方法
//  String.multiply 前面为为 String 扩展，后面为方法名
//  int 为重复次数 返回一个 String
//  这时候里面就有了一个 this，而这个 this 就指代调用的这方法的对象了

//  Java 中如何调用呢？ 类名.方法名
//  如 Expand.multiply("Jaaaelu ", 8)
fun String.multiply(int: Int): String {
    val stringBuild = StringBuffer()
    for (i in 0 until int) {
        stringBuild.append(this)
    }
    return stringBuild.toString()
}

operator fun String.times(int: Int): String {
    val stringBuild = StringBuffer()
    for (i in 0 until int) {
        stringBuild.append(this)
    }
    return stringBuild.toString()
}

//  给 String 扩展成员常量
val String.test: String
    get() = "abc"

//  给 String 拓展成员变量
var String.testVar: Int
    set(value) {

    }
    get() = 111