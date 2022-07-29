package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 配置中心测试服务
 * @param: null
 * @date: 2022/7/28 15:19
 * @return:
 * @author: xjl
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class ConfigTestController {

    @Value("${coupon.user.name}")
    private String name;

    @Value("${coupon.user.age}")
    private Integer age;

    /**
     * @description 提供远程服务调用
     * @param:
     * @date: 2022/7/28 15:20
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/valuetest")
    public Result membercoupons() {
        return Result.ok().put("name", name).put("age", age);
    }

}
