package com.zhuangxiaoyan.athena.member.fegin;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @description TODO
 * @param: null
 * @date: 2022/10/5 21:27
 * @return:
 * @author: xjl
 */

@FeignClient("athena-order")
public interface OrderFeignService {

    /**
     * 分页查询当前登录用户的所有订单信息
     *
     * @param params
     * @return
     */
    @PostMapping("/order/order/listWithItem")
    Result listWithItem(@RequestBody Map<String, Object> params);

}
