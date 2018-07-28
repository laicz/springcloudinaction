/**
 * Date:     2018/7/2623:11
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy.custom;

import com.zhou.springsource.design.pattern.proxy.legacy.Person;

import java.lang.reflect.Method;

/**
 * 2018/7/26  23:11
 * created by zhoumb
 */
public class MyMeipo implements MyInvocationHandler {

    private Person target;

    public Object getInstance(Person person) {
        this.target = person;
        Class clazz = target.getClass();
        System.out.println("被代理对象的class是：" + clazz);
        return MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行了");
//        this.person.findLove();
        method.invoke(this.target, args);
        System.out.println("代理执行完毕");
        return null;
    }
}
