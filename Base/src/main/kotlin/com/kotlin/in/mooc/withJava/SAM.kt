package com.kotlin.`in`.mooc.withJava

//  SAM：Single Abstract Method
//  注意转换后的实例变化，每次都是不一样的

fun main(args: Array<String>) {
    val samInJava = SAMInJava()
    //  传入一个 Lambda 相当于传入一个 Runnable 实例
    //  只有一个方法的 Java 接口，Kotlin 会帮我们处理
    samInJava.addTask { println("Task") }
    val lambda = { println("Task") }

    samInJava.addTask(lambda)
    samInJava.addTask(lambda)
    samInJava.addTask(lambda)
    samInJava.addTask(lambda)

    samInJava.removeTask(lambda)
    samInJava.removeTask(lambda)
    samInJava.removeTask(lambda)
    samInJava.removeTask(lambda)
    //  其实你会发现并没有被 remove 掉，因为每次都会 new 一个实例，所以都是不一样的
}