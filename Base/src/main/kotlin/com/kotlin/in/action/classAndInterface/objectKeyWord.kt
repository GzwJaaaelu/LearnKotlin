package com.kotlin.`in`.action.classAndInterface

import com.kotlin.`in`.action.base.Person
import com.kotlin.`in`.mooc.classAbout.extends.Driver

//  object 关键字的核心用途就是定义一个类时同时创建一个实例。

//  一些不同的使用场景：
//  1.对象声明是定义单例的一种方式。
//  2.伴生对象可以持有工厂方法和其他与这个类相关，但在调用时并不依赖类实例的方法。它们的成员可以通过类名来访问。
//  3.对象表达式用来替代 Java 的匿名内部类。

//  1.创建单例
//  引入 object 后，与类一样依然可以有属性、方法、初始化语句等声明，但是唯一不允许的就是构造方法（主构造、从构造）都没有
object Patroll :Driver{
    override fun drive() {
        println("日常飙车")
    }

    private val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {
            //  ...
        }
        println("Jaaaelu")
    }
}

data class Person(val name:String) {

    //  嵌套类
    object NameComparator : Comparator<com.kotlin.`in`.action.classAndInterface.Person> {

        override fun compare(o1: com.kotlin.`in`.action.classAndInterface.Person, o2: com.kotlin.`in`.action.classAndInterface.Person): Int
                = o1.name.compareTo(o2.name)
    }
}

//  2.伴生对象
//  关键字 companion，使用后可以通过类名访问这个对象的方法属性，看上去非常像是静态调用
//  可以访问私有
class ACompanion {

    private fun privateFun() {
        println("私有方法")
    }

    companion object {
        val PI = 3.14

        fun bar() {
            println("测试方法")
        }
    }
}

//  伴生对象作为普通对象使用
class PersonN(val name:String) {

    //  伴生对象可以有名字
    //  也可以实现接口
    companion object Loader : Driver {

        override fun drive() {
            println("伴生飙车")
        }

        fun fromJSON(jsonText:String) : com.kotlin.`in`.action.classAndInterface.Person
                = com.kotlin.`in`.action.classAndInterface.Person(jsonText)
    }
}

fun PersonN.Loader.test() = println("伴生对象的扩张方法")

//  3.匿名内部类的新写法
//  object 除了声明单例外还能用来声明匿名对象（也就是 Java 中的匿名内部类）
//  于声明对象不同，匿名对象不是单例，比如每次执行 other()。都会创建新的对象实例
class ABC {
    var count = 0

    fun other() {


        //  除了去掉名字外，语法与对象声明相同
        val a = object : Driver {

            override fun drive() {
                count++
                //  也可以访问外面的内容
                println("匿名内部类 $count")
            }
        }
        println(a)
        a.drive()
    }
}


fun main(args: Array<String>) {
    val p1:Driver = Patroll
    val p2 = Patroll
    p1.drive()
    //  可以通过对象调用
    p2.calculateSalary()
    //  也可以通过类名调用
    Patroll.calculateSalary()
    println(p1)
    println(p2)

    val persons = listOf(com.kotlin.`in`.action.classAndInterface.Person("A"),
            com.kotlin.`in`.action.classAndInterface.Person("b"))
    println(persons.sortedWith(com.kotlin.`in`.action.classAndInterface.Person.NameComparator))

    ACompanion.bar()
    println(ACompanion.PI)

    val PJ = PersonN.Loader.fromJSON("GGG")
    val PJO = PersonN.fromJSON("G")
    PersonN.drive()
    PersonN.test()

    val abc = ABC()
    abc.other()
    abc.other()
    abc.other()

    //  赋值给某个变量
    val driver = object : Driver {

        override fun drive() {
            println("赋值给某个变量的匿名对象")
        }
    }
    driver.drive()
}