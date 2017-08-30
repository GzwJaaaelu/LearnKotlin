package com.gzw.kotlin

class Complex(var real: Double, var imaginary: Double) {

    /**
     * 正常重载
     */
    operator fun plus (other: Complex): Complex {
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    /**
     * 传入任意类型
     */
    operator fun plus (other: Int): Complex {
        return Complex(real + other, imaginary)
    }

    /**
     * 返回任意类型
     */
    operator fun plus (other: Any): String {
        return "$real + $other"
    }

    /**
     * 重写 () 方法
     */
    operator fun invoke(): Double{
        //  取模运行
        return Math.hypot(real, imaginary)
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

class Book {
    /**
     * infix 中缀表达式，类似运算符
     */
    infix fun on(any: Any): Boolean{
        return false
    }
}

class Desk

fun main(args: Array<String>) {
    //  3 + 4.5i
    val c1 = Complex(3.0, 4.5)
    //  8 + 1.5i
    val c2 = Complex(8.0, 1.5)

    println(c1 + c2)
    println(c1 + 1)
    println(c1 + "Hello J")
    println(c1())

    println(Book() on Desk())
}