package com.kotlin.`in`.action.lambda.collectionLambda

import com.kotlin.`in`.action.lambda.Person

//  检查集合中所有元素是否都符合某个条件，可以通过 all 或 any 来实现

//  all 判断所有元素是否都满足该条件

//  any 判断元素列表中是否存在至少一个匹配元素

//  count 对满足该表达式的元素计数

//  find 找到一个满足 Lambda 的第一个元素

val canBeInClub27 = { p: Person -> p.age < 27 }

fun main(args: Array<String>) {
    val people = listOf(Person("A", 11),
            Person("B", 22),
            Person("C", 33))
    //  所有元素都执行该 Lambda
    //  判断是不是所有元素的年龄都小于 27，返回 false
    println(people.all(canBeInClub27))

    //  检测是否存在至少一个匹配元素
    println(people.any(canBeInClub27))

    println()

    val list = listOf(1, 2, 3)
    //  以下两种情况一致
    //  !all 最好用 any 取反替代，取反取的是 all 中 Lambda 的反
    //  保证不是所有元素都等于 3
    println(!list.all { it == 3 })
    //  至少有一个元素不是 3
    println(list.any { it != 3 })

    println()

    //  对满足该表达式的元素计数
    println(people.count(canBeInClub27))
    //  相比较这种写法，count 无需再创建一个中间集合，所以比这种写法更高效
    println(people.filter(canBeInClub27).size)

    println()

    //  找到一个满足 Lambda 的元素
    //  如果找到多个会返回第一个元素
    //  没有找到满足的元素会返回 null
    //  find 还有一个同一方法 firstOrNull
    println(people.find(canBeInClub27))
}