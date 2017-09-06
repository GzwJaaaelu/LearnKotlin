package com.gzw.kotlin.base

fun main(args: Array<String>) {
    //  不带下标的 for 循环
    for (a in args) {
        println(a)
    }

    //  带下标的 for 循环
    for((index, value) in args.withIndex()) {
        println("$index -> $value")
    }

    //  第二个其实也是 写法如下
    for(indexedValue in args.withIndex()) {
        println("${indexedValue.index} -> ${indexedValue.value}")
    }

    val list = MyIntList()
    list.add(1)
    list.add(2)
    list.add(3)

    for (int in list) {
        println(int)
    }

    var x = 5
    //  while 和 do ... while 都有和 Java 一样
    //  跳出循环 break（跳出）
    //  跳过某次循环 continue（跳过）
    //  与 Java 相同
    while (x > 0) {
        println(x)
        x--
    }

    //  多层循环
    Out@for(arg in args) {
        println(arg)
        Inner@for(int in list) {
            println(int)
            if (int == 2) {
                //  跳出 Out
                break@Out
            }
        }
    }
}

class MyIterator(val iterator: Iterator<Int>) {

    operator fun next(): Int {
        return iterator.next()
    }

    operator fun hasNext(): Boolean {
        return iterator.hasNext()
    }
}

class MyIntList {
    private val list = ArrayList<Int>()

    fun add(int: Int) {
        list.add(int)
    }

    fun remove(int: Int) {
        list.remove(int)
    }

    operator fun iterator(): MyIterator {
        //  然后就会调用 next 和 hasNext
        return MyIterator(list.iterator())
    }
}