package com.kotlin.`in`.action.classAndInterface

//  密封类
//  1.0 时所有的直接子类必须嵌套在父类中，密封类不能在类外部拥有子类
//  1.1 改为同一文件内可以随便定义密封类的子类
//  sealed 修饰符银行的这个类是一个 open 类

//  Expr 的构造方法是私有的
//  可以有抽象方法
sealed class Expr {
    class Num(val value: Int) : Expr() {

        override fun test() {

        }
    }

    class Sum(val left: Expr, val right: Expr) : Expr() {

        override fun test() {

        }
    }

    abstract fun test()
}

class Other() : Expr() {

    override fun test() {

    }
}

//  计算 （1 + 2）+ 4

fun eval(e: Expr): Int {
    return when (e) {
    //  这里进行了类型判断之后如果是就不需要自己手动做类型转换了，编译器已经自动帮我们做了
    //  且代码块中最后的表达式就是结果
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("未知类型")
    }
}

fun main(args: Array<String>) {
    println(eval(Expr.Sum(Expr.Num(3), Expr.Num(5))))
}