package com.wzq.kotlin_demo

import org.jetbrains.annotations.NotNull

/**
 *<p>作者：王志强<p>
 * <p>创建时间：2020/8/3<p>
 * <p>文件描述：<p>
 *
 */
class TestRun {

    //kotlin

    fun main(args: Array<String>) {
        val user = User("Kotlin", 1, "1111111")

        val result = user.run {
            println("my name is $name, I am $age years old, my phone number is $phoneNum")
            1000
        }
        println("result: $result")
    }





}