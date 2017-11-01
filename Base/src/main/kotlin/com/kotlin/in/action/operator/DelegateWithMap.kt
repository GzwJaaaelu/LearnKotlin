package com.kotlin.`in`.action.operator

//  在 map 中保存属性值

class Per {
    private val _attributes = hashMapOf<String, String>()

    fun setAttributes(attrName: String, value: String) {
        _attributes[attrName] = value
    }

//    顶一个属性，把值存到 map 中
//    val name: String
//        get() = _attributes["name"]!!

    //  使用委托属性把值存到 map 中
    val name: String by _attributes
}

fun main(args: Array<String>) {
    val p = Per()
    p.setAttributes("name", "XJL")
    println(p.name)
}