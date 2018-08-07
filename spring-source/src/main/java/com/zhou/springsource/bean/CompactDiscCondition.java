/**
 * Date:     2018/8/721:32
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.bean;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 使用@Conditional注解使用@Bean注解的方法
 * 会在实现Condition的类中，方法matches返回true才会返回正确的值，该@Bean注解的方法才会返回值
 * 2018/8/7  21:32
 * created by zhoumb
 */
public class CompactDiscCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.containsProperty("magic");
    }
}
