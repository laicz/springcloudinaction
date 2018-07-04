package com.zhou.confsvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer//使用enableConfigServer作为配置文件服务器
public class ConfsvrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfsvrApplication.class, args);
	}
}
