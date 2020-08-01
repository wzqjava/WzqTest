package mkotlin

/**
 *<p>作者：王志强<p>
 * <p>创建时间：2020/6/15<p>
 * <p>文件描述：<p>
 *https://www.jianshu.com/p/d990abd376e4
 */
fun main(args: Array<String>) {
    print("--------0 until 10--------------")
    for (i in 0 until 10) { // 开区间
        print("$i-")
    }
    println()
    print("---------0..10-------------")
    for (i in 0..10) { // 闭区间 11个数字
        print("$i-")
    }

    println()
    print("---------10 downTo 0-------------")
    for (i in 10 downTo 0) { // 闭区间,11个数字
        print("$i-")
    }

    println()
    print("-----------10 step 2-----------")
    for (i in 0..10 step 2) { // 闭区间, 包括10
        print("$i-")
    }

    println()
    print("----------要元素-----------")
    val abc = listOf("a", "b", "c")
    for (i in abc) { // 闭区间, 包括10
        print(i)
    }


    println()
    print("----------要下标-----------")
    for (index in abc.indices) { // 闭区间, 包括10
        print(index)
    }


    println()
    print("----------元素+下标-----------")
    for ((index, value) in abc.withIndex()) { // 闭区间, 包括10
        print("$index:$value ")
    }

}
