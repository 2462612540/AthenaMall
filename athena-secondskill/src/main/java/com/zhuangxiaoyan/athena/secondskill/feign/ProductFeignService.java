package com.zhuangxiaoyan.athena.secondskill.feign;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description TODO 
  * @param: null
 * @date: 2022/10/7 17:23
 * @return: 
 * @author: xjl
*/

@FeignClient("athena-product")
public interface ProductFeignService {

    @RequestMapping("/product/skuinfo/info/{skuId}")
    Result getSkuInfo(@PathVariable("skuId") Long skuId);

}
