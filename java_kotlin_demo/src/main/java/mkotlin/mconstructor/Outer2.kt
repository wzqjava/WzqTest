package mkotlin.mconstructor

/**
 *<p>作者：王志强<p>
 * <p>创建时间：2020/6/19<p>
 * <p>文件描述：<p>
 *
 */
class Outer2 {
    private val bar: Int = 1
    var v = "成员属性"

    /**嵌套内部类**/
    inner class Inner {
        fun foo() = bar  // 访问外部类成员
        fun innerTest() {
            var o = this@Outer2 //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }
}

fun main(args: Array<String>) {
    val demo = Outer2().Inner().foo()
    println(demo) //   1
    val demo2 = Outer2().Inner().innerTest()
    println(demo2)   // 内部类可以引用外部类的成员，例如：成员属性
}