package com.kotlin.`in`.action.lambda

//  如前所述，一个 Lambda 把一小段行为进行编码，你能把它当做值到处传递。
//  { x: Int, y: Int -> x + y }     其中 x: Int, y: Int 为参数， x + y 为函数体。
//  Kotlin 中的 Lambda 始终用花括号包围，只需箭头就将参数列表与函数体分开。

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y }

    println(sum(1, 2))

    //  yek也可以直接调用 Lambda 表达式
    run { println("Jaaaelu") }

    //  刚才出现过的代码
    val people = listOf(Person("A", 11),
            Person("B", 22),
            Person("C", 33))

    //  花括号内就是 Lambda 表达式，将其作为实参传递给函数

    //  这个是不用任何简明语法的版本
    println(people.maxBy({ person: Person -> person.age }))
    //  改进一，如果 Lambda 作为函数调用的最后一个实参，它可以放到括号外面
    println(people.maxBy() { person: Person -> person.age })
    //  改进二，如果 Lambda 表示式是唯一实参，那么可以省略掉小括号
    println(people.maxBy { person: Person -> person.age })
    //  改进三，省略 Lambda 的参数类型，由系统推导出参数类型
    println(people.maxBy { person -> person.age })
    //  最终版，使用默认参数名称 it 代替命名参数
    //  如果只有一个参数的 Lambda 且参数类型可以推导出来，那么就回城这个名称，也就可以这么写
    //  仅在实参名称没有显示指定时这个默认名称才会生成
    //  当嵌套 Lambda 时最好显示的声明每个 Lambda 的参数
    println(people.maxBy { it.age })


    //  将 Lambda 作为命名实参传递
    people.joinToString(separator = "", transform = { person -> person.name })
    //  多个参数且最后一个实参是 Lambda 表达式，所以也可以放在最外面
    people.joinToString("") { person -> person.name }

    //  如果用变量存储 Lambda，那么就必须显式指定参数类型，因为没有可以推断的上下文
    val getAge = { p: Person -> p.age }
    println(getAge(Person("Gzw", 23)))
}