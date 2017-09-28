package com.kotlin.`in`.action.classAndInterface

import javax.naming.Context
import javax.swing.text.AttributeSet

//  声明带有非默认构造函数或属性的类

//  (val nick: String) 这里被括号围起来的语句就叫做主构造方法
//  用来表明构造方法参与已经定义使用这些初始化的属性
class User(val nick: String)

//  上面的写法也就相当于这样
//  constructor 用来声明一个构造（主构造）
//  init 表示引入一个初始化语句块，这种语句块会在类被创建时执行，并且与主构造方法一起使用
class User2 constructor(nick: String) {

    val nick: String

    init {
        this.nick = nick
    }
}

//  User2 的简化版，再继续简化就成了 User 的样子
class User3 constructor(nick: String) {

    val nick: String = nick
}

//  构造方法参数可以有默认值
//  如果所有构造方法参数都有默认值，那么就会生成一个无参构造
//  所以其实通过默认值我们就已经可以完成多个构造的重载
class User4(val nick: String,
            val t: Boolean = true)

//  默认会自动生成一个无参构造
open class B

//  这里必须显示的调用父类的构造方法
//  如果父类的的构造带参那么也必须调用带参的构造
class RB : B()

interface A

//  注意这里因为接口没有构造，所以 A 没有括号，而类后面需要有
class RA : A

//  私有构造，所以无法被实例化
class See private constructor()

//  真正的多构造
open class AndroidView {

    constructor(ctx: Context) {
        println("构造一")
    }

    constructor(ctx: Context, attr: AttributeSet) {
        println("构造二")
    }

    constructor(ctx: Context, attr: AttributeSet, text: String) {
        println("构造三")
    }
}

class AndroidBtn : AndroidView {

    //  这里表示调用父类构造
    constructor(ctx: Context) : super(ctx) {
        println("构造一")
    }

    //  这里委托给自己的另一个构造方法
    constructor(ctx: Context, attr: AttributeSet) : this(ctx, attr, "") {
        println("构造二")
    }

    constructor(ctx: Context, attr: AttributeSet, text: String) : super(ctx, attr) {
        println("构造三")
    }
}