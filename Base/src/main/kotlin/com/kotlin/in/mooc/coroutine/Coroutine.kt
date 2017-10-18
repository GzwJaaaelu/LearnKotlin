package com.kotlin.`in`.mooc.coroutine

//  协程，协作程序，解决异步问题（应用层完成调度），Java 中的线程是系统层的，所以协程不存在资源抢占竞争（非抢占式）

//  协程不会堵塞，只是挂起，记着呢

//  解决的问题：异步代码像同步代码一样直观，简化异步代码异常处理而且是轻量级的。

//  Kotlin 中从 1.1 开始支持

//  如何支持协程 1.suspend 函数、2.标准库 API、3.Kotlinx.coroutine

//  协程被编译成状态机
//  suspend 函数即状态转移
//  开始 -> 状态机（循环，循环次数有 suspend 函数个数决定）-> 结束

//  正常的结果通过 resume 返回
//  异常通过 resumeWithException 抛出