package com.kotlin.`in`.action.operator.demo

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

open class PropertyChangAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person(val name: String, age: Int, salary: Int) : PropertyChangAware() {

    private val observer = { prop: KProperty<*>, old: Int, new: Int ->
        changeSupport.firePropertyChange(prop.name, old, new)
    }

    //  第四版代码，不借助自定义的辅助类，而是通过 Delegates.observable 来实现
    //  by 右边不一定是新创建的实例，也可以是是函数调用、另一个属性或任何其他表达式
    //  只要这个表达式的值，能够被编译器用正确的参数来调用 getValue 或 setValue
    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)

//    第三版代码，使用委托属性来实现
//    var age :Int by ObservableProperty(propValue = age, changeSupport = changeSupport)
//    var salary :Int by ObservableProperty(propValue = salary, changeSupport = changeSupport)

//    第二版代码，在第一版的基础上进行了简化
//    private val _age = ObservableProperty("age", age, changeSupport)
//    var age: Int
//        get() = _age.getValue()
//        set(value) {
//            _age.setValue(value)
//        }
//
//    private val _salary = ObservableProperty("salary", salary, changeSupport)
//    var salary: Int
//        get() = _salary.getValue()
//        set(value) {
//            _salary.setValue(value)
//        }

//    第一版代码，未简化
//    var age: Int = age
//        set(value) {
//            val old = field
//            field = value
//            changeSupport.firePropertyChange("age", old, value)
//        }
//
//    var salary: Int = salary
//        set(value) {
//            val old = field
//            field = value
//            changeSupport.firePropertyChange("salary", old, value)
//        }
}

//  上面的 Person 中代码重复，所以通过辅助类提取代码
class ObservableProperty(val propName: String = "", var propValue: Int, val changeSupport: PropertyChangeSupport) {

    //  配合 Person 中的第三版，委托属性的实现代码
    operator fun getValue(person: Person, property: KProperty<*>): Int = propValue

    operator fun setValue(person: Person, property: KProperty<*>, new: Int) {
        val old = propValue
        propValue = new
        changeSupport.firePropertyChange(propName, old, new)
    }

//    配合 Person 中的第二版代码使用
//    fun getValue(): Int = propValue
//    fun setValue(new: Int) {
//        val old = propValue
//        propValue = new
//        changeSupport.firePropertyChange(propName, old, new)
//    }
}

fun main(args: Array<String>) {
    val p = Person("Gzw", 23, 1000)
    p.addPropertyChangeListener(PropertyChangeListener {
        println("Property ${it.propertyName} changed from ${it.oldValue} to ${it.newValue}")
    })

    p.age = 24
    p.salary = 100000000
}