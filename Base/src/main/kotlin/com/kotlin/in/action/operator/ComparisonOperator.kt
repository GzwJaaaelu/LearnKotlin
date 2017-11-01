package com.kotlin.`in`.action.operator

//  等号运算符：equals，在 Kotlin 中使用 == 会被转成 equals
//  而 != 也会被转成 equals，只是返回的结果是相反的
//  == 与 != 可用于空运算数，因为这些运算符实际上会检查运算数是否为 null
//  如 a == b，会先检查 a 是否为空，如果不是，就会调用 a.equals(b)，否则两个都是 null 的时候才会返回 true
//  a == b -> a?.equals(b) ?: (b == bull)

//  Comparable 便于比较值
class P(val x: Int, val y: Int) : Comparable<P> {

    //  用于比较一个对象是否大于另一个对象
    //  比较运算符 >, <, >=, <= 将被转换为 compareTo
    //  即 a > b -> a.compareTo(b) >= 0
    override fun compareTo(other: P): Int {
        return compareValuesBy(this, other, P::x, P::y)
    }

    //  重写 equals 方法
    //  这里我们虽然是重载了比较运算符 equals，但是方法前缀不是 operator 而是 override，因为 equals 是 Any 中定义的方法
    //  equals 不能实现扩展函数，因为集成自 Any 类的实现始终优先于扩展方法
    override fun equals(other: Any?): Boolean {
        //  先检查是否为同一个对象
        //  这里 === 与 Java 中的 == 完全相同（检查两个参数是否是同一个对象的引用，基本类型的话会比较值）
        //  === 不能被重载
        if (other === this) return true
        //  检查参数类型
        if (other !is P) return false
        //  检查值
        return other.x == x && other.y == y
    }
}

class Person(private val firstName: String, private val lastName: String) : Comparable<Person> {

    override fun compareTo(other: Person): Int {
        //  按照顺序调用给定的方法并比较他们的值
        //  这里调用 Kotlin 标准库中的 compareValuesBy 来简洁的实现 compareTo 方法
        //  按照顺序进行比较，如果第一个是相同的，那么就会继续比较第二个，以此类推
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}

fun main(args: Array<String>) {
    val a = null
    println(a == 1)

    println(P(1, 2) > P(1, 0))
    println(Person("a", "G") > Person("b", "G"))
}