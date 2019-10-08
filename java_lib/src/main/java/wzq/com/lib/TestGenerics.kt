package wzq.com.lib

import jdk.nashorn.internal.objects.Global.print

/**
 *<p>作者：wzq<p>
 * <p>创建时间：2019-10-03<p>
 * <p>文件描述：<p>
 *
 */

class Test {


    fun main(args: Array<String>) {
        out("findingsea", 123, 11.11, true);
    }

    fun <T> out(vararg args: T) {
        for (t in args) {
            print(t)

        }
    }


}