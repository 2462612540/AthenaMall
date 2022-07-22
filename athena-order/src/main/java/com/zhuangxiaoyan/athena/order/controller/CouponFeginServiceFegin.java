package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.fegin.CouponFeginService;
import com.zhuangxiaoyan.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname CouponFeginServiceFegin
 * @Description TODO
 * @Date 2022/3/13 14:08
 * @Created by xjl
 */
@RestController
@RequestMapping("order/order")
public class CouponFeginServiceFegin {

    @Autowired
    private CouponFeginService couponFeginService;

    /**
     * @description 调用远程服务
     * @param:
     * @date: 2022/3/13 14:09
     * @return: com.zhuangxiaoyan.common.utils.R
     * @author: xjl
     */
    @RequestMapping("/coupons")
    public R test() {
        R membercoupons = couponFeginService.membercoupons();
        return R.ok().put("athena-order ", "athena-order fegin call athena coupons").put("coupon", membercoupons);
    }
}
