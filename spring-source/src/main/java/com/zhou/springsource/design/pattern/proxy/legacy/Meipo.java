/**
 * Date:     2018/7/2523:21
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy.legacy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 2018/7/25  23:21
 * created by zhoumb
 */
public class Meipo implements InvocationHandler {

    private Person person;

    //获取被代理人的个人资料
    public Object getInstance(Person target) throws Exception {
        this.person = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行了");
//        this.person.findLove();
        method.invoke(this.person, args);
        System.out.println("代理执行完毕");
        return null;
    }
}
