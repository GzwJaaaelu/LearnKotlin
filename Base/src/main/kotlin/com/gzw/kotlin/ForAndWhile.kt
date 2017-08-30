package com.gzw.kotlin

fun main(args: Array<String>) {
    //  不带下标的 for 循环
    for (a in args) {
        println(a)
    }

    //  带下标的 for 循环
    for((index, value) in args.withIndex()) {
        println("$index -> $value")
    }

    //  写法如下
    for(indexedValue in args.withIndex()) {
        println("${indexedValue.index} -> ${indexedValue.value}")
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