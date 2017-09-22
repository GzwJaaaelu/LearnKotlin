package com.kotlin.`in`.action.base

//  导入函数
import com.kotlin.`in`.action.base.testPackage.createRandomRect

//  Kotlin 中，类的默认修饰符是 public 的
//  name 是只读属性的，只有一个简单的 getter
//  age 是可写属性，有 getter And setter，且有一个默认值
class Person(val name: String, var age: Int = 0)

class Rectangle(private val height: Int, private val width: Int) {
    val isSquare: Boolean
        get() {
            //  自定义 getter
            return height == width
        }
}

fun main(args: Array<String>) {
    //  创建对象的时候就不用写 new xxx 了
    val p = Person("Gzw")

    for (i in 1..5) {
        println("rect isSquare ${createRandomRect().isSquare}")
    }
}