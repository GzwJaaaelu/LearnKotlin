package com.kotlin.`in`.action.lambda

//  带接收者的 Lambda

//  with

//  apply

//  区别，apply 会返回作为实参传递给它的对象（接收者对象）

//  普通的字母表方法
fun alphabet() : String {
    val result = StringBuilder()
    for (letter in 'A'..'Z' ) {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet")
    return result.toString()
}

//  使用 with 构建的字母表方法
fun alphabetWith() : String {
    val result = StringBuilder()
    //  这里 with 接收的两个参数是 StringBuilder 和 Lambda
    //  with 会把函数的第一个参数传递进 Lambda 中
    return with(result) {
        for (letter in 'A'..'Z' ) {
            //  这里其实也是 this.append(letter)
            //  this 指向 StringBuilder，但也可以省略
            append(letter)
        }
        append("\nNow I know the alphabet")
        result.toString()
    }
}

//  使用 with 构建的字母表方法（简化版）
fun alphabetSimplifyWith() = with(StringBuilder()) {
    for (letter in 'A'..'Z' ) {
        //  这里其实也是 this.append(letter)
        //  this 指向 StringBuilder，但也可以省略
        append(letter)
    }
    append("\nNow I know the alphabet").toString()
}

//  与 with 类似
fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z' ) {
        //  这里其实也是 this.append(letter)
        //  this 指向 StringBuilder，但也可以省略
        append(letter)
    }
    append("\nNow I know the alphabet")
}.toString()

//  还可以稍微再简化一点
fun alphabetBuildStr() = buildString {
    for (letter in 'A'..'Z' ) {
        //  这里其实也是 this.append(letter)
        //  this 指向 StringBuilder，但也可以省略
        append(letter)
    }
    append("\nNow I know the alphabet")
}

fun main(args: Array<String>) {
    println(alphabet())
    println(alphabetWith())
    println(alphabetSimplifyWith())
    println(alphabetApply())
    println(alphabetBuildStr())
}

fun append() {
    println("外部的方法")
}