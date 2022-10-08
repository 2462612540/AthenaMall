package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.SeckillSessionEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description 秒杀活动场次
 * @date: 2022/7/28 16:33
 * @author: xjl
*/
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:33
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description 获取最近三天的上架的商品
      * @param:
     * @date: 2022/10/7 19:59
     * @return: java.util.List<com.zhuangxiaoyan.athena.coupon.entity.SeckillSessionEntity>
     * @author: xjl
    */
    List<SeckillSessionEntity> getLates3DaySession();
}

