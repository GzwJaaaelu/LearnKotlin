package com.kotlin.`in`.action.genericity

//  9.1 泛型类型参数

val readers: MutableList<String> = mutableListOf()

val readers2 = mutableListOf<String>()

//  上面两种方式是等价的，下面这个是通过类型推导出来的
//  与 Java 不同的是，类型参数必须要被显式声明出来或者可以被推导出来，而不能像 Java 中那样允许没有类型参数
val readers3 = mutableListOf("a", "s")

//  9.1.1 泛型函数与属性

//  声明一个通用类型的列表方法
//  fun 后面的 <T> 表示类型形参声明
//  List<T>.slice 和 :List<T> 表示接收者和返回值使用了类型形参
fun <T> List<T>.slice(indices: IntRange): List<T> {
    //  未实现
    TODO()
}

//  Kotlin 中的 filter 方法声明，类型参数也可以用在参数的函数类型上 (T) -> Boolean
//  public inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T>

//  还可以用同样的语法声明泛型的扩展属性
//  但不能声明泛型非扩展属性，也就是普通属性不能拥有类型参数
//  如 val <T> x: T = TODO()，这样编译器会报错
val <T> List<T>.penultimate: T
    get() = this[size - 2]

//  9.1.2 声明泛型类

interface MyList<T> {
    operator fun get(index: Int): T
}

//  9.1.3 类型参数约束

//  类型参数约束可以限制作为泛型类和泛型函数函数的类型市场的类型
//  想要一个数组类型的列表，可以是 List<Int>，List<Double> 但不能是 List<String>

//  如果你把一个类型指定为泛型类型形参的上界约束，在泛型类型具体的初始化中，其对应的类型市场就必须是这个具体类型或者它的
//  子类型

//  <T : Number> T 表示类型参数，Number 表示上界，这样也就是 Java 中的 <T extends Number> T sum(List<T> list)
//  返回值也可以是上界的具体类型或者其子类型
fun <T : Number> List<T>.sum(): Double = TODO()

//  声明带类型参数约束的函数
//  T 的上界是 Comparable<T>，如 String 继承了 Comparable<String>，这样 String 就可以使用 max 方法
fun <T : Comparable<T>> max(first: T, second: T): T {
    //  first > second 这样调用其实是 first.comparable(second) > 0
    return if (first > second) first else second
}

//  为一个类型参数指定多个约束
//  这是作为类型实参的类型必须实现 CharSequence 和 Appendable 这两个几口
fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

//  9.1.4 让类型形参非空

class Processor<T> {

    fun process(value: T) {
        //  value 是可空的，所以需要安全调用
        //  因为 Processor 初始化的时候可能使用可空类型
        value?.hashCode()
    }
}

//  指定了非空的上界
//  当然这里可以指定任意的非空类型作为上界，来让类型参数非空，不光是类型 Any
class ProcessorNotNull<T : Any> {

    fun process(value: T) {
        //  这时 T 就是非空类型的了
        value.hashCode()
    }
}

fun main(args: Array<String>) {
    val letters = ('a'..'z').toList()
    println(letters.filter { it == 'a' })
    println(letters.penultimate)

    val hello = StringBuilder("Hello")
    ensureTrailingPeriod(hello)
    println(hello)
}
