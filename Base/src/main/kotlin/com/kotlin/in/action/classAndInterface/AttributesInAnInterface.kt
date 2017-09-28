package com.kotlin.`in`.action.classAndInterface

//  实现接口中声明的属性

interface IUser {
    val nick: String

    val email: String
    val account: String
        get() = email.substringBefore("@")

    var address: String
}

//  实现方式一 主构造中声明
class UserImp(override val nick: String, override val email: String, override var address: String) : IUser

//  实现方式二
class UserImpl(private val otherName: String) : IUser {
    override val email: String
        get() = "gzw102030@outlook.com"
    //  如果是 var 还需要重写 setter
    override val nick: String
        get() = otherName.plus(".")

    //  重写 var
    override var address: String = "nothing"
        get() = field
        set(value) {
            field = value
        }
}

class Test {
    //  setter 方法私有
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

