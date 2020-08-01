package mkotlin

/**
 *<p>作者：王志强<p>
 * <p>创建时间：2020/6/18<p>
 * <p>文件描述：<p>
 *
 */
object KotlinLoopDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        //        testFor()
        //        testDoWhile()
        //        testBreak()
        testLabel()
    }

    private fun testLabel() {
        loop@ for (i in 1..5) {
            print("i--$i")
            println()
            for (j in 1..100) {
                if (j == 4) break@loop
                print("j--$j")
            }
        }
    }

    private fun testBreak() {
        for (i in 1..10) {
            if (i == 3) continue  // i 为 3 时跳过当前循环，继续下一次循环
            println(i)
            if (i > 5) break   // i 为 6 时 跳出循环
        }
    }

    private fun testDoWhile() {
        println("----while 使用-----")
        var x = 5
        while (x > 0) {
            println(x--)
        }
        println("----do...while 使用-----")
        var y = 5
        do {
            println(y--)
        } while (y > 0)
    }

    private fun testFor() {
        val items = listOf("apple", "banana", "kiwi")
        for (item in items) {
            println(item)
        }

        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }

        for ((index, value) in items.withIndex()) {
            println("the element at $index is $value")
        }
    }
}
