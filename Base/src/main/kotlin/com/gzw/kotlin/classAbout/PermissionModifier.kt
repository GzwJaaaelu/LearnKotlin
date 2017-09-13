package com.gzw.kotlin.classAbout

class House

class Garden

class MyHouse {
    //  我觉得自己家的东西不能被外面访问
    //  所以 private 修饰是无法被外面访问到的，只能在这个类里面

    private val house = House()

    private val garden = Garden()
}

class TheForbiddenCity {
    //  紫禁城可是对外开放的
    //  而默认不带修饰符的表示 public

    val houses = arrayOf(House(), House(), House())

    val gardens = arrayOf(Garden(), Garden(), Garden())
}

fun main(args: Array<String>) {
    val gzwHome = MyHouse()

    val fc = TheForbiddenCity()
    println(fc.houses)
}