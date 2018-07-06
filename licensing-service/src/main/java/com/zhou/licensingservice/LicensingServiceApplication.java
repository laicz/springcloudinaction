package com.zhou.licensingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * spring boot 引导类 ，可以用于启动和初始化应用程序
 */
/*
注解SpringBootApplcation 的作用：定义引导类，同时也将会扫描此注解下的包的注解类
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LicensingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicensingServiceApplication.class, args);
    }
}
