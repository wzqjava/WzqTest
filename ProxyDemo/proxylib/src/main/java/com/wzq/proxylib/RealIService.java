package com.wzq.proxylib;

/**
 * <p>作者：wzq<p>
 * <p>创建时间：6/11/21<p>
 * <p>文件描述：<p>
 */
class RealIService implements IService {
    @Override
    public void sayHello() {
        System.out.println("say Hello");
    }
}
