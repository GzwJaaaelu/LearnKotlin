package com.gzw.kotlin.classAbout

class Country(val name: String)

//  data class 类似于 Java 中的 JavaBean，但不能充当 JavaBean 使用
//  data class 有一些缺点：其实它是 final 的 class，且没有那个无参的构造
//  不过上面的缺点可以插件解决

//  用 data 修饰，表示数据类，会自动帮你重写一些方法，如 toString、copy、hashCode、equals 等
data class DateCountry(val name: String)

fun main(args: Array<String>) {
    //  这时候打印出来的地址
    println(Country("中国"))

    val data = DateCountry("中国")
    println(data)
    //  component1() 就表示获取构造中的第一个参数
    println(data.component1())
    //  那么 component1() 的作用是什么呢？
    //  这种写法与之前遍历的时候 (index, value) in args.withIndex() 是一致的
    //  args.withIndex() 返回的就是 data 修饰 class，所以直接用(参数, 参数) 来接收值
    //  所以再这种 (参数, 参数...) = data class 的写法就不用惊讶了
    val (name) = data
    //  这时候这个 name 就会用 component1() 来赋值
    println(name)

    val component = ComponentX()
    val (a,b,c,d) = component
    println("$a$b$c$d")
}

//  自己重写 componentN 的操作符
class ComponentX {
    operator fun component1():String {
        return "您好，我是"
    }

    operator fun component2():Int {
        return 110
    }

    operator fun component3():String {
        return "，请问有什么"
    }

    operator fun component4():String {
        return "可以帮助您的么？"
    }
}