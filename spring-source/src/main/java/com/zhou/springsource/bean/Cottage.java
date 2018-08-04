/**
 * Date:     2018/8/416:06
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 2018/8/4  16:06
 * created by zhoumb
 */
@Component
public class Cottage {

    @Autowired
    @Qualifier(value = "ipod")
    private CompactDisc compactDisc;

    private CompactDisc lonely;

    @Autowired()
    @Qualifier(value = "lonelyHeaderCloud")
    public void sing(CompactDisc compactDisc) {
        this.lonely = compactDisc;
    }

    public void sing() {
        System.out.println(compactDisc);
        compactDisc.play();
    }

    public void sing2() {
        System.out.println(lonely);
        lonely.play();
    }
}
