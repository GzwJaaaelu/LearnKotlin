package com.gzw.kotlin

class ClassMemberAndMethod {
    //  默认有 get / set
    var test = 15
    var s = ""
        get() {
            println(field)
            return field
        }

        //  默认是 public
        public set

    //  告诉编译器，我会后面再初始化
    lateinit var x: String
    //  val 类型的延迟初始化
    val z: ClassMemberAndMethod by lazy {
        println("z = ClassMemberAndMethod")
        ClassMemberAndMethod()
    }

}

fun main(args: Array<String>) {
    var c = ClassMemberAndMethod()

    c.z
}