package com.kotlin.`in`.mooc.classAbout.abstract

//  接口顾名思义就是一种约定
//  接口表示你的能力

interface InputDevice {
    fun input(event: Any)
}

interface USBInputDevice : InputDevice

interface BLEInputDevice : InputDevice

//  抽象类相当于半成品

abstract class USBMouse(val name:String) : USBInputDevice {

    //  override 表示重写
    override fun input(event: Any) {

    }

    override fun toString(): String {
        return "USBMouse '$name'"
    }
}

//  这才是成品

class LogitechMouse : USBMouse("罗技鼠标") {

}

class Computer {

    fun addUSBInputDevice(inputDevice: USBInputDevice) {
        println("Add USE Input Device: $inputDevice")
    }

    private fun addBLEInputDevice(inputDevice: BLEInputDevice) {
        println("Add BLE Input Device: $inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice) {
        when (inputDevice) {
            is BLEInputDevice -> addBLEInputDevice(inputDevice)
            is USBInputDevice -> addUSBInputDevice(inputDevice)
            else -> {
                throw IllegalArgumentException("输入设备类型不支持...")
            }
        }
    }
}

fun main(args: Array<String>) {
    val computer = Computer()
    computer.addUSBInputDevice(LogitechMouse())
}

