package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.OrderSettingEntity;
import com.zhuangxiaoyan.athena.order.service.OrderSettingService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 订单配置信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@RestController
@RequestMapping("order/ordersetting")
public class OrderSettingController {
    @Autowired
    private OrderSettingService orderSettingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:ordersetting:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderSettingService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:ordersetting:info")
    public Result info(@PathVariable("id") Long id) {
        OrderSettingEntity orderSetting = orderSettingService.getById(id);

        return Result.ok().put("orderSetting", orderSetting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:ordersetting:save")
    public Result save(@RequestBody OrderSettingEntity orderSetting) {
        orderSettingService.save(orderSetting);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:ordersetting:update")
    public Result update(@RequestBody OrderSettingEntity orderSetting) {
        orderSettingService.updateById(orderSetting);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:ordersetting:delete")
    public Result delete(@RequestBody Long[] ids) {
        orderSettingService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
