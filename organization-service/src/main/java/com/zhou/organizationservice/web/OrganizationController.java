/**
 * Date:     2018/7/1516:05
 * AUTHOR:   Administrator
 */
package com.zhou.organizationservice.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 2018/7/15  16:05
 * created by zhoumb
 */
@RestController
@RequestMapping(value = "/open")
public class OrganizationController {

    @RequestMapping(value = "/ping")
    public String ping() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "Hello World ! organization";
    }
}
