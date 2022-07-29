package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.MemberPriceDao;
import com.zhuangxiaoyan.athena.coupon.entity.MemberPriceEntity;
import com.zhuangxiaoyan.athena.coupon.service.MemberPriceService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description MemberPriceServiceImpl
 * @date: 2022/7/28 16:36
 * @return:
 * @author: xjl
 */

@Service("memberPriceService")
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceDao, MemberPriceEntity> implements MemberPriceService {

    /**
     * @description 分页查询
     * @param: params
     * @date: 2022/7/28 16:48
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberPriceEntity> page = this.page(new Query<MemberPriceEntity>().getPage(params),new QueryWrapper<MemberPriceEntity>());
        return new PageUtils(page);
    }
}