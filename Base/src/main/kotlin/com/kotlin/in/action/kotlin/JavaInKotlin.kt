package com.kotlin.`in`.action.kotlin

//  Java 中 @Nullable + Type = Type? / @NotNull + Type = Type
//  Java 中的 Type = Kotlin 中的 Type? or Type
//  如 Java 中的 ArrayList<String> 在 Kotlin 中被当做了 ArrayList<String?>?

class StringPrinter : StringProcessor {

    //  可以为非空的参数实现
    override fun process(value: String) {
        println(value)
    }
}

class NullableStringPrinter : StringProcessor {

    //  可以为非空的参数实现
    override fun process(value: String?) {
        println(value ?: "null")
    }
}

fun main(args: Array<String>) {
    val sp: StringProcessor = StringPrinter()
    //  但其实这里 sp 可以传入 null
    sp.process("sss")
    val nsp: StringProcessor = NullableStringPrinter()
    nsp.process(null)
}