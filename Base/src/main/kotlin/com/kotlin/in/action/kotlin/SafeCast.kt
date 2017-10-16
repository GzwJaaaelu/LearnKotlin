package com.kotlin.`in`.action.kotlin

//  安全转换 as?

class Person(val name: String) {

    override fun equals(other: Any?): Boolean {
        //  这里就检查了类型，如果匹配会自动转换，如果不匹配就返回 false
        val otherPerson = other as? Person ?: return false
        //  这里 otherPerson 已经被智能的转换为 Person 类型了
        return otherPerson.name == this.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}