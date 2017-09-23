package com.kotlin.`in`.action.funcy

fun main(args: Array<String>) {
    //  Java 中 System.out.println("12.345-6.A".split(".").length); 返回 0
    //  所以在 Java 中 split(".") 其实是不起作用的，原因是 . 是表示任意符号的正则表达式
    //  不过 Kotlin 中 split(".") 还是起作用的
    println("12.345-6.A".split("."))
    //  Kotlin 中的 split 还支持传入 Regex
    //  以及同时分割多个分隔符
    println("12.345-6.A".split(".", "-"))

    parsePath("E:/LearnKotlin/Base/src/main/kotlin/com/kotlin/in/action/funcy/OperationCollection.kt")
    parsePathWithRegEx("E:/LearnKotlin/Base/src/main/kotlin/com/kotlin/in/action/funcy/OperationCollection.kt")

    //  三重引号的目的不仅是在于避免转义字符，而且它还可以包含任何字符，包括换行
    val kotlinLogo = """|  //
                       .| //
                       .| / \"""
    //  trimMargin 用于删除前缀与空格
    println(kotlinLogo.trimMargin("."))

    //  目录
    println("E:\\LearnKotlin\\Base\\src\\main\\kotlin\\com\\kotlin\\in\\action\\funcy")
    println("""E:\LearnKotlin\Base\src\main\kotlin\com\kotlin\in\action\funcy""")
    //  三重引号中使用字符串模板
    println("""${'$'}99""")
}

/**
 * 解析文件路径与相关信息
 */
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

/**
 * 通过正则表达式解析
 */
fun parsePathWithRegEx(path: String) {
    //  这个例子正则表达式写在了三重引号的字符串中
    //  这种字符串不需要对任何字符串进行转义
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    } else{
        println("该文件目录无法解析...")
    }
}