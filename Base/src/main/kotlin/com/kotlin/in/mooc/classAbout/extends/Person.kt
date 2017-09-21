package com.kotlin.`in`.mooc.classAbout.extends

//  默认的类和方法都是 final 的
//  想被继承、或者一个方法想被复写，一定要是 open 的
//  只有 abstract 时可以不需要 open
//  且 override 不可省，必须明确

//  一个类的父类呢，决定他是什么
//  而一个类实现的接口呢，表示他能干什么

abstract class Person(open val age: Int) {
    abstract fun work()
}

class Coder(age: Int) : Person(age) {

    override val age: Int
        get() = 0

    override fun work() {
        println("我是开发，我在专注写代码...")
    }
}

class Doctor(age: Int) : Person(age) {

    override fun work() {
        println("我是医生，我在给病人看看病...")
    }
}

fun main(args: Array<String>) {
    val person: Person = Coder(23)
    person.work()
    println(person.age)

    val otherPerson: Person = Doctor(25)
    otherPerson.work()
    println(otherPerson.age)
}