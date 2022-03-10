package com.zhuangxiaoyan.athena.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zhuangxiaoyan.athena.member.dao")
@SpringBootApplication
public class AthenaMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaMemberApplication.class, args);
    }

}
