package wzq.com.lib;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * author:Created by WangZhiQiang on 2019/5/31.
 */
public class MList循环移动 {

    public static void main(String[] args) {
        //快速创建集合的方法;
        List list = Arrays.asList("one Two three Four five six".split(" "));
        System.out.println("List :"+list);
        Collections.rotate(list, 3);
        System.out.println("rotate: " + list);
    }
}
