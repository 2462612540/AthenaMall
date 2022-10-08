package com.zhuangxiaoyan.athena.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.order.entity.OrderEntity;
import com.zhuangxiaoyan.athena.order.vo.*;
import com.zhuangxiaoyan.common.to.SeckillOrderTo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @description 订单
 * @date: 2022/7/30 23:37
 * @author: xjl
*/
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description 订单确认返回所需要的数据
      * @param:
     * @date: 2022/9/6 9:11
     * @return: com.zhuangxiaoyan.athena.order.vo.OrderConfirmVo
     * @author: xjl
    */
    OrderConfirmVo confirmOrder() throws ExecutionException, InterruptedException;

    /**
     * @description 下单逻辑
      * @param: vo
     * @date: 2022/9/11 15:50
     * @return: com.zhuangxiaoyan.athena.order.vo.SubmitOrderResponseVo
     * @author: xjl
    */
    SubmitOrderResponseVo submitOrder(OrderSubmitVo vo);

    /**
     * @description 获取订单的状态
      * @param: orderSn
     * @date: 2022/9/17 20:11
     * @return: com.zhuangxiaoyan.athena.order.entity.OrderEntity
     * @author: xjl
    */
    OrderEntity getStatusByOrderSn(String orderSn);

    /**
     * @description 关闭订单
      * @param: orderEntity
     * @date: 2022/9/17 22:15
     * @return: void
     * @author: xjl
    */
    void closeOrder(OrderEntity orderEntity);

    /**
     * @description 获取支付的订单信息
      * @param: orderSn
     * @date: 2022/10/5 16:48
     * @return: com.zhuangxiaoyan.athena.order.vo.PayVo
     * @author: xjl
    */
    PayVo getOrderPay(String orderSn);

    /**
     * 按照订单号获取订单信息
     * @param orderSn
     * @return
     */
    OrderEntity getOrderByOrderSn(String orderSn);

    /**
     * @description 查询订单详情页数据
      * @param: params
     * @date: 2022/10/6 9:07
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPageWithItem(Map<String, Object> params);

    /**
     * @description 处理支付宝的相关结果
      * @param: asyncVo
     * @date: 2022/10/6 10:22
     * @return: java.lang.String
     * @author: xjl
    */
    String handlePayResult(PayAsyncVo asyncVo);

    void createSeckillOrder(SeckillOrderTo orderTo);
}

