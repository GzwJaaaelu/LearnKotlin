package com.gzw.kotlin.classAbout.abstract

//  抽象类与接口的共性
//  1.都比较抽象，不嗯呢直接实例化
//  2.需要子类或实现类进行实现
//  3.父类变量可以接受之类的实例赋值（向上转型）

//  抽象类与接口的区别
//  1.抽象类有状态，接口没有状态
//  2.抽象类有方法实现，接口只能有无状态的默认实现
//  3.抽象类只能单继承，接口可以多实现
//  4.抽象类反应本质，接口体现能力

abstract class A {
    //  变量可以被初始化
    var i = 0

    //  加了 open 可以被重写
    open fun hello() {
        //  有方法体的方法
    }

    abstract fun otherHello()
}

interface B {
    //  相当于有抽象的 getI 和 setI 方法
    var i: Int

    fun hello()

    /**
     * 默认实现的方法
     */
    fun otherHello() {
        println("Test")
    }
}

//  AA 继承自 A，所以 A 需要构造

class AA : A() {

    override fun otherHello() {

    }

    override fun hello() {
        println(i)
    }
}

class BB : B {

    override fun hello() {
        println(i)
    }

    override var i: Int = 0
        get() = field
        set(value) {
            field = value
        }
}

//  由于可以单继承和多实现（对于类来说）
//  <联想><笔记本>电脑
//  这时候倾向于 联想、笔记本定义为接口，而电脑是父类


fun main(args: Array<String>) {
    //  表示 BB 也就是 B （可以充当 B 使用）
    //  也叫向上转型
    val b:B = BB()

}