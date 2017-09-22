package com.learn.kotlin

//  高阶函数 是把函数作为参数或者返回返回值的一类函数
//  如 f(g(x))

fun main(args: Array<String>) {
    //  三种函数引用的方式
    //  第一种包级函数

    //  这种写法也叫函数引用
    //  因为是包级函数 所以不需要类名::方法名
    args.forEach(::println)

    //  通过类名::方法名来拿到方法的引用
    val hw = Hello::world

    //  第二种直接用类名应用的方式

    //  注意这里有一个隐含的参数就是调用者本省
    //  过滤空字符串，所以留下非空的
    args.filter(String::isNotEmpty)

    //  第三种就是调用者引用的方式（1.1 开始）

    //  这里需要传递进去一个实例
    //  这里不是太懂
    val pdf = PDFPrintln()
    args.forEach(pdf::println)
}

class PDFPrintln() {
    fun println(any: Any) {
        //  这就引用到我们经常使用到的 println
        kotlin.io.println(any)
    }
}

class Hello {
    fun world() {
        println("HelloWorld")
    }
}