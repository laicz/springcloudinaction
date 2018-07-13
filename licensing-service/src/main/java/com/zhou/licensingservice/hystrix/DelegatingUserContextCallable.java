/**
 * Date:     2018/7/1323:33
 * AUTHOR:   Administrator
 */
package com.zhou.licensingservice.hystrix;

import com.zhou.licensingservice.utils.UserContext;
import com.zhou.licensingservice.utils.UserContextHolder;

import java.util.concurrent.Callable;

/**
 * 2018/7/13  23:33
 * created by zhoumb
 */
public final class DelegatingUserContextCallable<V> implements Callable<V> {
    private final Callable<V> delegate;
    private UserContext originalUserContext;

    public DelegatingUserContextCallable(Callable<V> delegate, UserContext originalUserContext) {
        this.delegate = delegate;
        this.originalUserContext = originalUserContext;
    }

    @Override
    public V call() throws Exception {
        UserContextHolder.setContext(originalUserContext);
        try {
            return delegate.call();
        } finally {
            this.originalUserContext = null;
        }
    }

    public static <V> Callable<V> create(Callable<V> delegate, UserContext userContext) {
        return new DelegatingUserContextCallable<V>(delegate, userContext);
    }
}
