package com.kotlin.`in`.action.funcy

//  给别人的类添加方法：扩展函数与属性
//  在拓展函数中可以直接访问被扩展的类的其他方法和属性
//  但扩展函数并不允许打破它的封装性，所以扩展函数不能访问私有或是受保护的成员
//  对应 Java 代码中 扩展函数是 static final 的，所以扩展函数是不能被子类重写的
//  扩展函数并不是类的一部分，因为扩展函数是声明在类外部的
//  如果扩展函数与成员函数签名相同，往往成员函数会被优先使用

//  这个方法就是为 String 扩展了一个 lastChar 方法
//  这个例子中 String 是接收者类型，而 this 是接收者对象（也就表示了调用该方法的对象）
//  对应 Java 调用来说，其实扩展函数就是静态方法
//  书中解释说扩展函数无非就是静态函数的一个高效的语法糖
fun String.lastChar(): Char = this[this.length - 1]

//  扩展属性
//  并不能进行初始化，因为没有合适的地方来存放值
val String.lastChar: Char
    //  val 必须要定义 getter
    get() = get(length - 1)

var StringBuilder.lastChar
    //  var 必须要有 getter 和 setter
    get() = get(length - 1)
    set(value) = this.setCharAt(length - 1, value)

fun <T> Collection<T>.collectionJoinToString(separator: CharSequence = ", ",
                                             prefix: CharSequence = "", postfix: CharSequence = ""): String {
    val result = StringBuilder(prefix)

    for ((index, value) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(value)
    }

    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    println("Gzw".lastChar())
    println("Gzw".lastChar)

    val sb = StringBuilder("Gzw")
    println(sb.lastChar)
    sb.lastChar = 'A'
    println(sb)

    println(listOf("A", "B", "C").collectionJoinToString())
}