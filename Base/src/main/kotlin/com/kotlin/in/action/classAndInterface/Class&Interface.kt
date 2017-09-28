package com.kotlin.`in`.action.classAndInterface

interface Clickable {

    fun click()

    //  带默认实现的方法
    //  Java 8 之后也支持接口方法的默认实现，不过需要声明 default 关键字

    //  由于 Kotlin 是以 Java 6 为目标设计的，所以默认方法在转成 Java 代码后其实是接口中有一个默认实现了接口的静态类
    fun showOff() = println("Clickable 默认实现")
}

interface Focusable {

    fun setFocus(b: Boolean) {
        println("I ${if (b) "got" else "lost"} focus.")
    }

    fun showOff() = println("Focusable 默认实现")
}

//  无论是继承还是现实都是通过 : 实现
class Btn : Clickable, Focusable {

    override fun showOff() {
        //  两个接口都有同一个接口时，还想要继续调用 super，就必须要指明是调用哪个的方法
        //  尖括号就表示你想要调用哪个父类的方法
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    //  这里用 override 表示重写，且不可省略
    override fun click() = showOff()

}

//  Kotlin 中的类默认都是 final，需要手动声明成 open 的才可以被继承

open class RichBtn : Clickable {

    //  final override 禁止再继续呗重写了
    final override fun click() {

    }

    //  final 的方法不可被重写
    fun disable() {

    }

    open fun animate() {

    }

}

abstract class Animated {
    //  抽象的方法必须被实现
    abstract fun animate()

    //  可以被重写的方法
    open fun stopAinmating() {

    }

    //  不可被重写的方法
    fun animateTwice() {

    }
}

fun main(args: Array<String>) {

    val btn = Btn()
    btn.click()
}