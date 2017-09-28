package com.kotlin.`in`.action.classAndInterface

//  Java 中 == 用来比较基本类型的值与引用类型的引用是否相同，而想要比较引用的某些具体值就需要用到 equal，如 String 的
//  equal 方法

//  Kotlin 中 == 实际上是调用 equal 方法进行比较，如果你的类重写了 equal 那么就可以放心使用 == 来比较两个实例，而如果想
//  要直接比较医用，那么需要使用 ===，=== 与 Java 中的 == 效果一致

//  这是正常情况下我们在 Java 中的代码习惯
class Client(val name: String, private val postalCode: Int) {

    //  像 Java 中自己手动重写，然后可以用来比较对象
    //  不过 hashCode 与 equals 一般会一起被重写
    //  且会先比较 hashCode，如果哈希值不同才会进行 equal 判断
    //  因为如果两个对象相等，那么它们必须有着相同的哈希值

    //  equal 用来比较实例
    //  hashCode 用来作为例如 HashMap 这种基于哈希容器的键
    //  toString 用来作为类生成按声明顺序排列的所有字段的字符串表达形式

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) return false

        return this.name == other.name &&
                this.postalCode == other.postalCode
    }

    override fun toString(): String {
        return "Client (name = $name, postalCode = $postalCode)"
    }
}

//  Kotlin 中 data class 会自动帮我们实现 toString、hashCode、equals 等常用方法
//  书中建议数据类的属性使用 val
data class ClientOptimize(val name: String, private val postalCode: Int)

fun main(args: Array<String>) {

    val clientOne = Client("8080", 8080)
    val clientTwo = Client("8080", 8080)

    println(clientOne == clientTwo)

    val clients = hashSetOf(clientOne, clientTwo)
    println(clients)

    val clientOptimizeOne = ClientOptimize("8080", 8080)
    val clientOptimizeTwo = ClientOptimize("8080", 8080)

    println(clientOptimizeOne == clientOptimizeTwo)

    val clientOptimizes = hashSetOf(clientOptimizeOne, clientOptimizeTwo)
    println(clientOptimizes)
}