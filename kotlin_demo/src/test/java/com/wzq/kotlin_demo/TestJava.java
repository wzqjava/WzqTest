package com.wzq.kotlin_demo;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

/**
 * <p>作者：王志强<p>
 * <p>创建时间：2020/8/3<p>
 * <p>文件描述：<p>
 */
class TestJava {
    //java
    @Test
    public static final void main(@NotNull String[] args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        tt();
    }

    @Test
    public static  void tt(){
        User user = new User("Kotlin", 1, "1111111");
        String var5 = "my name is "
                + user.getName()
                + ", I am "
                + user.getAge()
                + " years old, my phone number is "
                + user.getPhoneNum();
        System.out.println(var5);
        int result = 1000;
        String var3 = "result: " + result;
        System.out.println(var3);
    }

}
