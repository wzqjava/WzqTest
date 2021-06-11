package com.wzq.proxylib;

import java.lang.reflect.Proxy;

/**
 * <p>作者：wzq<p>
 * <p>创建时间：6/11/21<p>
 * <p>文件描述：<p>
 */
class Test {

    public static void main(String[] args) {
        IService realService = new RealIService(); // 真实对象

        IService proxyService = (IService)Proxy.newProxyInstance(  // 代理对象
                realService.getClass().getClassLoader(),
                new Class[]{IService.class},
                new MInvocationHandler(realService)  // 传入真实对象
        );

        proxyService.sayHello();  // 代理调用

    }
}
