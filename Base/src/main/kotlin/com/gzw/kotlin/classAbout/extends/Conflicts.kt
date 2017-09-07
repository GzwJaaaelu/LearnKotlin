package com.gzw.kotlin.classAbout.extends

abstract class A {
    open fun x(): Int = 5
}

interface B {
    fun x(): Int = 1
}

interface C {
    fun x(): Int = 0
}

class D(val y: Int = 0) : A(), B, C {

    //  不过这只是返回值相同才能这么做
    override fun x(): Int {
        println("调用 D 的 x 方法")

        //  这样就解决了实现的两个接口但方法相同的调用
        return when {
            y > 0 -> y
            y < -200 -> super<C>.x()
            y < -100 -> super<B>.x()
            else -> super<A>.x()
        }
    }
}

fun main(args: Array<String>) {
    println(D(3).x())
    println(D(-101).x())
    println(D(-2000).x())
    println(D(-99).x())
}