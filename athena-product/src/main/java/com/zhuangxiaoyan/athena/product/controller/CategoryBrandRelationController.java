package com.zhuangxiaoyan.athena.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuangxiaoyan.athena.product.entity.BrandEntity;
import com.zhuangxiaoyan.athena.product.entity.CategoryBrandRelationEntity;
import com.zhuangxiaoyan.athena.product.service.CategoryBrandRelationService;
import com.zhuangxiaoyan.athena.product.vo.BrandVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 品牌分类关联
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;
    /**
     * @description 查询的
      * @param:
     * @date: 2022/7/25 12:31
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     * controller 处理请求和接受参数和数据的校验的工作，同时接受的service的返回的数据同时返回给这个页面
     * service 接受的controller的请求，进行的业务处理
    */
    @GetMapping("/brands/list")
    public Result releationBrandRelation(@RequestParam(value = "catId",required = true) Long catId){
        List<BrandEntity> brandVos=categoryBrandRelationService.getBrandsBycatId(catId);
        List<BrandVo> collectBrandVos = brandVos.stream().map(item -> {
            BrandVo brand = new BrandVo();
            brand.setBrandId(item.getBrandId());
            brand.setBrandName(item.getName());
            return brand;
        }).collect(Collectors.toList());
        return Result.ok().put("data", collectBrandVos);
    }

    /**
     * 获取当前品牌的关联的的所有分类列表
     */

    @GetMapping(value = "/catelog/list")
    // @RequestMapping(value = "/catelog/list", method = RequestMethod.GET)
    //@RequiresPermissions("product:categorybrandrelation:list")
    public Result cateloglist(@RequestParam("brandId") Long brandId) {
        List<CategoryBrandRelationEntity> data = categoryBrandRelationService.list(
                new QueryWrapper<CategoryBrandRelationEntity>().eq("brand_id", brandId));
        return Result.ok().put("data", data);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:categorybrandrelation:info")
    public Result info(@PathVariable("id") Long id) {
        CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);
        return Result.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:categorybrandrelation:save")
    public Result save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation) {

        categoryBrandRelationService.saveDetial(categoryBrandRelation);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:categorybrandrelation:update")
    public Result update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation) {
        categoryBrandRelationService.updateById(categoryBrandRelation);
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:categorybrandrelation:delete")
    public Result delete(@RequestBody Long[] ids) {
        categoryBrandRelationService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
