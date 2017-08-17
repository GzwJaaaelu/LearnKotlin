package com.gzw.kotlin

//  常量 类似 Java 中的 final
//  Java 中 添加了 final 为编译期常量（编译时就能确定值）
//  而 val 只是不可变的变量，并不是编译期常量
//  如果想成为编译期需要添加 const
//  Kotlin 中的编译器常量如何定义？ const val
//  所以只写 val 来修饰，那么就还是运行时常量
const val FINAL_HELLO: String = "Hello"
//  变量
var hello: String = FINAL_HELLO
//  不指明具体类型（类型推导）
val FINALL_HELLO_WORLD = "HelloWorld"

fun main(args: Array<String>) {

}