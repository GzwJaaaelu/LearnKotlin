package com.kotlin.`in`.mooc.withJava

fun main(args: Array<String>) {
    val source = "Hello,This my phone number:010-12345678"
    //  RawString
    val pattern = """.*(\d{3}-\d{8}).*"""

    Regex(pattern)
            .findAll(source)
            .toList()
            .flatMap(MatchResult::groupValues)
            .forEach(::println)
}