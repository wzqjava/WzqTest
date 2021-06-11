package com.wzq.proxylib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>作者：wzq<p>
 * <p>创建时间：6/11/21<p>
 * <p>文件描述：<p>
 */
class MInvocationHandler implements InvocationHandler {
    IService realService;
    public MInvocationHandler(IService realService) {
        this.realService = realService;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("start -log");
        method.invoke(realService, objects);     // 调用真实对象
        System.out.println("end -log");
        return o;
    }
}
