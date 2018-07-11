/**
 * Date:     2018/7/1123:03
 * AUTHOR:   Administrator
 */
package com.zhou.licensingservice.client;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * 类级别的hystrix配置属性
 * 2018/7/11  23:03
 * created by zhoumb
 */
@DefaultProperties(commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
})
public class HystrixPropertyService {
}
