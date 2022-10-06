package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.OrderEntity;
import com.zhuangxiaoyan.athena.order.service.OrderService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 订单
 * @date: 2022/7/30 22:45
 * @author: xjl
 */

@RestController
@RequestMapping("order/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    /**
     * @description 查询订单状态是否完成
      * @param: orderSn
     * @date: 2022/9/17 20:09
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @GetMapping("/status/{orderSn}")
    public Result getOrderStatus(@PathVariable("orderSn") String orderSn){
        OrderEntity orderEntity=orderService.getStatusByOrderSn(orderSn);
        return Result.ok().setData(orderEntity);
    }


    /**
     * @description 分页当前用户登陆用户的所有的订单信息
     * @param: params
     * @date: 2022/7/30 22:46
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @PostMapping("/listWithItem")
    public Result listWithItem(@RequestBody Map<String, Object> params) {
        PageUtils page = orderService.queryPageWithItem(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 查询所有数据
     * @param: params
     * @date: 2022/7/30 22:46
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询
     * @param: id
     * @date: 2022/7/30 22:46
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id) {
        OrderEntity order = orderService.getById(id);
        return Result.ok().put("order", order);
    }

    /**
     * @description 保存数据
     * @param: order
     * @date: 2022/7/30 22:47
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    public Result save(@RequestBody OrderEntity order) {
        orderService.save(order);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: order
     * @date: 2022/7/30 22:47
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    public Result update(@RequestBody OrderEntity order) {
        orderService.updateById(order);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/30 22:47
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[] ids) {
        orderService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
