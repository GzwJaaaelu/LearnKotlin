@file:JvmName("StringFunctions")
package com.kotlin.`in`.action.funcy

fun main(args: Array<String>) {

    //  setOf 返回的是 LinkedHashSet
    val set = setOf(1, 2, 5)
    val hashSet = hashSetOf(1, 2, 5)
    val list = listOf("A", "B", "C")
    val hashMap = hashMapOf(1 to "A", 2 to "B", 3 to "C")

    println(set.javaClass)
    println(list.javaClass)

    println(set.last())
    println(hashSet.max())

    //  方法调用的时候还可以指定参数的值，一方面准确传入
    //  另一方面可以提升方法阅读性
    println(set.joinToString(separator = "-", prefix = "[", postfix = "]"))
    //  这样调用该方法，并不是说它有一个不带参数的 joinToString 方法
    //  而是说这个方法每个参数已经设置过了自己的默认值
    //  如果方法的参数设置了默认值那么就可以不必传递
    //  这样的好处省去了我们进行大量方法的重载
    //  但是多个参数的情况下，如果我们传递参数进去，会按照顺序赋值
    //  如果想跳着赋值，就可以像上边那种方法那样（这种做法也叫做命名参数），指定参数的值
    println(set.joinToString())
}

//  自定义的一个带默认参数的函数
//  如果带 JvmOverloads 这个注解那么在 Java 中调用也会生成该函数的各个重载版本
//  如果不带就只有全参数的一个函数

//  当然这种写在类的外面的函数也叫做顶层函数，它并不属于某个类，导入的时候只要明确是哪里个包下的即可
//  import com.kotlin.`in`.action.funcy.joinToString
//  如果我在 package 上面加上一句 @file:JvmName("xxx")，还可以进行指定类名
//  这是 Java 中调用该方法就会这样导入 import static com.kotlin.in.action.funcy.StringFunctions.joinToString;
//  且对应的 Java 的代码修饰是 static 和 final 的
@JvmOverloads
fun joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = ""): String {
    return StringBuilder().append(prefix).append(separator).append(postfix).toString()
}

//  函数可以这么写，属性也可以这么写
//  正常情况下我们会将这些放在文件的顶部位置，所以才叫顶层函数或顶层属性
val MAX = 10