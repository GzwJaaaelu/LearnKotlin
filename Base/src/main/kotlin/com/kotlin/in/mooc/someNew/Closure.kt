package com.kotlin.`in`.mooc.someNew

//  闭包就是函数的运行环境，持有函数运行的状态，函数内部可以定义函数，也可以定义类
//  所以函数内部的运行状态不会被释放

fun makeFun(): () -> Unit {
    var count = 0

    //  这里面还能有类
    //  只是外面访问不到
    data class Person(val name: String)

    //  这里是匿名函数
    return fun() {
        //  这里还能 ++，所以 count 始终没有被释放，不然否则都是 0
        println(++count)
    }
}

//  斐波那契
fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return fun(): Long {
        val result = second
        second += first
        first = second - first
        return result
    }
}

fun fibonacciWithIterator(): Iterable<Long> {
    //  这里并没有被回收
    //  这个作用域其实就是闭包
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator() {
            override fun hasNext() = true

            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }

        }
    }
}

fun add(x: Int) = fun(y: Int) = x + y

//  上面的写法其实就相当于是这个
fun add2(x: Int): (Int) -> Int {
    return fun(y: Int): Int {
        return x + y
    }
}

fun main(args: Array<String>) {
    //  函数中返回了一个函数
    val x = makeFun()
    x()
    x()
    x()

    val f = fibonacci()
//    println(f())
//    println(f())
//    println(f())
//    println(f())
//    println(f())

    val fi = fibonacciWithIterator()
    //  然后遍历，到 100 就停了
    fi.takeWhile { it <= 100 }.forEach { println(it) }


    println(add(3)(4))
    println(add2(3)(4))
}