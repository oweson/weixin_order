package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/18 0018 10:54
 */
public interface BuyerService {
    /**
     * 1 查询一个订单
     */
    OrderDTO findOrderOne(String openId, String orderId);

    /**
     * 2 取消订单
     */
    OrderDTO cancelOrder(String openId, String orderId);
}
