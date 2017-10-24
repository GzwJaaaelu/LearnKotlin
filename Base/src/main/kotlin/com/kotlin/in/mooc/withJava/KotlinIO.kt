package com.kotlin.`in`.mooc.withJava

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main(args: Array<String>) {
    //  写法一
    val file = File("build.gradle")
    val bufferedReader = BufferedReader(FileReader(file))
    var line: String

    while (true) {
        //  读到空就 break
        line = bufferedReader.readLine() ?: break
        println(line)
    }

    bufferedReader.close()

    //  写法二，BufferedReader 会自动关闭
    BufferedReader(FileReader(file)).use {
        var l: String
        while (true) {
            //  读到空就 break
            l = it.readLine() ?: break
            println(l)
        }
    }

    //  写法三，对于一些较小的文件来说可以直接 readLines
    file.readLines().forEach(::println)
}