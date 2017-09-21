package com.kotlin.`in`.mooc

//  尾递归：函数在调用自己之后并没有什么操作

data class ListNode(val value: Int, var next: ListNode? = null)

//  这是一个尾递归
fun findListNode(head: ListNode?, value: Int): ListNode? {
    head ?: return null
    if (head.value == value) return head
    //  这就是尾递归
    return findListNode(head.next, value)
}

//  带尾递归优化的方法，加关键字 tailrec 即可实现，编译的时候会将代码编程迭代从而实现效率
//  如果不是尾递归还要添加 tailrec 会报警告
tailrec fun findListNodeWithOptimize(head: ListNode?, value: Int): ListNode? {
    head ?: return null
    if (head.value == value) return head
    //  这就是尾递归
    return findListNodeWithOptimize(head.next, value)
}

fun factorial(n: Long): Long {
    if (n == 1L) return 1
    //  这就不算是尾递归，因为还有个 n *
    return n * factorial(n - 1)
}

data class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun findTreeNode(root: TreeNode?, value: Int): TreeNode? {
    root ?: return null
    if (root.value == value) return root
    //  左边没有查右边
    //  这里不算尾递归
    return findTreeNode(root.left, value)?: return findTreeNode(root.right, value)
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