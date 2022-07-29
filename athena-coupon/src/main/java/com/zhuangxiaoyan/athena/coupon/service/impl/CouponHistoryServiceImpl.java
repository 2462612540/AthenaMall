package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.CouponHistoryDao;
import com.zhuangxiaoyan.athena.coupon.entity.CouponHistoryEntity;
import com.zhuangxiaoyan.athena.coupon.service.CouponHistoryService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description CouponHistoryServiceImpl
 * @date: 2022/7/28 16:36
 * @return:
 * @author: xjl
*/

@Service("couponHistoryService")
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryDao, CouponHistoryEntity> implements CouponHistoryService {
    /**
     * @description 分页查询
      * @param: params
     * @date: 2022/7/28 16:47
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CouponHistoryEntity> page = this.page(new Query<CouponHistoryEntity>().getPage(params),new QueryWrapper<CouponHistoryEntity>());
        return new PageUtils(page);
    }
}