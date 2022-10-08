package com.zhuangxiaoyan.athena.secondskill.service;

import com.zhuangxiaoyan.athena.secondskill.to.SeckillSkuRedisTo;

import java.util.List;

/**
 * @description TODO 
  * @param: null
 * @date: 2022/10/7 17:22
 * @return: 
 * @author: xjl
*/
public interface SeckillService {

    /**
     * @description 上架三天需要秒杀的商品
      * @param:
     * @date: 2022/10/8 15:18
     * @return: void
     * @author: xjl
    */
    void uploadSeckillSkuLatest3Days();
    /**
     * @description 获取当前的商品
      * @param:
     * @date: 2022/10/8 15:17
     * @return: java.util.List<com.zhuangxiaoyan.athena.secondskill.to.SeckillSkuRedisTo>
     * @author: xjl
    */
    List<SeckillSkuRedisTo> getCurrentSeckillSkus();

    /**
     * @description 根据skuId查询商品是否参加秒杀活动
      * @param: skuId
     * @date: 2022/10/8 15:18
     * @return: com.zhuangxiaoyan.athena.secondskill.to.SeckillSkuRedisTo
     * @author: xjl
    */
    SeckillSkuRedisTo getSkuSeckilInfo(Long skuId);

    /**
     * @description 当前商品进行秒杀（秒杀开始）
      * @param: killId
     * @param: key
     * @param: num
     * @date: 2022/10/8 15:18
     * @return: java.lang.String
     * @author: xjl
    */
    String kill(String killId, String key, Integer num) throws InterruptedException;
}
