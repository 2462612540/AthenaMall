package com.zhuangxiaoyan.athena.secondskill.controller;

import com.zhuangxiaoyan.athena.secondskill.service.SeckillService;
import com.zhuangxiaoyan.athena.secondskill.to.SeckillSkuRedisTo;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description TODO 
  * @param: null
 * @date: 2022/10/8 16:13
 * @return: 
 * @author: xjl
*/

@Controller
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    /**
     * @description 当前时间可以参与秒杀的商品信息
      * @param:
     * @date: 2022/10/8 16:17
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @GetMapping(value = "/getCurrentSeckillSkus")
    @ResponseBody
    public Result getCurrentSeckillSkus() {
        //获取到当前可以参加秒杀商品的信息
        List<SeckillSkuRedisTo> vos = seckillService.getCurrentSeckillSkus();
        return Result.ok().setData(vos);
    }

    /**
     * @description 根据skuId查询商品是否参加秒杀活动
      * @param: skuId
     * @date: 2022/10/8 16:16
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @GetMapping(value = "/sku/seckill/{skuId}")
    @ResponseBody
    public Result getSkuSeckilInfo(@PathVariable("skuId") Long skuId) {
        SeckillSkuRedisTo to = seckillService.getSkuSeckilInfo(skuId);
        return Result.ok().setData(to);
    }

    /**
     * @description 商品进行秒杀(秒杀开始)
      * @param: killId
     * @param: key
     * @param: num
     * @param: model
     * @date: 2022/10/8 16:16
     * @return: java.lang.String
     * @author: xjl
    */
    @GetMapping(value = "/kill")
    public String seckill(@RequestParam("killId") String killId,@RequestParam("key") String key,@RequestParam("num") Integer num,Model model) {
        String orderSn = null;
        try {
            //1、判断是否登录
            orderSn = seckillService.kill(killId, key, num);
            model.addAttribute("orderSn", orderSn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
