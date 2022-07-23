package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.PaymentInfoEntity;
import com.zhuangxiaoyan.athena.order.service.PaymentInfoService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 支付信息表
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@RestController
@RequestMapping("order/paymentinfo")
public class PaymentInfoController {
    @Autowired
    private PaymentInfoService paymentInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:paymentinfo:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = paymentInfoService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:paymentinfo:info")
    public Result info(@PathVariable("id") Long id) {
        PaymentInfoEntity paymentInfo = paymentInfoService.getById(id);

        return Result.ok().put("paymentInfo", paymentInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:paymentinfo:save")
    public Result save(@RequestBody PaymentInfoEntity paymentInfo) {
        paymentInfoService.save(paymentInfo);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:paymentinfo:update")
    public Result update(@RequestBody PaymentInfoEntity paymentInfo) {
        paymentInfoService.updateById(paymentInfo);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:paymentinfo:delete")
    public Result delete(@RequestBody Long[] ids) {
        paymentInfoService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
