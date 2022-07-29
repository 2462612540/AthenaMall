package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.HomeAdvDao;
import com.zhuangxiaoyan.athena.coupon.entity.HomeAdvEntity;
import com.zhuangxiaoyan.athena.coupon.service.HomeAdvService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;
/**
 * @description HomeAdvServiceImpl
 * @date: 2022/7/28 16:36
 * @return:
 * @author: xjl
 */
@Service("homeAdvService")
public class HomeAdvServiceImpl extends ServiceImpl<HomeAdvDao, HomeAdvEntity> implements HomeAdvService {

    /**
     * @description 分页查询
     * @param: params
     * @date: 2022/7/28 16:48
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomeAdvEntity> page = this.page(new Query<HomeAdvEntity>().getPage(params),new QueryWrapper<HomeAdvEntity>());
        return new PageUtils(page);
    }
}