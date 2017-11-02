package com.kotlin.`in`.action.higherOrderFun

//  声明高阶函数
//  高阶函数就是以另一个函数作为参数或者返回值的函数
//  在 Kotlin 中函数可以用 Lambda 或者函数引用来表示
//  因此，任何以 Lambda 或者函数引用作为参数货返回值的函数（或者两者都是）都是高阶函数
//  如标准库的 filter 就是高阶函数，list.filter { x > 0 }，filter 接收了一个 Lambda 作为函数参数

//  方法中声明你需要什么类型的参数，方法中调用这个参数，而参数的具体实现就是外部传递进来的
//  比如 (Int, Int) -> Int，具体的实现是外部传递进来的，可能还是返回两个数之和也可能其实，只要满足即可，而实际的调用时在方法中

//  8.1.1 函数类型

val sum = { x: Int, y: Int -> x + y }
//  这里已经显示声明了类型，所以 Lambda 中也就可以省略 x,y 的参数类型
val sumOther: (Int, Int) -> Int = { x, y -> x + y }
val action = { println(42) }

//  上面这两个函数会被推导为
//  val sum: (Int, Int) -> Int = { x, y -> x + y }  有两个 Int 参数和 Int 返回值的函数
//  val action: () -> Unit = { println(42) }    没有参数和返回值的函数，这种情况下 Unit 不能省略
//  (Int, Int) -> Int，(Int, Int) 为参数类型， Int 为返回类型

//  可以返回可空类型
var canReturnNull: (Int, Int) -> Int? = { _, _ -> null }
//  定义一个函数类型的可以空变量
var funOrNull: ((Int, Int) -> Int)? = null
//  上面这个和下面这个也还是有区别的，上面的是声明一个返回值可空类型的函数，而不是一个可空的函数类型的变量

//  函数类型的参数名
fun performRequest(url: String,
        //   函数类型的采纳数现在有了名字，这里指的是 code: Int, content: String
                   callback: (code: Int, content: String) -> Unit) {
    //  随便写的
    callback(0, url)
}

//  8.1.2 调用作为参数的函数

//  定义一个函数类型的参数
fun twoAndThree(operation: (Int, Int) -> Int) {
    //  调用函数类型的参数
    val result = operation(3, 3)
    println("The result is $result")
}

//  实现一个简单版本的 filter
fun String.filter(predicte: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicte(element)) sb.append(element)
    }
    return sb.toString()
}

//  8.1.3 在 Java 中使用函数类

fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}

//  8.1.4 函数类型的参数默认值和 null 值

//  给函数类型指定默认值
fun <T> Collection<T>.collectionJoinToString(separator: CharSequence = ", ",
                                             prefix: CharSequence = "",
                                             postfix: CharSequence = "",
                                             transform: (T) -> String = { it.toString() }): String {
    val result = StringBuilder(prefix)

    for ((index, value) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(value))
    }

    result.append(postfix)
    return result.toString()
}

//  另一种是声明一个可空的函数类型
fun foo(callback: (() -> Unit)?) {
    //  由于这个函数类型可能为空所以就需要做空判断
    //  一下三种均可
    if (callback != null) {
        callback()
    }
    callback?.invoke()
    callback?.let { it() }
}

fun <T> Collection<T>.collectionJoinToStringCanNull(separator: CharSequence = ", ",
                                             prefix: CharSequence = "",
                                             postfix: CharSequence = "",
                                             //  这里传递进来一个可空的函数类型
                                             transform: ((T) -> String)? = null): String {
    val result = StringBuilder(prefix)

    for ((index, value) in this.withIndex()) {
        if (index > 0) result.append(separator)
        //  通过 transform?.invoke(value) ?: value.toString() 来保证空安全
        result.append(transform?.invoke(value) ?: value.toString())
    }

    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    val url = "https://kotl.in"
    //  可以保持一致的名字
    performRequest(url) { code, content -> println("$code -> $content") }
    //  也可以改为自己的命名
    performRequest(url) { code, text -> println("$code -> $text") }

    //  传入函数类型的参数
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a - b }

    //  查看所有大写字母
    println("GzwLoveJaaaelu".filter { it.isUpperCase() })
    //  找到所有小写字母
    println("adc1sl234kdnsd342AAAf".filter { it in 'a'..'z' })

    val list = listOf("Alpha", "Beta")
    //  使用函数类默认值
    println(list.collectionJoinToString())
    //  指定函数式值
    println(list.collectionJoinToString(separator = " & ") { it.toUpperCase() } )

    foo {  }
    foo { println("A") }

    println(list.collectionJoinToStringCanNull())
}
