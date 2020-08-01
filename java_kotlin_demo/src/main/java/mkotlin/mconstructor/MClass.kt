package mkotlin.mconstructor

/**
 *<p>作者：王志强<p>
 * <p>创建时间：2020/6/19<p>
 * <p>文件描述：<p>
 *主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
 */
class MClass constructor(name: String) {  // 类名为 Runoob
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

// 测试
object test{
    @JvmStatic
    fun main(args: Array<String>) {
        val runoob = MClass("菜鸟教程")
        println(runoob.siteName)
        println(runoob.url)
        println(runoob.country)
        runoob.printTest()
    }
}