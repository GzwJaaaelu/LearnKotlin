package com.kotlin.`in`.action.lambda

//  1.在作用域中访问变量

//  捕捉的原理：当你捕捉 final 变量时，它的值和使用这个值的 Lambda 代码一起存储。
//  对于非 final 变量来说，它的值被封装在一个特殊的包装器中，这样你就可以改变这个值，这个包装器的引用会和 Lambda
//  代码一起被存储。

fun printMessageWithPrefix(message: Collection<String>, prefix: String) {
    message.forEach {
        //  这里使用了函数的参数
        //  这里可以访问非 final 的变量
        println("$prefix $it")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    //  默认情况下，局部变量的生命周期被限制在声明这个变量的函数中
    //  但如果被 Lambda 捕捉了，那么使用这个变量的代码可以被存储并稍后再执行
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")) {
            //  Kotlin 中允许在 Lambda 中访问非 final 变量，甚至修改它们
            //  从 Lambda 内访问外部变量，我们称这些变量被 Lambda 捕捉
            //  就像例子中的 prefix，clientErrors 以及 serverErrors
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

//  2.成员引用
//  把函数转换为一个值，然后进行传递。
//  这种表达式成为成员引用，用来创建一个调用单个方法访问单个属性的函数值。
//  类与成员中间用::隔开，例：类::成员，成员引用并不需要加上
val getAge = Person::age
//  这种写法其实是下面的更简洁的写法
val getAgeOther = { p: Person -> p.age }

//  还可以引用顶层函数
fun printMessage() = println("Jaaaelu")

//  委托给其他多参数函数
fun sendEmail(person: Person, message: String) {
    println("${person.name} get a message: $message")
}

val action = { person: Person, message: String ->
    sendEmail(person, message)
}
//  也可以直接写成
val nextAction = ::sendEmail

fun Person.isAdult(): Boolean = age >= 18

fun main(args: Array<String>) {
    val error = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(error, "Error：")

    val responses = listOf("200 Ok",
            "418 I'm a teapot",
            "500 Internal Server Error")
    printProblemCounts(responses)

    println(getAge(Person("Gzw", 23)))

    //  引用顶层函数，这种情况下可以省略类名直接已::开头
    run(::printMessage)

    //  创建实例
    val p = ::Person
    println(p("Gzw", 21))

    //  引用扩展方法
    //  1.0 中，当接收者是接收的是一个类引用方法或属性的时候，调用接收者时需要提供该类的实例
    val predicate = Person::isAdult
    println(predicate(p("Gzw", 21)))

    //  1.1 开始支持绑定成员引用
    val person = (p("Gzw", 21))
    println((person::isAdult)())

}