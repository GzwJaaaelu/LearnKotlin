package com.kotlin.`in`.mooc.withJava

//  常见的互操作

//  Kotlin 自动识别 Java 的 getter 和 setter
//  Java 操作 Kotlin 属性通过 getter 和 setter

//  Kotlin 里面有空安全，Java 中并没有，需要开发者自行判断（如注解的方法）

//  函数调用：包级函数 -> 静态方法
//            扩展方法 -> 带 Receiver 的静态方法
//            运算符重载 -> 带有 Receiver 的对应名称的静态方法

//  常见注解：@JvmFiled -> 将属性编译为 Java 变量
//            @JvmStatic -> 将对象的方法编译成 Java 静态方法
//            @JvmOverloads -> 默认参数生成重载方法
//            @file:JvmName -> 指定 Kotlin 文件编译后的类名

//  NoArg 为被标注的类生成无参构造
//  AllOpen 为标注的类去掉 final，允许被继承
//  支持自定义注解类型

//  泛型：通配符在 Kotlin 中是 *，而在 Java 中是 ?
//        协变与逆变 out/in
//        没有 Raw 类型（Java 5 之前的遗留问题），Java 中的 List -> Kotlin 中的 List<*>