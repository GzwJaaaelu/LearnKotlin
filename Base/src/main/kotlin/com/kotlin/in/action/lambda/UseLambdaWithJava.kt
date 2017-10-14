package com.kotlin.`in`.action.lambda

//  Lambda 的实现细节：从 Kotlin 1.0 开始，每个 Lambda 表达式都会被编译成一个匿名类，除非它是一个内联 Lambda
//  不过这里所说的匿名类只对期望函数式接口的 Java 方法有效

fun main(args: Array<String>) {
    val btnK = Button()
    //  这种方式的工作原理是 OnClickListener 接口只有一个抽象方法，也被称为函数式接口编程
    btnK.setOnclickListener { println("Lambda 表达式的 OnclickListener") }
    //  { println("延迟 2s 的打印") } 其实是一个实现了 Runnable 接口的匿名类实例，编译器会帮我创建它
    //  注意，这里有一点需要知道的，当我们显示的声明对象时，每次调用都会创建一个新的实例，而 Lambda 有所不同，如果 Lambda
    //  没有访问任何来自定义它的函数变量，相应的匿名类实例可以多次调用之间重用
    //  也就是说对于 { println("延迟 2s 的打印") }，整个程序只会创建一个该 Runnable 实例
    btnK.postDelay(2000) { println("延迟 2s 的打印") }
    //  也就和上面写法一致，这种写法简化后就是上面的那种写法
    //  这是把对象表达式作为函数式接口的实现传递
    btnK.postDelay(2000, object : Runnable {

        override fun run() {
            println("延迟 2s 的打印")
        }
    })

    val content = "今天天气不错"
    //  如果 Lambda 从包围它的作用域中捕捉了变量，每次调用就不再可能重用同一个实例了。
    postDelay(btnK, content)

    createAllDoneRunnable().run()
    createAllDoneRunnable { println("All Done!") }.run()
}

//  btnK.postDelay(2000) { println("延迟 2s 的打印") } 的完全等价实现也可以这样写
//  编译成全局变量，只有一个实例
val runnable = Runnable { println("延迟 2s 的打印") }

fun postDelay(v: View) {
    v.postDelay(2000, runnable)
}

fun postDelay(v: View, content: String) {
    v.postDelay(2000) { println(content) }
}

//  SAM 构造方法：显式的把 Lambda 转成函数式接口
//  例如你有一个方法 createAllDoneRunnable，返回的是函数式接口的实例，不能直接返回一个 Lambda，要用 SAM 构造方法把他包装起来
fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All Done!") }
}

fun createAllDoneRunnable(l: () -> Unit): Runnable {
    return Runnable(l)
}