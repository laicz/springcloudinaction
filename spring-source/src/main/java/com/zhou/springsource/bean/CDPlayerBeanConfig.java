/**
 * Date:     2018/8/416:23
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2018/8/4  16:23
 * created by zhoumb
 */
@Configuration  //使用configuration注解，表明这个类是一个配置类
public class CDPlayerBeanConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    /**
     * 也可以根据条件返回加载的Bean
     */
    @Bean
    public CompactDisc randomBeatlesCD() {
        int choice = (int) Math.floor(Math.random() * 4);
        if (choice == 0) {
            return new SgtPeppers();
        } else if (choice == 1) {
            return new IpodPeppers();
        }
        return null;
    }
}
