package com.kotlin.`in`.action.higherOrderFun

//  8.3 告诫函数中的控制流

//  8.3.1 Lambda 中的返回语句：从一个封闭的函数返回

data class Per(val name: String, val age: Int)

val people = listOf(Per("Alice", 29), Per("Bob", 31))

fun lookForAlice(people: List<Per>) {
    for (per in people) {
        if (per.name == "Alice") {
            println(per)
            return
        }
    }
    println("Alice is not found")
}

fun lookForAliceUseForeach(people: List<Per>) {
    people.forEach {
        if (it.name == "Alice") {
            println(it)
            //  如果在 Lambda 中使用 return 关键字，它会从调用 Lambda 的函数中返回，
            //  并不是 Lambda 中返回，这样 return 语句叫做非局部返回。
            //  因为它从一个比包含 return 的代码块更大的代码块中返回了。
            //  就是 Java 中在 for 循环中返回其实也是从函数中返回，而不是从循环或者代码块中返回。
            return
        }
    }
    println("Alice is not found")
    println("不继续执行 Lambda 后续代码")
}

//  需要注意的是，只有在以 Lambda 作为参数的函数式内联函数的时候才能从更外层的函数返回。
//  上面的 lookForAliceUseForeach，forEach 的函数体和 Lambda 的函数体一起被内联了，所以编译的时候就跟容易做到从包含它的
//  函数中返回。

//  在一个非内联函数的 Lambda 中使用 return 表达式是不允许的。
//  一个非内联函数可以把传给它的 Lambda 保存在变量中，以便在函数返回以后可以继续使用，这个时候 Lambda 想去影响函数的返回
//  已经太晚了。

//  8.3.2 从 Lambda 返回：使用标签返回

//  上面说了 return 语句是从非局部返回的，当然 Lambda 也可以从局部返回跟 for 循环中的 break 表达式显示。
//  它会终止 Lambda 的执行，并接着从调用的 Lambda 的代码执行。
//  这时候我们需要使用到标签，并从 Lambda 中返回到你标记的地方。

fun lookForAliceUseForeachLabelReturn(people: List<Per>) {
    //  给 Lambda 添加了自定义的标签
    people.forEach label@ {
        if (it.name == "Alice") {
            println(it)
            //  引用了这个标签
            return@label
        }
    }
    println("继续执行 Lambda 后续代码")

    people.forEach {
        if (it.name == "Alice") {
            println(it)
            //  当然也可以直接这么写
            //  不过如果你已经显式的指定了 Lambda 标签，在使用函数名作为标签就没有效果了
            return@forEach
        }
    }
    println("又继续执行 Lambda 后续代码")
}

//  8.3.3 匿名函数：默认使用局部返回

//  在匿名函数中使用 return
//  没有标签时，return 从最近的使用 fun 关键字声明的函数返回
//  Lambda 表达式没有使用 fun 关键字，所以 Lambda 从最近的使用 fun 关键字声明的函数返回
//  匿名函数使用了 fun，因此，看上去就是局部返回
fun lookForAliceWithAnonymousFun(people: List<Per>) {
    people.forEach(fun(per) {
        //  默认使用局部返回
        if (per.name == "Alice") return
        println("${per.name} is not Alice")
    })
    println("继续执行 Lambda 后续代码")
}

fun main(args: Array<String>) {
    lookForAlice(people)
    lookForAliceUseForeach(people)
    lookForAliceUseForeachLabelReturn(people)
    lookForAliceWithAnonymousFun(people)

    //  在 filter 中使用匿名函数
    //  匿名函数和普通函数有相同的指定返回值类型的规则
    println(people.filter(fun(per): Boolean {
        return per.age < 30
    }))
}