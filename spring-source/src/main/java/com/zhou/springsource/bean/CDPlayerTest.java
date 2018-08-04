/**
 * Date:     2018/8/410:17
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 2018/8/4  10:17
 * created by zhoumb
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  CDPlayersConfig.class)
public class CDPlayerTest {

    @Autowired
    @Qualifier(value = "ipod")
    private CompactDisc compactDisc;

    @Autowired
    Cottage cottage;

    @Test
    public void cdShouldNotNUll(){
        System.out.println(compactDisc);
        compactDisc.play();
        cottage.sing();
        cottage.sing2();

    }
}
