package com.kotlin.`in`.action.lambda.collectionLambda

//  处理嵌套集合中的元素

//  flatMap 可将多列表平铺

//  flatten

class Book(val titil:String, val authors:List<String>)

fun main(args: Array<String>) {
    val books = listOf(Book("人类简史", listOf("尤瓦尔·赫拉利")),
            Book("随便的书", listOf("A", "B")))
    //  找出书籍列表中的所有作者
    //  加上 toSet 可以用于去重
    println(books.flatMap { it.authors }.toSet())

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })
}