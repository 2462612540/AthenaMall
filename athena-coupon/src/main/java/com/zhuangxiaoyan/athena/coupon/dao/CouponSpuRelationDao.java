package com.zhuangxiaoyan.athena.coupon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.coupon.entity.CouponSpuRelationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 优惠券与产品关联
 * @date: 2022/7/28 16:03
 * @author: xjl
 */

@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {

}