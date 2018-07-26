/**
 * Date:     2018/7/2523:20
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy;

/**
 * 2018/7/25  23:20
 * created by zhoumb
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception {
//        new Zhangsan().findLove();
        Person person = (Person) new Meipo().getInstance(new Zhangsan());
        person.findLove();
    }
}
