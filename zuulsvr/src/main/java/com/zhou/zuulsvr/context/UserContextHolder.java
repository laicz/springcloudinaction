/**
 * Date:     2018/7/1523:22
 * AUTHOR:   Administrator
 */
package com.zhou.zuulsvr.context;

import org.springframework.util.Assert;

/**
 * 2018/7/15  23:22
 * created by zhoumb
 */
public class UserContextHolder {
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>();

    public static final UserContext getContext(){
        UserContext context = userContext.get();

        if (context == null) {
            context = createEmptyContext();
            userContext.set(context);

        }
        return userContext.get();
    }

    public static final void setContext(UserContext context) {
        Assert.notNull(context, "Only non-null UserContext instances are permitted");
        userContext.set(context);
    }

    public static final UserContext createEmptyContext(){
        return new UserContext();
    }
}
