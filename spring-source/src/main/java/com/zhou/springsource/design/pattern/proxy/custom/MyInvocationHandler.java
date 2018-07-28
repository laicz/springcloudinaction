/**
 * Date:     2018/7/2623:05
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy.custom;

import java.lang.reflect.Method;

/**
 * 写自己的invocationHandler
 * 2018/7/26  23:05
 * created by zhoumb
 */
public interface MyInvocationHandler {
    /**
     * @param proxy  代理类
     * @param method 代理方法
     * @param args   参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
