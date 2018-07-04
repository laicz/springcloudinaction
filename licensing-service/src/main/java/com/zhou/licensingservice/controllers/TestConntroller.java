/**
 * Date:     2018/7/422:56
 * AUTHOR:   Administrator
 */
package com.zhou.licensingservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/7/4  22:56
 * created by zhoumb
 */
@RestController
@RequestMapping(value = "/test")
public class TestConntroller {

    @GetMapping(value = "/ping")
    public String ping(){
        return "pong";
    }
}
