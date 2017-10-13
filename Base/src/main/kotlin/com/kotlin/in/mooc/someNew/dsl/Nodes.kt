package com.kotlin.`in`.mooc.someNew.dsl

fun html(block: Tag.() -> Unit):Tag {
    return Tag("html").apply { block(this) }
}

class StringNode(private val content:String):Node {

    override fun render(): String {
        return content
    }
}