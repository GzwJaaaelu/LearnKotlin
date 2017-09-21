package com.learn.kotlin

//  枚举也是一个类 字节码显示它是 final 类且构造是 protected 的
//  其实实现这个也可以使用整形常量之类的，相比之下这个开销较大一些
//  用于存放有限个数的元素

enum class LogLevel {
    VERBOSE,
    DEBUG,
    INFO,
    WARN,
    ERROR,
    ASSERT
}

//  有构造的枚举
enum class LogLevelWithConstructor constructor(val id: String) {
    VERBOSE("verbose"),
    DEBUG("debug"),
    INFO("info"),
    WARN("warn"),
    ERROR("error"),
    ASSERT("assert")
}

//  带方法的枚举，当然这些特新都是可以同时存在的
enum class LogLevelWithFun {
    VERBOSE,
    DEBUG,
    INFO,
    WARN,
    ERROR,
    ASSERT;

    //  可以带方法，但是注意在最后一个枚举成员的地方需要添加分号
    fun currLevel(): String {
        return this.name
    }

    override fun toString(): String {
        return "$name -> $ordinal"
    }
}

//  这两种写法其实是类似的
class LogLevel2 protected constructor() {

    companion object {
        val VERBOSE = LogLevel2()
        val DEBUG = LogLevel2()
        val INFO = LogLevel2()
        val WARN = LogLevel2()
        val ERROR = LogLevel2()
        val ASSERT = LogLevel2()
    }
}

fun main(args: Array<String>) {
    LogLevel.INFO
    LogLevel2.VERBOSE
    LogLevelWithConstructor.ASSERT

    println(LogLevelWithFun.WARN.currLevel())

    //  打印所有元素
    LogLevel.values().map(::println)
    //  打印所有并带有顺序
    LogLevelWithFun.values().map(::println)
    //  知道元素名字可以拿到对应实例
    println(LogLevel.valueOf("ERROR"))
}