package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.HomeSubjectSpuDao;
import com.zhuangxiaoyan.athena.coupon.entity.HomeSubjectSpuEntity;
import com.zhuangxiaoyan.athena.coupon.service.HomeSubjectSpuService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;
/**
 * @description HomeSubjectSpuServiceImpl
 * @date: 2022/7/28 16:36
 * @return:
 * @author: xjl
 */
@Service("homeSubjectSpuService")
public class HomeSubjectSpuServiceImpl extends ServiceImpl<HomeSubjectSpuDao, HomeSubjectSpuEntity> implements HomeSubjectSpuService {

    /**
     * @description 分页查询
     * @param: params
     * @date: 2022/7/28 16:48
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomeSubjectSpuEntity> page = this.page(new Query<HomeSubjectSpuEntity>().getPage(params),new QueryWrapper<HomeSubjectSpuEntity>());
        return new PageUtils(page);
    }
}