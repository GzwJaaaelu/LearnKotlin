package com.kotlin.`in`.action.lambda

import java.io.File

//  之前在对列表做 map 或 filter 操作时，这些函数都会创建中间集合
//  如 people.map(Person::name).filter { it.startWith("A") }
//  这种情况下回创建两个中间列表，一个用来保存 map 的返回结果，一个用来存储 filter 的返回结果
//  这样的话，如果元素数量过多，这种链式调用就会变得十分低效

//  所以这时候就引入序列，将上述操作变成使用序列，而不是直接返回集合

//  序列：惰性集合操作，由于序列中的元素求值是惰性的，因此，可以使用序列更高效的对集合元素执行链式操作，而不需要创建额外
//  中间集合来保存中间过程中产生的结果

//  为什么最后还要把序列转回集合呢？因为如果你想如果除了迭代之外的其他的 API，比如用下标访问元素，那么救应该把序列转换成集合

//  通常大型集合执行链式操作时尽量使用序列

//  序列操作分为两类：中间操作和末端操作，且中间操作始终都是惰性的，而末端操作才回会触发执行是所有延期计算

//  惰性操作是对元素逐个处理

//  序列就是 Java8 中流的翻版

fun main(args: Array<String>) {

    val people = listOf(Person("A", 11),
            Person("B", 22),
            Person("C", 33))

    //  先将集合转为序列，然后进一步进行函数操作，最后再将序列转为集合
    //  这时就不会创建中间集合
    //  下面的计算中.map(Person::name).filter { it.startsWith("A") } 就是中间操作
    //  而 toList() 是末端操作
    println(people
            .asSequence()
            .map(Person::name)
            .filter { it.startsWith("A") }
            .toList())

    //  这里我们想要使用打印，而事实上并不会有任何内容被打印大控制台中
    //  由于中间操作时惰性的，所以 map 和 filter 变换被延期了
    listOf(1, 2, 3, 4).asSequence()
            .map { print("map($it)  "); it * it }
            .filter { print("filter($it)  "); it % 2 == 0 }

    //  只有当我们调用了末端操作时，才会被引用
    //  末端操作才会触发被延期的计算
    //  序列的执行顺序是按照元素来的，所以打印出来的内容是 map 第一个元素，filter 第一个元素，如此往下
    //  而我们正常集合操作的话就是先全部 map，然后再全部 filter
    println(listOf(1, 2, 3, 4).asSequence()
            .map { print("map($it)  "); it * it }
            .filter { print("filter($it)  "); it % 2 == 0 }
            .toList())

    //  正常情况下我们先 map 所有元素，然后 再一个个 find
    //  而使用序列后，就变成了，map 一个 find 一个，map 一个，find 一个
    //  而这个式子中，第二个元素就已经满足了输入条件，所以后面没有被 map 的也就不会被继续执行了
    println(listOf(1, 2, 3, 4).asSequence()
            .map { print("map($it)  "); it * it }
            .find { print("find($it)  "); it > 3 })

    //  先 filter 再 map，如果不影响结果的话，这样更高效
    println(listOf(1, 2, 3, 4).asSequence()
            .filter { print("filter($it)  "); it % 2 == 0 }
            .map { print("map($it)  "); it * it }
            .toList())

    //  如何手动创建序列
    //  计算 100 以内的自然数之和
    //  这里的 naturalNumbers 和 numbersTo100 都是延期操作的序列，直到你调用了 sum（末端操作）才会求值
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())

    val file = File("/User/see/.HiddenDir/story.txt")
    println(file.isInsideHiddenDirectory())
}

fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }