package mkotlin

/**
 *<p>作者：王志强<p>
 * <p>创建时间：2020/6/18<p>
 * <p>文件描述：<p>
 *
 */
object Test_i {
    @JvmStatic
    fun main(args: Array<String>) {
        test1()
        test2()
        test3()

    }

    // ++代表是给表达式赋值, 看++所在的位置即可
    private fun test1() {
        var i = 0
        println("i++_______" + i++) // 0 :先赋值表达式输出--再自增
        println(i)
    }

    private fun test2() {
        var i = 0
        println("++i_______" + (++i)) // 1:i自增后再赋值表达式
        println(i)
    }

    private fun test3() {
        var i = 0
        println("--i_______" + (--i)) // 1:i自增后再赋值表达式
        println(i)
    }
}