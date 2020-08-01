package mkotlin

/**
 *<p>作者：wzq<p>
 * <p>创建时间：2019-10-03<p>
 * <p>文件描述：<p>
 *
 */
object KotlinDemo {
    var a: Int = 0
    var b: Int = 1

    @JvmStatic
    fun main(args: Array<String>) {
        //        println(add(1, 2))
        //        println(add2(1,2))
        //            testString()
        //        testString2()
        //        testIf()
        //        testFor()
        //        testFor2()
        //        testwhile()
        testwhen()
        //        testIn()
        //        testRange()
        //        testRange2()
        //        testCollection()
        //        testNull()  // 判空的类似三元运算符

        /*if (hasPrefix("prefix")) {
            print("true")
        } else {
            print("true")
        }*/
    }

    private fun testNull() {
        var age: String? = null
        print(age?.toInt() ?: -1)
    }

    private fun testCollection() {
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        //        fruits.filter { it.startsWith("a") }
        //                .forEach((String) -> printlin(it))
    }

    private fun testRange2() {
        //         for (x in 1..10 step 2){
        //             println(x)
        //         }
        for (x in 9 downTo 0 step 3) {
            println(x)
        }

    }

    private fun testRange() {
        val list = listOf("a", "b", "c")
        if (30 !in 0..list.lastIndex) {
            println("下标越界")
        }
        println("${list.size}" + "---" + " ${list.indices}")
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range, too")
        }
    }

    private fun testIn() {
        val x = 10
        val y = 9
        if (x in 1..y + 1) {
            print(x)
        }
    }

    private fun testwhen() {
        var test: Any = "hello"
        var result1 = when (test) {
            1 -> "one"
            "hello" -> "hello"
            is String -> "String"
            !is String -> "not String"
            else -> "unow"
        }
        print(result1)
        println()
        //-----------------------
        val x = 3
        var result2 = when (x) {
            0, 1 -> print("x == 0 or x == 1") // case 多个参数
            else -> print("other wise")
        }
        println()
        var validNumbers = arrayOf(1, 2, 4)
        when (x) {
            in 1..10 -> print("x is in the range")
            in validNumbers -> print("x is valid")
            !in 10..20 -> print("x is outside the range")
            else -> print("none of the above")
        }
        println()
        when {
            x == 3 -> print("x is odd")
            x == 5 -> print("x is even")
            else -> print("x is funny")
        }

        println()
        val items = setOf("apple", "banana", "kiwi")
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }

    }

    fun hasPrefix(x: Any) = when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    private fun testwhile() {
        val items = listOf<String>("aaa", "bbb", "ccc", "ddd")
        var index = 0
        while (index < items.size) {
            println(items[index])
            index++
        }
    }

    private fun testFor() {
        val items = listOf<String>("aaa", "bbb", "ccc", "ddd")
        for (item in items) {
            println(item)
        }
    }

    private fun testFor2() {
        val items = listOf<String>("aaa", "bbb", "ccc", "dd", "dd")
        for (index in items.indices) {
            println("item is:  ${items[index]}")
        }
    }

    private fun testIf() {
        print(maxOf(2, 3))
    }

    fun maxOf(a: Int, b: Int) = if (a > b) a else b

    private fun testString() {
        var a = 1
        val s1 = "a is $a"
        a = 2
        val s2 = "${s1.replace("is", "was")},but now is $a"
        print(s2)
    }

    private fun testString2() {
        var arry = "abcdef"
        print(arry[0])
        println()
        for (c in arry) {
            print(c)
        }
    }

    fun add(a: Int, b: Int) = a + b

    fun add2(a: Int, b: Int) {
        val temp = 3 // 定义只读局部变量使用关键字 val 定义。只能为其赋值一次。

        println("sum of  $a and $b is ${a + b}")
    }

}