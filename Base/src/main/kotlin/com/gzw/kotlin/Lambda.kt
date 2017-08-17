package com.gzw.kotlin

//  Lambda 其实就是匿名函数
//  只要函数的最后的参数是 Lambda 表达式，那么就可以将他移到 () 外面去
//  如果此时小括号中没有参数，那么也可以删除这个小括号，见 Line 19
//  如果传入的参数和 Lambda 表达式一样，还可以继续简化

//  方法的参数最多只能有 23 个

//  相当于(Array<String>) -> Unit  这也叫做函数的类型，也叫做
fun main(args: Array<String>) {
//    println(sumAndPrint(1, 3))
//    //  也相当于
//    println(sumAndPrint.invoke(1,4))

    //  遍历方式一
    for(i in args) {
        print(i)
    }

    println("")

    //  遍历方式二 也相当于是这样
    args.forEach ({it ->  print(it)})

    println("")

    //  遍历方式二 也相当于是这样
    args.forEach ({print(it)})

    println("")

    //  遍历方式二 也相当于是这样
    args.forEach (){print(it)}

    println("")

    //  遍历方式二
    args.forEach ForEach@{
        if (it == "z") {
//            //  这是相当于返回 main 函数
//            return

            //  结束了 Lambda 的执行 并不是终止 main
            //  返回了这一次 Lambda 表达式的调用
            return@ForEach
        }
        print(it)
    }

    //  (Any?) -> Unit
    println("")

    //  遍历方式二 再次简化
    args.forEach(::print)

    println("")

    //  打印结果是 Function2<java.lang.Integer, java.lang.Integer, java.lang.Integer>
    //  Function2 也就是两个输入一个输出的方法
    println(sumAndPrint)

    //  ::sumOld 对有名字的函数的引用
    println(::sumOld is (Int, Int) -> Int)

}

//  正常 sum
//  相当于(Int, Int) -> Int
fun sumOld(arg1: Int, arg2: Int): Int {
    return arg1 + arg2
}

//  Lambda 表达式形式的 sum
val sumLambda = { arg1: Int, arg2: Int -> arg1 + arg2 }

//  Lambda 表达式形式的 sum 且其中还能有其他语句
//  相当于(Int, Int) -> Int
val sumAndPrint = { arg1: Int, arg2: Int ->
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    arg1 + arg2
}

//  没有参数和返回值的时候，可以直接将其写在大括号内
val printHello = {
    //  相当于函数体
    println("Hello")
}