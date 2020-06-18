package mkotlin

import kotlin.math.min

/**
 * Date:2018/12/28-16:48
 * @author Mason
 */
fun main(args: Array<String>) {
    println("冒泡1排序结果：")
    val array1 = bubbleSort1()
    for (i in 0..(array1.size - 1)) {
        print("${array1[i]}, ")
    }
    println("\n冒泡2排序结果：")
    val array2 = bubbleSort2()
    for (i in 0..(array2.size - 1)) {
        print("${array2[i]}, ")
    }
    println("\n插入排序结果：")
    val array3 = insertionSort()
    for (i in 0 until array3.size) {
        print("${array3[i]}, ")
    }
    println("\n选择排序结果：")
    val array4 = selectionSort3()
    for (i in 0 until array4.size) {
        print("${array3[i]}, ")
    }
    println("\n希尔排序结果：")
    val array5 = shellSort()
    for (i in 0 until array5.size) {
        print("${array3[i]}, ")
    }
}

/**
 * 冒泡排序1
 */
fun bubbleSort1(): IntArray {
    val array = getArray()
    val len = array.size
    for (i in 0 until len) {
        for (j in 0..(len - 2 - i)) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
    return array
}

/**
 * 冒泡排序2
 */
fun bubbleSort2(): IntArray {
    val array = getArray()
    var temp: Int
    val low = 0
    var high = array.size - 1
    while (low < high) {
        for (i in low..(high - 1)) {
            if (array[i] > array[i + 1]) {
                temp = array[i]
                array[i] = array[i + 1]
                array[i + 1] = temp
            }
        }
        for (j in high..low) {
            if (array[j] < array[j - 1]) {
                temp = array[j]
                array[j] = array[j - 1]
                array[j - 1] = temp
            }
        }
        --high
    }
    return array
}

/**
 * 插入排序
 */
fun insertionSort(): IntArray {
    val array = getArray()
    val len = array.size
    for (i in 1 until len) {
        val key = array[i]
        var j = i - 1
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = key
    }
    return array
}

/**
 * 选择排序
 */
fun selectionSort2(): IntArray {
    val array = getArray()
    val len = array.size
    var minIndex: Int
    var temp: Int
    for (i in 0 until len - 1) {
        minIndex = i
        for (j in i + 1 until len) { // i需要+1
            if (array[j] < array[minIndex]) {
                minIndex = j // 找到了比较小的元素
            }
        }
        if (i != minIndex) {
            temp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = temp
        }

    }
    return array
}

fun selectionSort3(): IntArray {
    val array = getArray()
    val len = array.size
    var minIndex: Int = 0
    var temp: Int
    for (i in 0 until len) {
        for (j in i until len - 1) {
            // 拿到minIndex
            if (array[j] < array[i]) {
                minIndex = j
            }
        }
        // 交换
        if (i != minIndex) {
            temp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = temp

        }
    }
    return array
}

/**
 * 希尔排序
 */
fun shellSort(): IntArray {
    val array = getArray()
    val len = array.size
    var step = 0
    while (step < len / 5) {
        step = step * 5 + 1
    }
    while (step > 0) {
        for (i in step until len) {
            var j = i - step
            val temp = array[i]
            while (j >= 0 && temp < array[j]) {
                array[j + step] = array[j]
                j -= step
            }
            array[j + step] = temp
        }
        step /= 2
    }
    return array
}
//fun mergeSort() : IntArray {
//
//}
/**
 * 获取需要排序的数组
 */
fun getArray(): IntArray {
    return intArrayOf(7, 24, 33, 5, 42, 55, 36, 26, 22, 2, 46, 4, 19, 50, 48, 2)
}