package com.kotlin.`in`.mooc.someNew

//  密封类是子类有限的类
//  与枚举有些类似，一个是实例可数，一个是子类可数
//  使用场景有什么区别呢？
//  枚举实例是有限的，但是 PlayCmd 中，Play、Seek 是类，所以这两个其实可以有多到无限个实例

//  播放器指令
sealed class PlayerCmd {

    //  子类有限是如何实现的呢？
    //  1.1 之前，之类只能定义在类内部
    //  1.1 开始放宽了限制，可以定义在同一个文件当中

    class Play(url: String, val position: Long = 0) : PlayerCmd()

    class Seek(val position: Long) : PlayerCmd()

    object Pause : PlayerCmd()

    object Resume : PlayerCmd()

    object Stop : PlayerCmd()

}


class Other() : PlayerCmd()

//  所以这里可以看出，表示状态的用枚举比较合适
//  表示指令可以选择密封类
enum class Play{
    IDLE,
    PAUSE,
    PLAYING
}