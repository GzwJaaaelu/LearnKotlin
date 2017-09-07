package com.gzw.kotlin.classAbout.extends

interface Driver {
    fun drive()
}

interface Writer {
    fun write()
}

//  普通经理，开车和写报告要自己来

class Manager : Driver, Writer {

    override fun write() {

    }

    override fun drive() {

    }
}

//  资深经理也具备开车和写报告的技能，但是因为董事们为他配备了专职司机和秘书所以这些事他们做就行了
//  这种写法叫接口代理，由别人来替他去做 关键词 by
//  by 的使用场景有两个一个是接口代理，一个属性代理

class SeniorManager(private val driver: Driver, private val writer: Writer) : Driver by driver, Writer by writer {

    //  人家做别的去了
    fun doSomeOther() {

    }
}

class CarDriver : Driver {

    override fun drive() {
        println("专职司机开着奔驰接送资深经理")
    }
}

class ReportWriter : Writer {

    override fun write() {
        println("秘书正在连夜赶出明天需要提交的报告")
    }
}

fun main(args: Array<String>) {
    val seniorManager = SeniorManager(CarDriver(), ReportWriter())
    seniorManager.drive()
    seniorManager.write()
}

