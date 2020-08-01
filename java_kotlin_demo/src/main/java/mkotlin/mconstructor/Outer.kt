package mkotlin.mconstructor

/**
 *<p>作者：王志强<p>
 * <p>创建时间：2020/6/19<p>
 * <p>文件描述：<p>
 *
 */
class Outer {                  // 外部类
    private val bar: Int = 1
    class Nested {             // 嵌套类
        fun foo() = 2
    }
}

fun main(args: Array<String>) {
    val demo = Outer.Nested().foo() // 调用格式：外部类.嵌套类.嵌套类方法/属性
    println(demo)    // == 2
}