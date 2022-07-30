package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.SeckillSkuRelationDao;
import com.zhuangxiaoyan.athena.coupon.entity.SeckillSkuRelationEntity;
import com.zhuangxiaoyan.athena.coupon.service.SeckillSkuRelationService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description SeckillSkuRelationServiceImpl
 * @date: 2022/7/28 16:36
 * @author: xjl
 */

@Service("seckillSkuRelationService")
public class SeckillSkuRelationServiceImpl extends ServiceImpl<SeckillSkuRelationDao, SeckillSkuRelationEntity> implements SeckillSkuRelationService {

    /**
     * @description 分页查询
      * @param: params
     * @date: 2022/7/28 16:40
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeckillSkuRelationEntity> page = this.page(new Query<SeckillSkuRelationEntity>().getPage(params),new QueryWrapper<SeckillSkuRelationEntity>());
        return new PageUtils(page);
    }
}