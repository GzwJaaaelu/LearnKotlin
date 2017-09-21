package com.kotlin.`in`.mooc.funcy

fun main(args: Array<String>) {

    //  这种叫具名参数，而且参数位置互换也没问题，因为已经指定了要传递给哪个参数
    println(sumAndName(arg1 = 1, arg2 = 2))
    //  指明了最后 String 是 name 参数
    println(elongateArgsAndOther(1, 2, 3, 4, name = ""))
    //  也可以传递进去一个数组
    val array = intArrayOf(1, 2, 3, 4, 5)
    //  * 表示将 array 展开一个个传进去
    //  好像暂时只能展开数组配合变长参数使用
    elongateArgs(*array)

    argsWithDefault()
}

fun sumAndName(arg1: Int, arg2: Int) = arg1 + arg2

/**
 * 这是变长参数， vararg args: String 也和 args: Array<String>是类似的
 * Java 中只能放在参数列表的最后一个
 * 而 Kotlin 中因为存在具名参数，所以位置可以任意但是调用时需要注意
 */
fun elongateArgs(vararg args: Int) {
    for (arg in args) {
        //  doSomething
    }
}

fun elongateArgsAndOther(vararg args: Int, name: String) {
    for (arg in args) {
        //  doSomething
    }
}

/**
 * 默认参数
 * 但如果还有其他别等参数，且默认参数不在最后可能会引起歧义，所以需要其他参数配合具名参数使用
 */
fun argsWithDefault(double: Double = 3.0) {
    println(double)
}