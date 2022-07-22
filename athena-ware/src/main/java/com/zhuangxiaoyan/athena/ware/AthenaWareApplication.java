package com.zhuangxiaoyan.athena.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.zhuangxiaoyan.athena.ware.fegin")
@EnableDiscoveryClient
@SpringBootApplication
public class AthenaWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaWareApplication.class, args);
    }

}
