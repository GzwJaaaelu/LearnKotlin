package com.kotlin.`in`.action.operator

import java.lang.reflect.Type
import kotlin.reflect.KProperty

//  委托，操作的对象不用自己执行，而是把工作委托给另一个辅助对象，我们把辅助对象称为委托

class Foo {
    //  将访问器逻辑委托给另一个对象，也就是 Delegate 对象
    val p: Type by Delegate()
}

//  编译器会自动帮我们生成一个这样的代码
//
class FooReal {
    private val d = Delegate()

    //  由于这里报错先注释
//    val p:Type
//        get() = d.getValue()
}

class Delegate {

    operator fun getValue(foo: Foo, property: KProperty<*>): Type {
        return object : Type {
            override fun getTypeName(): String {
                return "Demo"
            }
        }
    }
}

class Email {}

fun loadEmails(p: PersonOther): List<Email> {
    println("Load email for ${p.name} ")
    //  这里从某个地方去读取，省略简单的返回空列表
    return listOf()
}

//  加载某个人的邮箱列表是一个比较消耗资源的事情，所以等真的有人访问邮箱的时候再去获取数据（懒加载）
class PersonOther(val name: String) {
    private var _emails: List<Email>? = null

    //  使用额外的 _emails 属性来实现惰性加载
    //  且这个实现不是线程安全的
    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this)
            }
            return _emails!!
        }

    //  Kotlin 中我们使用委托来使代码变得简单
    //  lazy 函数会能返回一个对象，且带有对相应的 get / set 方法
    //  lazy 是线程安全的
    val emailsByLazy by lazy { loadEmails(this) }
}

fun main(args: Array<String>) {
    val foo = Foo()
    println(foo.p.typeName)
}