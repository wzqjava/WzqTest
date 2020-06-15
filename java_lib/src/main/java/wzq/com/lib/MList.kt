package wzq.com.lib

import java.util.*

/**
 * author:Created by WangZhiQiang on 2019/5/31.
 */
object MList {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = ArrayList<String>()
        list.add("Hello")
        list.add("World")
        list.add("HAHAHAHA")
        //第一种遍历方法使用foreach遍历List
        for (str in list) {            //也可以改写for(int i=0;i<list.size();i++)这种形式
            println(str)
        }

        //第二种遍历，把链表变为数组相关的内容进行遍历
        val strArray = arrayOfNulls<String>(list.size)
        list.toTypedArray()
        for (i in strArray.indices)
        //这里也可以改写为  foreach(String str:strArray)这种形式
        {
            println(strArray[i])
        }

        //第三种遍历 使用迭代器进行相关遍历

        val ite = list.iterator()
        while (ite.hasNext())
        //判断下一个元素之后有值
        {
            println(ite.next())
        }
    }
}
