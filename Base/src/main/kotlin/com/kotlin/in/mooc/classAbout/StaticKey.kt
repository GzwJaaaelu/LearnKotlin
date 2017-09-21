package com.kotlin.`in`.mooc.classAbout

class Lat private constructor(val value: Double) {

    //  companion object 为 Lat 的伴生对象
    //  每个类可以对应一个伴生对象
    //  伴生对象也是单例的
    //  类似于 Java 的静态方法
    //  不加 JvmStatic 时在 Java 中调用方式为 Lat.Companion.ofDouble()
    //  加了 JvmStatic 就可以像是静态一样了 Lat.ofDouble()
    companion object {
        //  所以如果不在 Java 中调用就可以不加这个注解了
        @JvmStatic
        fun ofDouble(double: Double): Lat {
            return Lat(double)
        }

        //  Java 中想要 Lat.TAG 需要加 JvmField
        //  类似静态变量
        @JvmField
        val TAG: String = "Lat.class"
    }
}

fun main(args: Array<String>) {
    //  minOf 是包级函数
    //  什么是包级函数呢？？？
    val test = minOf(1, 4)

    val lat = Lat.ofDouble(3.0)

    println(Lat.TAG)
}