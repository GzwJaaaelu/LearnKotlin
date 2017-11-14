package com.kotlin.`in`.action.higherOrderFun

import sun.misc.Lock
import java.io.BufferedReader
import java.io.FileReader


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

class LockOwner(private val lock: Lock) {

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

//  8.2.2 内联函数的限制

//  由于不是所有的 Lambda 函数都可以被内联，当函数内敛的时候，作为参数的 Lambda 表达式的函数会直接替换掉最终生成代码中。
//  这也限制了函数体中对应的（Lambda）参数的使用，如果（Lambda）参数被调用，这样的代码能被容易地内联。
//  但如果（Lambda）在某个地方被保存起来了，以便后面继续使用，Lambda 表达式的代码将不能被内联。

//  例如系统提供的这个函数，它没有直接调用作为 transform 参数传递进来的函数，而是将这个函数传递给了一个类的构造，构造方
//  法将它保存在一个属性中，所以 transform 需要被编译为标准的非内联的表示法，即一个实现了函数接口的匿名类。
fun <T, R> Sequence<T>.map(transform: (T) -> R): Sequence<R> {
    return TransformingSequence(this, transform)
}

//  如果一个函数期望两个或者更多 Lambda 参数，可以选择只内联一些参数。
inline fun foo(inlined: () -> Unit, noinline noinlined: () -> Unit) {

}

//  8.2.3 内联集合操作

//  如：在 Kotlin 中 filter 被声明成了内联函数，这意味着 filter 函数，以及传递给它的 Lambda 的字节码会被直接一起内联到
//  filter 被调用的地方。

//  如果有大量元素需要处理，那么需要考虑中间集合带来的运行开销，这时可以使用序列来替代集合，但用处理序列的 Lambda 没有
//  被内联。

//  尽量只有处理大数据两的时候才考虑 asSequence。

//  编译器支持内联跨模块的函数或者第三方的函数。
//  可以在 Java 中调用绝大多数内联函数的时候，但这些调用并不会被内联，而是被便衣成普通的函数调用。

//  8.2.4 决定何时将函数声明成内联

//  使用 inline 关键字只能提高带有 Lambda 参数的函数的性能。

//  对于普通的函数调用，JVM 已经提供了强大的内联支持。

//  在使用 inline 关键字时，应该注意代码的长度，把一些和 Lambda 无关的方法抽取到一个独立非内联函数中，从而减少字节码拷贝
//  长度。

//  8.2.5 使用内联 Lambda 管理资源

//  Lambda 可以去除重复代码的一个常见模式是资源管理：先获取一个资源，完成一个操作，然后释放资源。

//  需要加锁的代码被抽取到一个独立的方法中
fun <T> Lock.withLock(action: () -> T): T {
    lock()
    try {
        return action()
    } finally {
        unlock()
    }
}

//  也可以使用 use 函数作资源管理
fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use { br ->
        return br.readLine()
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

    l.withLock {
        //  在加锁的情况下执行指定的操作
        println("啦啦啦啦啦啦")
    }
}