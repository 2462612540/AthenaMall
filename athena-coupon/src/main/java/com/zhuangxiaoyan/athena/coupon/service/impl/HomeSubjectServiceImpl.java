package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.HomeSubjectDao;
import com.zhuangxiaoyan.athena.coupon.entity.HomeSubjectEntity;
import com.zhuangxiaoyan.athena.coupon.service.HomeSubjectService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;
/**
 * @description HomeSubjectServiceImpl
 * @date: 2022/7/28 16:36
 * @return:
 * @author: xjl
 */
@Service("homeSubjectService")
public class HomeSubjectServiceImpl extends ServiceImpl<HomeSubjectDao, HomeSubjectEntity> implements HomeSubjectService {

    /**
     * @description 分页查询
     * @param: params
     * @date: 2022/7/28 16:48
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomeSubjectEntity> page = this.page(new Query<HomeSubjectEntity>().getPage(params),new QueryWrapper<HomeSubjectEntity>());
        return new PageUtils(page);
    }
}