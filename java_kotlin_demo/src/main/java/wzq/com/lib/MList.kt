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
        //��һ�ֱ�������ʹ��foreach����List
        for (str in list) {            //Ҳ���Ը�дfor(int i=0;i<list.size();i++)������ʽ
            println(str)
        }

        //�ڶ��ֱ������������Ϊ������ص����ݽ��б���
        val strArray = arrayOfNulls<String>(list.size)
        list.toTypedArray()
        for (i in strArray.indices)
        //����Ҳ���Ը�дΪ  foreach(String str:strArray)������ʽ
        {
            println(strArray[i])
        }

        //�����ֱ��� ʹ�õ�����������ر���

        val ite = list.iterator()
        while (ite.hasNext())
        //�ж���һ��Ԫ��֮����ֵ
        {
            println(ite.next())
        }
    }
}
