package com.zhou.zuulsvr;

import com.zhou.zuulsvr.context.UserContextInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * zuul启动类
 */
@EnableZuulProxy//启动zuul代理
@SpringBootApplication
public class ZuulServerApplication {

    /**
     * 将UserContextInterceptor放入RestTemplate
     *
     * @return
     */
    @LoadBalanced//使用loadBalance注解表名这个RestTemplate能够使用Ribbon
    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (interceptors == null) {
            restTemplate.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        } else {
            interceptors.add(new UserContextInterceptor());
            restTemplate.setInterceptors(interceptors);
        }
        return restTemplate;
    }


    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }
}
