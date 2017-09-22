package com.kotlin.`in`.action.base.testPackage

import com.kotlin.`in`.action.base.Rectangle
import java.util.*

fun createRandomRect(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(3), random.nextInt(3))
}