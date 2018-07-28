/**
 * Date:     2018/7/2623:12
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy.custom;

import com.zhou.springsource.design.pattern.proxy.legacy.Person;
import com.zhou.springsource.design.pattern.proxy.legacy.Zhangsan;

/**
 * 2018/7/26  23:12
 * created by zhoumb
 */
public class TestFindLove {

    public static void main(String[] args) throws Throwable {

        Person person = (Person) new MyMeipo().getInstance(new Zhangsan());
        person.findLove();
    }
}
