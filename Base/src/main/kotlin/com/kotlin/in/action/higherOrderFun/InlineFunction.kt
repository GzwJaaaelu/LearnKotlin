package com.kotlin.`in`.action.higherOrderFun

import sun.misc.Lock


//  内联函数：消除 Lambda 带来的运行时开销
//  例如 Lambda 表达式会被正常的编译为匿名类，这样每次调用 Lambda 就会创建一个类，这样会带来额外的开销。

//  那么如何才能让编译器生成和 Java 语句同样高效的代码，但还能把重复的逻辑抽取到函数库中呢？
//  Kotlin 提供了 inline 修饰符标记一个函数，在函数被使用的时候编译器并不会生成函数调用的代码，而是使用函数实现的真是代码
//  替换每一次的函数调用。

//  8.2.1 内联函数如何运作

//  如果多个不同位置使用了同一个内联函数，但使用的 Lambda 不同，那么内联函数会在每一个被调用的位置被分别内联。
//  内联函数代码被拷贝到使用它的多个地方，并吧不同的 Lambda 替换打其中。

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}

class LockOwner(private val lock:Lock) {

    fun runUnderLock(body: () -> Unit) {
        //  传递一个函数类型的变量作为参数
        //  但这种时候并不会被内联
        synchronized(lock, body)
    }

    //  上面函数会被编译成这样
    fun runUnderLockCompile(body: () -> Unit) {
        lock.lock()
        try {
            //  body 并没有被内联
            body()
        } finally {
            lock.unlock()
        }
    }
}

fun main(args: Array<String>) {
    val l = Lock()
    synchronized(l) {
        println("J")
    }

    //  上面代码会编译为
    l.lock()
    try {
        println("J")
    } finally {
        l.unlock()
    }
}