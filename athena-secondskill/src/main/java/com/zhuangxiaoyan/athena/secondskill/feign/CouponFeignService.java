package com.zhuangxiaoyan.athena.secondskill.feign;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description TODO 
  * @param: null
 * @date: 2022/10/7 19:49
 * @return: 
 * @author: xjl
*/

@FeignClient("athena-coupon")
public interface CouponFeignService {

    /**
     * 查询最近三天需要参加秒杀商品的信息
     * @return
     */
    @GetMapping(value = "/coupon/seckillsession/Lates3DaySession")
    Result getLates3DaySession();

}
