package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.CouponSpuCategoryRelationDao;
import com.zhuangxiaoyan.athena.coupon.entity.CouponSpuCategoryRelationEntity;
import com.zhuangxiaoyan.athena.coupon.service.CouponSpuCategoryRelationService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;
/**
 * @description CouponSpuCategoryRelationServiceImpl
 * @date: 2022/7/28 16:36
 * @return:
 * @author: xjl
 */
@Service("couponSpuCategoryRelationService")
public class CouponSpuCategoryRelationServiceImpl extends ServiceImpl<CouponSpuCategoryRelationDao, CouponSpuCategoryRelationEntity> implements CouponSpuCategoryRelationService {

    /**
     * @description 分页查询
      * @param: params
     * @date: 2022/7/28 16:47
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CouponSpuCategoryRelationEntity> page = this.page(new Query<CouponSpuCategoryRelationEntity>().getPage(params),new QueryWrapper<CouponSpuCategoryRelationEntity>());
        return new PageUtils(page);
    }
}