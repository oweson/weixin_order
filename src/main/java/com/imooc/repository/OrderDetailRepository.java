package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/2 0002 9:30
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    /**
     * 1 master对应detail四1：m的关系，
     * 根据orderId查询
     * 思路：先根据买家的openId,查询订单的orderId,
     * 然后根据orderId区查询订单详情可能返回一个或者多个
     */
    List<OrderDetail> findByOrderId(String orderId);
}
