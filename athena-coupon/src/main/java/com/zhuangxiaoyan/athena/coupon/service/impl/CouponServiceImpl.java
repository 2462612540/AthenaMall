package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.CouponDao;
import com.zhuangxiaoyan.athena.coupon.entity.CouponEntity;
import com.zhuangxiaoyan.athena.coupon.service.CouponService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;
/**
 * @description CouponServiceImpl
 * @date: 2022/7/28 16:36
 * @return:
 * @author: xjl
 */
@Service("couponService")
public class CouponServiceImpl extends ServiceImpl<CouponDao, CouponEntity> implements CouponService {

    /**
     * @description 分页查询
      * @param: params
     * @date: 2022/7/28 16:46
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CouponEntity> page = this.page(new Query<CouponEntity>().getPage(params),new QueryWrapper<CouponEntity>());
        return new PageUtils(page);
    }
}