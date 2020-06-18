package mkotlin

/**
 *<p>作者：wzq<p>
 * <p>创建时间：2019-10-03<p>
 * <p>文件描述：<p>
 *
 */

object kotlinDemo {
    var a: Int = 0
    var b: Int = 1
    @JvmStatic
    fun main(args: Array<String>) {
//        println(add(1, 2))
//        println(add2(1,2))
//            testString()
//        testIf()
//        testFor()
//        testFor2()
//        testwhile()
//        print(testwhen("hello"))
//        testIn()
//        testRange()
//        testRange2()
        testCollection()
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
        for (x in 9 downTo 0 step 3){
            println(x)
        }

    }

    private fun testRange() {
        val list = listOf("a", "b", "c")
        if (30 !in 0..list.lastIndex){
            println("下标越界")
        }
            println("${list.size }" +"---"+ " ${list.indices}")
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range, too")
        }
    }

    private fun testIn() {
        val x = 10
        val y = 9
        if (x in 1..y+1) {
            print(x)
        }
    }

    private fun testwhen(obj: Any): String {
        when (obj) {
            1 -> return "one"
            "hello" -> return "hello"
            is String -> return "String"
            !is String -> return "not String"
            else -> return "unow"
        }

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

    fun add(a: Int, b: Int) = a + b

    fun add2(a: Int, b: Int) {
        val temp = 3 // 定义只读局部变量使用关键字 val 定义。只能为其赋值一次。

        println("sum of  $a and $b is ${a + b}")
    }


}