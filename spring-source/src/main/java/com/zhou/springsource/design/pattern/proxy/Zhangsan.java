/**
 * Date:     2018/7/2523:17
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy;

/**
 * 2018/7/25  23:17
 * created by zhoumb
 */
public class Zhangsan implements Person {
    private String sex = "男";
    private String name = "张三";

    @Override
    public void findLove() {
        System.out.println("我是" + this.name + ",正在寻找真爱");
        System.out.println("漂亮的");
        System.out.println("白富美");
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
