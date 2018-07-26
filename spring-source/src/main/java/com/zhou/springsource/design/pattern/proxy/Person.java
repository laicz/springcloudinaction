/**
 * Date:     2018/7/2523:14
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy;

/**
 * 代理模式（关注过程）
 * 1、执行者，被代理人
 * 2、对于被代理人来说，这件事必须是要做的
 * 3、执行者需要获取到被代理人的资料
 * 2018/7/25  23:14
 * created by zhoumb
 */
public interface Person {

    //寻找真爱
    void findLove();
}
