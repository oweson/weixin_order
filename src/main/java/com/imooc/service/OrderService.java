package com.imooc.service;

import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/2 0002 12:11
 */
public interface OrderService {
    /**
     * 1 创建订单.
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 2 根据订单的id查询单个订单.
     */
    OrderDTO findOne(String orderId);

    /**
     * 3 根据买家的微信id去查询订单列表.
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 4 取消订单.
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 5 完结订单.
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 6 支付订单.
     */
    OrderDTO paid(OrderDTO orderDTO);

    /**
     * 7 无条件的去查询所有的订单列表，卖家端使用.
     */
    Page<OrderDTO> findList(Pageable pageable);

}
