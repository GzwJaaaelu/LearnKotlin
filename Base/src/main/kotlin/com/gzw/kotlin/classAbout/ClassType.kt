package com.gzw.kotlin.classAbout

/**
 * Created by jilinlin on 2017/8/5.
 */
//  如果没有内部结构，可以省去大括号
class Girl constructor(age: Int, name: String) : Human(age, name)

//  : 表示继承，继承自 Human
class Boy(age: Int, name: String) : Human(age, name) {
    fun haveGirlFriend(): Boolean {
        return true;
    }
}

//  默认为 final,无法继承
//  所有 Kotlin 的类都之间或者间接的继承自 Any

open class Human(var age: Int, var name: String) {
    //  构造方法的方法体
    init {
        println("${this.javaClass.simpleName} 的年龄是 $age 名字是 $name")
    }
}

fun main(args: Array<String>) {
    val girl: Girl = Girl(24, "JLL")
    val boy: Boy = Boy(23, "Gzw")

    val Gzw: Human = Boy(23, "Gzw")
    if (Gzw is Boy) {
        //  如果是就不用强制转换，可以直接调用方法
        println(Gzw.haveGirlFriend())
    }


    val baby: Human = Human(1, "baby")
    //  as 相当于强制类型转换
    //  as? 相当于安全的强制类型转换，如果不能转换则不转换，但是接收类型也必须为 ?
    val realBaby: Boy? = baby as? Boy
    println(realBaby)
}

