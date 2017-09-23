package com.kotlin.`in`.action.funcy

//  局部函数和扩展

class User(val id: Int, val name: String, val address: String)

//  一般写法
fun saveUser(user:User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty address")
    }

    //  然后存储逻辑省略
}

//  通过提取局部函数和扩展来避免重复
fun saveUserWithOptimize(user:User) {
    user.validateBeforeSave()

    //  然后存储逻辑省略
}

//  通过提取局部函数来避免重复
fun User.validateBeforeSave() {
    //  声明一个局部函数来进行字段校验
    fun validate(value:String, fieldName:String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "name")
    validate(address, "address")
}
