/**
 * Date:     2018/7/1123:23
 * AUTHOR:   Administrator
 */
package com.zhou.licensingservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * 2018/7/11  23:23
 * created by zhoumb
 */
public class UserContextHolder {
    private static final Logger logger = LoggerFactory.getLogger(UserContextHolder.class);
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    public static final UserContext getContext() {
        UserContext context = userContext.get();
        if (context == null) {
            context = createEmptyContext();
            userContext.set(context);
        }
        return userContext.get();
    }

    public static final void setContext(UserContext context) {
        Assert.notNull(context, "only non-null userContext instance are permitted");
        userContext.set(context);
    }

    private static final UserContext createEmptyContext() {
        return new UserContext();
    }
}
