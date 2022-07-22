package com.zhuangxiaoyan.athena.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.zhuangxiaoyan.athena.member.fegin")
@EnableDiscoveryClient
@SpringBootApplication
public class AthenaMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaMemberApplication.class, args);
    }

}
