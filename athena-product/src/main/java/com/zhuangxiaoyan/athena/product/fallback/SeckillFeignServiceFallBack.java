package com.zhuangxiaoyan.athena.product.fallback;

import com.zhuangxiaoyan.athena.product.constant.ErrorCode;
import com.zhuangxiaoyan.athena.product.fegin.SeckillFeignService;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.stereotype.Component;

/**
 * @description TODO
  * @param: null
 * @date: 2022/10/9 9:32
 * @return:
 * @author: xjl
*/

@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {

    @Override
    public Result getSkuSeckilInfo(Long skuId) {
        return Result.error(ErrorCode.TO_MANY_REQUEST.getCode(),ErrorCode.TO_MANY_REQUEST.getMessage());
    }
}
