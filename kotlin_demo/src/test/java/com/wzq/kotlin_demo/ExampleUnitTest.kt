package com.wzq.kotlin_demo

import org.jetbrains.annotations.NotNull
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    //kotlin

    @Test
    fun testRun() {
        val user = User("Kotlin", 1, "1111111")

        val result = user.run {
            println("my name is $name, I am $age years old, my phone number is $phoneNum")
            1000
        }
        println("result: $result")
    }


}