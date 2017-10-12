package com.kotlin.`in`.action.lambda

//  Lambda 表达式本质上就是可以传递给其他函数的一小段代码（作为函数参数的代码块）
//  函数式表层提供了另一种解决方案：把函数作为值来看待
//  这样可以直接传递函数，而不是先声明一个类再传递这个类（或匿名内部类）

data class Person(val name: String, val age: Int)

fun findTheOldest(people:List<Person>) {
    var maxAge = 0
    var theOldest:Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }

    println(theOldest)
}

fun main(args: Array<String>) {
    val btnJ = Button()
    btnJ.setOnclickListener(
            //  可以简化为 Lambda
            object : View.OnClickListener {

                override fun onClick(view: View?) {
                    println("匿名内部类的 OnclickListener")
                }
            }
    )
    val btnK = Button()
    btnK.setOnclickListener { println("Lambda 表达式的 OnclickListener") }

    //  Lambda 和集合
    val people = listOf(Person("A", 11),
            Person("B", 22),
            Person("C", 33))
    //  这是 Java 中的正常写法
    findTheOldest(people)
    //  Lambda 表达式
    //  { it.age } 就是 Lambda 表达式
    //  { it.age } 也相当于 { person -> person.age }
    //  it 表示表示集合中元素的引用
    println(people.maxBy { it.age })
    println(people.maxBy { person -> person.age })
    //  :: 表示引用，也就是 Person 的 age 属性
    println(people.maxBy (Person::age))
}