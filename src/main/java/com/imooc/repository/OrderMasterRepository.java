package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/2 0002 9:24
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    /**
     * 1 分页订单量大，分页，根据买家的openId(微信id)去查询，
     * 一个微信可能会下一个或者多个订单，返回page
     */
    Page<OrderMaster> findByBuyerOpenid(String openId, Pageable pageable);


}
