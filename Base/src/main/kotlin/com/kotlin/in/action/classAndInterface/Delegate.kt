package com.kotlin.`in`.action.classAndInterface

class MyCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()

    override val size: Int
        get() = innerList.size

    override fun contains(element: T): Boolean {
        return innerList.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return innerList.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return innerList.isEmpty()
    }

    override fun iterator(): Iterator<T> {
        return innerList.iterator()
    }
}

//  实现接口后可以通过 by 关键字将接口的实现委托到另一个对象
//  这样看上去我们需要重写的方法就都消失了，其实是会去执行被委托的对象
class DelegateCollection<T>(private val innerList:ArrayList<T>) : Collection<T> by innerList {

    //  虽然委托给了别人执行，但是仍然可以重写，最终会执行你重写的方法
    override fun contains(element: T): Boolean {
        return false
    }
}

fun main(args: Array<String>) {
    val array = arrayListOf(1, 2, 3)
    val dc = DelegateCollection(array)
    println(dc.contains(1))
}