package com.kotlin.`in`.action.lambda.collectionLambda

import com.kotlin.`in`.action.lambda.Person

//  集合操作函数式 API 之 filter 和 map

//  尽量不要重复计算

//  filter 会从集合中一处你不想要的元素

//  map 函数对集合的每一个元素应用给定的函数，并把结果收集到一个新集合

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    //  filter 遍历集合并选出给定 Lambda 返回 true 的那些元素
    println(list.filter { it % 2 == 0 })

    val people = listOf(Person("A", 11),
            Person("B", 22),
            Person("C", 33))
    //  留下大于三十岁的
    println(people.filter { it.age > 30 })
    println(people)

    //  数列的每个元素平方
    println(list.map { it * it })
    //  只需要打印一个用户姓名的列表
    //  Person 转为了 String
    println(people.map { it.name })
    //  当然也可以这么写
    println(people.map(Person::name))

    //  打印年龄大于 18 岁的人的名字
    println(people.filter { it.age > 18 }.map(Person::name))

    //  找到列表中年龄最大的人，并打印出他的信息
    println(people.filter { it.age == people.maxBy { it.age }!!.age })
    //  写法与上面一致
    println(people.filter { it.age == people.maxBy(Person::age)!!.age })
    //  上面两句中，如果列表中有 100 人，那么就找最大年龄的方法就会执行 100 次
    //  所以优化一下，只寻找一次就够了
    val maxAge = people.maxBy(Person::age)!!.age
    println(people.filter { it.age ==  maxAge})

    val numbers = mapOf(0 to "zero",
            1 to "one",
            2 to "two")
    //  只处理键，但是返回的是 key=value
    //  如果调用的是 map { it.value.toUpperCase() }，则只会返回 [ZERO, ONE, TWO]
    println(numbers.mapValues { it.value.toUpperCase() })
}