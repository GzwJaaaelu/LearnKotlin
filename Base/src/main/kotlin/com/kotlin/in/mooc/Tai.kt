package com.kotlin.`in`.mooc

fun <T> Collection<T>.collectionJoinToString(separator: CharSequence = ", ",
                                             prefix: CharSequence = "",
                                             postfix: CharSequence = ""): String {
    val result = StringBuilder(prefix)

    for ((index, value) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(value)
    }

    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    val MAX_NODE_COUNT = 100000
    val head = ListNode(0)
    var p = head
    for (i in 1..MAX_NODE_COUNT) {
        p.next = ListNode(i)
        p = p.next!!
    }

    //  没有尾递归优化的 10W 都坚持不住
//    println(findListNode(head, 99999)?.value)
    println(findListNodeWithOptimize(head, 99999)?.value)
}