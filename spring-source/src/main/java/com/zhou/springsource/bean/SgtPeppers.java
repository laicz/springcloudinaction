/**
 * Date:     2018/8/410:12
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.bean;

import org.springframework.stereotype.Component;

/**
 * 2018/8/4  10:12
 * created by zhoumb
 */
@Component(value = "lonelyHeaderCloud")
public class SgtPeppers implements CompactDisc {
    private String str = " this is SgtPeppers";

    @Override
    public void play() {
        System.out.println(str);
    }
}
