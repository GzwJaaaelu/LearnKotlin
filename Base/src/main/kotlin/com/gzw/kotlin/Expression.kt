package com.gzw.kotlin

class StoryBook {

    /**
     * 只有一个参数，这时用 infix 修饰后调用时可以去掉 . 或者 () 去调用这个函数
     * 也叫中缀表达式
     */
    infix fun on(place: String) {

    }
}

private const val DEBUG = 1
private const val RELEASE = 0
private const val NOTHING = -1

fun main(args: Array<String>) {

    Book() on "My Desk"

    //  if 表达式（也叫分支语句）
    //  由于 mode 是一个常量，所以需要及时赋值
    //  使用 if 表达可以解决问题
    val mode = if (args.isNotEmpty()) {
        DEBUG
    } else {
        RELEASE
    }

    println(mode)

    // switch 的替代者 when 表达式
    //  匹配后不会执行其他语句
    when (mode) {
    //  如果 mode 为 DEBUG
        DEBUG -> println("DEBUG")
    //  如果 mode 为 RELEASE
        RELEASE -> println("RELEASE")
    //  不满足上述条件 类似 switch 的 default
        else -> {
            println("NOTHING")
        }
    }

    val newMode = when {
        args.isNotEmpty() -> DEBUG
        else -> {
            RELEASE
        }
    }
}