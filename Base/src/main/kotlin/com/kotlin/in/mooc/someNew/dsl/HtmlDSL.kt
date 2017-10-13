package com.kotlin.`in`.mooc.someNew.dsl

fun main(args: Array<String>) {

    html {
        //        proerties["id"] = "htmlHello"
        //  添加 operator fun String.invoke(value: String) 后可以直接这样调用不必像上面那样
        "id"("htmlHello")
        //  添加 operator fun String.invoke(block: Tag.() -> Unit) 后可以直接这样调用不必像上面那样
        //        children.add(Tag("head"))
        "head" {  }
        "body" {
            "a" {
                "href"("www.google.com")
                + "Google 官网"
            }
        }
    }.render().let(::println)
}