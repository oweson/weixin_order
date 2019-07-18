package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/18 0018 10:58
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    /**
     * 1 判断订单是否是本人
     */
    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openId, orderId);
        /**没有问题返回对象*/
        return orderDTO;
    }
/** 3 判断订单是否是本人的，然胡取消操作*/

    /**
     * 2 判断订单是否是本人的，然胡取消操作
     */
    @Override
    public OrderDTO cancelOrder(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openId, orderId);
        if (orderDTO == null) {
            /**查不到订单无法取消*/
            log.error("【取消订单】查不到改订单, orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        /**存在久直接取消好了*/
        return orderService.cancel(orderDTO);
    }

    /**
     * 3 抽取公用的代码
     */
    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            /**判断订单是否存在*/
            return null;
        }
        //判断是否是自己的订单
        /**判断是否是自己的订单*/
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致. openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
