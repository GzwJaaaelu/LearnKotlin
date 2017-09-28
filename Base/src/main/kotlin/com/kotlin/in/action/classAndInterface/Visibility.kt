package com.kotlin.`in`.action.classAndInterface

//  Kotlin 中的默认可见性是 public 的
//  Java 中的默认可见性是包私有

//  Kotlin 中有一个不同的修饰符 internal，表示模块内可见

//  修饰符 public 对于类成员与顶层声明都表示所有地方可见
//  修饰符 internal 对于类成员与顶层声明都表示模块中可见
//  修饰符 protected 对于类成员表示子类可见（与 Java 中不同，Java 还允许同包内的文件访问 protected）
//  修饰符 private 对于类成员表示类中可见，对于顶层声明表示文件中可见

internal open class TalkBtn : Focusable {

    private fun yell() = println("Hey!")

    protected fun whisper() = println("Let's talk")
}

fun main(args: Array<String>) {
    val talk = TalkBtn()
}