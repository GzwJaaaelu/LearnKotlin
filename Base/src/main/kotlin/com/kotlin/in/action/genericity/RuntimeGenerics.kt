package com.kotlin.`in`.action.genericity

//  9.2 运行时的泛型：擦除和实化类型参数

//  JVM 上的泛型一般是通过类型擦除实现的，就是说泛型类实例的类型实参在运行时是不保留的。
//  这里讨论类型擦除对 Kotlin 的实际影响，以及如何解决。
//  可以声明一个 inline 函数，使其类型实参不被擦除，Kotlin 中也将其称为实化。

//  9.2.1 运行时的泛型：类型检查与转换

//  和 Java 一样，Kotlin 的泛型在运行时也被擦除了。
//  例如：你创建了一个 List<String> 并将一堆字符串放到其中，在运行时你只能看到它是一个 List，不能识别出列表本打算包含那
//  种类型的元素。

val list1: List<Int> = listOf(1, 2, 3)
var list2 = null

//  擦除类型信息是有好处的：应用程序使用的内存总量较小，因为要保存在内存中的信息更少。

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
    println(intList.sumBy { it })
}

//  对已知类型实参做类型转换
fun printSum2(c: Collection<Int>) {
    //  c 是否拥有类型 List<Int> 的检查是可行的，因为在编译期就确定了集合包含的是整形数字
    if (c is List<Int>) {
        println(c.sumBy { it })
    }
}

//  9.2.2 声明带实化类型实参的函数

//  前面知道了 Kotlin 泛型在运行时会被擦除，这意味着如果你有一个泛型类的实例，你无法弄清楚在这个实例创建时会用的究竟是
//  哪些类型参数，泛型函数的类型实参也是这样。

//  在调用函数的时候
//  这样写的话会报错
//fun <T> isA(value: Any): Boolean {
//    return value is T
//}

//  使用 inline 和 reified 关键字
//  一种情况可以避免上面的限制：内联函数，内联函数的类型形参能被实化，意味着你可以在运行时引用实际的类型实参。
//  如果用 inline 关键字标记一个函数，那么编译器会把每一次函数调用都换成函数实际的代码实现，如果该函数使用了 Lambda 实参，
//  Lambda 的代码会被内联，所以不会创建任何匿名类，这里是 inline 的另一个使用场景：它们的类型参数可以被实化。
inline fun <reified T> isA2(value: Any): Boolean {
    return value is T
}

fun main(args: Array<String>) {
    //  因为擦除也就不能知道关于元素类型的任何信息
    //  当你想知道值是否是列表的时候可以使用 List<*>，也叫星号投影语法
    //  现在可以认为它就是拥有未知类型实参的泛型类型，类似于 Java 中的 List<?>
    if (list2 is List<*>) {
        println("sss")
    }

    try {
        printSum(list1)
        //  set 并不是 List，所以会抛出 IllegalArgumentException("List is expected") 这个异常
        printSum(setOf(1, 2))
    } catch (e: Exception) {
        e.printStackTrace()
        //  由于无法判断实参是不是 List<Int>，所以前面的类型转换是成功的，然后在 sumBy 中抛出了 ClassCastException
        printSum(listOf("a"))
    }

}