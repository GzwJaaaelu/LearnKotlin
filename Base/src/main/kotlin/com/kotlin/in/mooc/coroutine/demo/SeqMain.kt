package com.kotlin.`in`.mooc.coroutine.demo

import kotlin.coroutines.experimental.buildSequence

val fibonacci = buildSequence {
    yield(1)
    var cur = 1
    var next = 1

    while (true) {
        yield(next)
        val temp = cur + next
        cur = next
        next = temp
    }
}

fun main(args: Array<String>) {
    for (i in fibonacci) {
        print("$i   ")
        if (i > 100) {
            break
        }
    }
}