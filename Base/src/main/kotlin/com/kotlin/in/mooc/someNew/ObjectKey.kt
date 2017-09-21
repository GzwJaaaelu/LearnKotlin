package com.kotlin.`in`.mooc.someNew

//  object 其实是一种特殊的 class
//  所以它也可以实现接口或者集成类
//  object 修饰后其实相当于 Java 中最简单的单例
//  只有一个实例的类
//  不能自定义构造方法

object MusicPlay {
    var state = 0

    fun play(url: String) {

    }

    fun stop() {

    }
}

fun main(args: Array<String>) {

}