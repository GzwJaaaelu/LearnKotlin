package com.kotlin.`in`.mooc.someNew

import kotlin.reflect.KProperty

//  属性代理 可以用来隐藏很多实现细节

class Delegates {
    //  只有第一次在访问这个 hello 才会被初始化
    //  by 后面的 lazy 就是一个代理
    val hello by lazy {
        "Hello"
    }

    //  就是说 testX 或 hello 的 get 方法也就交给了代理对象去操作了
    //  傀儡与幕后黑手
    //  val 只需要代理由 get 方法即可
    val testX by X()

    //  var 同时需要 get / set
    //  所以对 testY 进行获取的时候其实调用 Y 的 getValue
    //  设置时是调用 Y 的 setValue
    var testY by Y()
}

class X {
    //  自定义的代理，这里只代理了 String
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "Jaaaelu"
    }
}

class Y {
    private var value: String? = null

    //  自定义的代理，这里只代理了 String
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue: $thisRef- > ${property.name}")
        return value ?: ""
    }

    //  自定义的代理，这里只代理了 String
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("setValue: $thisRef- > ${property.name}")
        this.value = value
    }
}

fun main(args: Array<String>) {
    val d = Delegates()
    println(d.hello)
    println(d.testX)
    println(d.testY)
    d.testY = "testY"
    print(d.testY)
}