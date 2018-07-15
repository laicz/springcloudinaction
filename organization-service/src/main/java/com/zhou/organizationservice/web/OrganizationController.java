/**
 * Date:     2018/7/1516:05
 * AUTHOR:   Administrator
 */
package com.zhou.organizationservice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * 2018/7/15  16:05
 * created by zhoumb
 */
@RestController
@RequestMapping(value = "/open")
public class OrganizationController {

    private static final Logger logger = LoggerFactory.getLogger(OrganizationController.class);

    @RequestMapping(value = "/ping")
    public String ping(HttpServletRequest request) throws InterruptedException {
        String header = request.getHeader("tmx-correlation-id");
        logger.info("tmx-correlation-id:{}", header);
        return "Hello World ! organization";
    }
}
