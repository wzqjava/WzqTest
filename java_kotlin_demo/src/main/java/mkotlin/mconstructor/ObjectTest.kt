package mkotlin.mconstructor

/**
 *<p>作者：王志强<p>
 * <p>创建时间：2020/6/19<p>
 * <p>文件描述：<p>
 *
 */
class ObjectTest {
    var v = "成员属性"

    fun setInterFace(test: TestInterFace) {
        test.test()
    }
}

/**
 * 定义接口
 */
interface TestInterFace {
    fun test()
}

fun main(args: Array<String>) {
    var test = ObjectTest()
    /**
     * 采用对象表达式来创建接口对象，即匿名内部类的实例。
     */
    test.setInterFace(object : TestInterFace {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
}