package com.kotlin.`in`.action.kotlin

//  Kotlin 中并不区分基本数据类型的和它们包装类

//  Any 类型是 Kotlin 中所有非空类型的超类，而 Java 中，Object 只是引用类型的超类

//  42 会被自动装箱
val answer: Any = 42

//  Any? 是可以持有空引用

//  Unit类型：Kotlin 中的 void

//  Unit 与 void 的区别：Unit 可以作为类型参数，而 void 却不行。

interface Processor<T> {

    fun process(): T
}

class NoResultProcessor: Processor<Unit> {

    //  返回 Unit，但可以省略
    override fun process() {
    }
}

class IngResultProcessor: Processor<Int> {

    override fun process(): Int {
        return 0
    }
}

//  Nothing 类型：“这个函数永远不返回”