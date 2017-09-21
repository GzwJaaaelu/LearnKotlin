package com.kotlin.`in`.mooc.someNew

import java.io.BufferedReader
import java.io.FileReader

data class Person(val name:String, val age:Int) {

    fun work() {
        println("$name is working")
    }
}

fun main(args: Array<String>) {
    //  因为返回的是可空类型的 Person
    //  所以如果要打印的话还比较麻烦
    //  每次打印属性都要判断是否为空 ?.
    val per = findPerson()
//    println(per?.name)
//    println(per?.age)

    //  可以使用这种方式
    //  (name, age) 等于 data class Person 的实例
    //  这个还能有返回值
    //  如果没进入 let 那么救返回 null 而不是 3 + 4
    val lll = findPerson()?.let { (name, age) ->
        println(name)
        println(age)

        3 + 4
    }
    println(lll)

    //  如果直接使用方法且只有一句
    findPerson()?.let(Person::work)

    //  这里又有方法又有属性
    //  能不能这里不要通过 person. 的方式调用呢？
    //  当然可以
    findPerson()?.let { person ->
        println(person.name)
        println(person.age)
        person.work()
    }

    //  不用通过 person. 的方式就可以直接访问
    findPerson()?.apply {
        println(name)
        println(age)
        work()
    }

    //  Kotlin 中的小文件的快速读取
    val br = BufferedReader(FileReader("hello.txt")).readLines()

    //  with 函数
    with(br) {
        //  with 内 br 的方法随便调用，且可以定义其他变量
        br.forEach(::println)
    }

    //  正常情况下我们需要自己调用 close
    //  使用 ues 后他接收一个实现了 Closeable 的类
    //  并且会在使用结束后自动帮我们调用 close
    BufferedReader(FileReader("hello.txt")).use {
        var content:String?
        while (true) {
            //  这里需要添加 it
            content = it.readLine()?:break
            println(content)
        }
    }
}

fun findPerson(): Person? {
    return Person("Gzw", 23)
}