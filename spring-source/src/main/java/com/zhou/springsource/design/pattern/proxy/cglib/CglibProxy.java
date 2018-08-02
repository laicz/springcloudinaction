/**
 * Date:     2018/7/3123:09
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 同样是做字节码重组，
 * 对于api的用户来说，是无感知的
 * 代理对象实现一个方法拦截器
 * 2018/7/31  23:09
 * created by zhoumb
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}
