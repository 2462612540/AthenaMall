package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.SpuBoundsDao;
import com.zhuangxiaoyan.athena.coupon.entity.SpuBoundsEntity;
import com.zhuangxiaoyan.athena.coupon.service.SpuBoundsService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description SpuBoundsServiceImpl
 * @date: 2022/7/28 16:36
 * @return:
 * @author: xjl
 */

@Service("spuBoundsService")
public class SpuBoundsServiceImpl extends ServiceImpl<SpuBoundsDao, SpuBoundsEntity> implements SpuBoundsService {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:37
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuBoundsEntity> page = this.page(new Query<SpuBoundsEntity>().getPage(params),new QueryWrapper<SpuBoundsEntity>());
        return new PageUtils(page);
    }
}