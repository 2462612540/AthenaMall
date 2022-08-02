package com.zhuangxiaoyan.athena.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.ware.dao.WareSkuDao;
import com.zhuangxiaoyan.athena.ware.entity.WareSkuEntity;
import com.zhuangxiaoyan.athena.ware.fegin.ProductFeginService;
import com.zhuangxiaoyan.athena.ware.service.WareSkuService;
import com.zhuangxiaoyan.athena.ware.vo.SkuHasStockVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import com.zhuangxiaoyan.common.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description WareSkuServiceImpl
 * @date: 2022/7/31 0:02
 * @author: xjl
 */

@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {

    @Autowired
    WareSkuDao wareSkuDao;

    @Autowired
    ProductFeginService productFeginService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<WareSkuEntity> queryWrapper = new QueryWrapper<>();
        String skuId = (String) params.get("skuId");
        if (!StringUtils.isEmpty(skuId)) {
            queryWrapper.eq("sku_id", skuId);
        }
        String wareId = (String) params.get("wareId");
        if (!StringUtils.isEmpty(wareId)) {
            queryWrapper.eq("sku_id", wareId);
        }
        IPage<WareSkuEntity> page = this.page(new Query<WareSkuEntity>().getPage(params), queryWrapper);
        return new PageUtils(page);
    }

    @Override
    public void addStock(Long skuId, Long wareId, Integer skuNum) {
        // 判断还没有这个库存记录
        List<WareSkuEntity> entities = wareSkuDao.selectList(new QueryWrapper<WareSkuEntity>().eq("sku_id", skuId).eq("ware_id", wareId));
        if (entities == null || entities.size() == 0) {
            WareSkuEntity wareSkuEntity = new WareSkuEntity();
            wareSkuEntity.setSkuId(skuId);
            wareSkuEntity.setWareId(wareId);
            wareSkuEntity.setStock(skuNum);
            wareSkuEntity.setStockLocked(0);
            // TODO 调用远程服务查询的相关的名字 如果失败了,那也不需要是事务回滚
            try {
                Result info = productFeginService.info(skuId);
                Map<String, Object> map = (Map<String, Object>) info.get("skuInfo");
                if (info.getCode() == 0) {
                    wareSkuEntity.setSkuName((String) map.get("skuName"));
                }
            } catch (Exception e) {

            }
            wareSkuDao.insert(wareSkuEntity);
        } else {
            wareSkuDao.addStock(skuId, wareId, skuNum);
        }
    }

    /**
     * @description 查询是否有库存
     * @param: skuIds
     * @date: 2022/8/1 22:57
     * @return: java.util.List<com.zhuangxiaoyan.athena.ware.vo.SkuHasStockVo>
     * @author: xjl
     */
    @Override
    public List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds) {
        List<SkuHasStockVo> collect = skuIds.stream().map(skuId -> {
            SkuHasStockVo vo = new SkuHasStockVo();
            Long count=baseMapper.getSkuStock(skuId);
            vo.setSkuId(skuId);
            vo.setHasStock(count>0);
            return vo;
        }).collect(Collectors.toList());
        return collect;
    }
}