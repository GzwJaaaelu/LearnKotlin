package com.kotlin.`in`.action.base

import com.kotlin.`in`.action.funcy.MAX
import com.kotlin.`in`.action.funcy.joinToString
import com.kotlin.`in`.action.funcy.lastChar


//  在 Kotlin 中，if 是表达式，而不是语句。表达式与语句的区别在于，表达式有值，且能作为另一个表达式的一部分使用

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

//  表达式函数体
//  可以让前面的函数变得更简单，这里函数体由单个表达式构成
fun max2(a: Int, b: Int): Int = if (a > b) a else b

//  可以可以省去返回类型声明，而是采用类型推导
//  单只有表达式体函数乐意省略返回值，有返回值的代码块函数不可省略
fun max3(a: Int, b: Int) = if (a > b) a else b

//  7.5 * （10 的 6次方）
//  val 不可变引用（初始化后不可变）
//  且注意是引用不可变，而不是值不可变，如一个对象的引用不能变，但是成员属性可以改变
//  尽可能使用 val 而不是 var
val a = 7.5e6
//  val 可以变引用
val b = "b"

fun main(args: Array<String>) {
    println(max(1, 2))
    println(max2(3, 2))
    println(max3(3, 3))

    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    //  这种写法叫字符串模板
    //  $ 后面跟着变量就可以直接打印出来变量的值
    //  如果想要打印 $ 直接写出来就行了
    //  但如果 $ 后面还有其他字符，那么 $ 就需要使用转义字符 \$
    println("Hello $name !")
    //  $ 后面不跟别的字符时 $ = \$
    println("啊啊啊啊$")
    println("啊啊啊啊\$")
    println("\$name")
    //  ${ 里面可以放各种表达式 }
    println("Hello ${if (args.isNotEmpty()) args[0] else "Kotlin"} !")

    println("${joinToString()} + $MAX")

    //  这里使用别的包下的定义的扩展函数需要导入
    println("Gzw".lastChar())
}