package com.kotlin.`in`.mooc.funcy

import com.kotlin.`in`.mooc.someNew.add

//  m(x) = f(g(x))  复合函数

//  g(x)
val add5 = { i: Int -> i + 5 }
//  f(x)
val multiplyBy2 = { i: Int -> i * 2 }

fun main(args: Array<String>) {
    //  相当于 (5 + 5) * 2
    //  但每次都这么写可能有些麻烦，所以希望复合起来
    println(multiplyBy2(add5(5)))

    //  这时候返回一个函数，然后调用该函数
    val add5AndMultiplyBy2 = add5 andThen multiplyBy2
    //  相当于 f(g(x))
    println(add5AndMultiplyBy2(5))

    val add5ComposeMultiplyBy2 = multiplyBy2 andThen add5
    //  相当于 g(f(x))
    println(add5ComposeMultiplyBy2(5))
}

//  知识点：1.扩展方法；2.中缀表达式；3.Function0 - Function23；
//  为 Function1 添加了一个扩展函数，接收一个函数，并且返回一个函数
//  Function1 的第一个泛型参数表示参数类型，第二个泛型类型表示他的返回值类型
infix fun <P1, P2, R> Function1<P1, P2>.andThen(function: Function1<P2, R>): Function1<P1, R> {
    return fun(p1: P1): R {
        return function.invoke(this.invoke(p1))
    }
}

infix fun <P1, P2, R> Function1<P2, R>.compose(function: Function1<P1, P2>): Function1<P1, R> {
    return fun(p1: P1): R {
        return this.invoke(function.invoke(p1))
    }
}