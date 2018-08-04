/**
 * Date:     2018/8/410:54
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.bean;

import org.springframework.stereotype.Component;

/**
 * 2018/8/4  10:54
 * created by zhoumb
 */
@Component(value = "ipod")
public class IpodPeppers implements CompactDisc {
    private String str = " this is ipod ";

    @Override
    public void play() {
        System.out.println(str);
    }
}
