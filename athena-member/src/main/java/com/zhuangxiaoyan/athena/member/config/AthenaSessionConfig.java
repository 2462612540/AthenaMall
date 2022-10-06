package com.zhuangxiaoyan.athena.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @Description:    springSession配置类
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-06-29 13:36
 **/

@Configuration
public class AthenaSessionConfig {

    /**
     * @description 解决子域与父域session共享问题
      * @param:
     * @date: 2022/8/25 9:05
     * @return: org.springframework.session.web.http.CookieSerializer
     * @author: xjl
    */
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        //放大作用域
        cookieSerializer.setDomainName("athena.com");
        cookieSerializer.setCookieName("ATHENASESSION");
        return cookieSerializer;
    }


    /**
     * @description 自定义的redis的序列化
      * @param:
     * @date: 2022/8/25 9:05
     * @return: org.springframework.data.redis.serializer.RedisSerializer<java.lang.Object>
     * @author: xjl
    */
    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }
}
