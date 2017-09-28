package com.kotlin.`in`.action.classAndInterface

import java.io.Serializable

//  内部类和嵌套类：默认是嵌套类
//  Kotlin 中的嵌套类一般情况下不能访问外部类的实例

interface State : Serializable

interface View {

    fun getCurrentState(): State

    fun restoreState(state: State) {

    }
}

class Button : View {

    override fun getCurrentState(): State = ButtonState()

    //  这个类与 Java 中的静态嵌套类类似，而不是内部类
    //  所以 ButtonState 不会持有外部引用
    class ButtonState : State {

        override fun toString(): String {
            return "ButtonState"
        }
    }

    //  inner class 与 Java 的内部类类似
    //  所以 OtherButtonState 会持有外部类的应用
    inner class OtherButtonState : State {

        //  拿到外部类的引用
        fun getOutReference(): Button = this@Button
    }
}

fun main(args: Array<String>) {
    val btn = Button()
    val obs = btn.OtherButtonState()
    println(obs.getOutReference().getCurrentState())
}