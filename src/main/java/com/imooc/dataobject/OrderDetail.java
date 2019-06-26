package com.imooc.dataobject;

import lombok.Data;
<<<<<<< HEAD
=======
import lombok.NoArgsConstructor;
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单详情表，没有外键设计到了其他的两张表，
 * 一个详情对应不仅仅一件商品！！！许多的订单详情属于一个订单
 * CREATE TABLE `order_detail` (
 * `detail_id` varchar(32) NOT NULL,
 * `order_id` varchar(32) NOT NULL '订单的id重要',
 * `product_id` varchar(32) NOT NULL '商品的id重要',
 * `product_name` varchar(64) NOT NULL COMMENT '商品名称',
 * `product_price` decimal(8,2) NOT NULL COMMENT '当前价格,单位分',
 * `product_quantity` int(11) NOT NULL COMMENT '数量',
 * `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
 * `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
 * PRIMARY KEY (`detail_id`),
 * KEY `idx_order_id` (`order_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 */
@Entity
@Data
<<<<<<< HEAD
=======
@NoArgsConstructor
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
public class OrderDetail {
    /**
     * 订单详情表
     */

    @Id
    private String detailId;

    /**
     * 订单id.
     */
    private String orderId;

    /**
     * 商品id.
     */
    private String productId;

    /**
     * 商品名称.
     */
    private String productName;

    /**
     * 商品单价.
     */
    private BigDecimal productPrice;

    /**
     * 商品数量.
     */
    private Integer productQuantity;

    /**
     * 商品小图.
     */
    private String productIcon;
<<<<<<< HEAD
=======

    public OrderDetail(String orderId, Integer productQuantity) {
        this.orderId = orderId;
        this.productQuantity = productQuantity;
    }
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
}
