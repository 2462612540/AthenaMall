package com.zhuangxiaoyan.athena.product.fegin;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description TODO
 * @param: null
 * @date: 2022/10/8 16:23
 * @return:
 * @author: xjl
 */

@FeignClient(value = "athena-secondskill")
public interface SeckillFeignService {

    /**
     * @description 根据skuId查询商品是否参加秒杀活动
     * @param: skuId
     * @date: 2022/10/8 16:28
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @GetMapping(value = "/sku/seckill/{skuId}")
    Result getSkuSeckilInfo(@PathVariable("skuId") Long skuId);

}
