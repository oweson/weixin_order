package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表，下面有许多订单详情，一个订单购买了一个苹果，两个香蕉，三个西瓜........
 * CREATE TABLE `order_master` (
 * `order_id` varchar(32) NOT NULL,
 * `buyer_name` varchar(32) NOT NULL COMMENT '买家名字',
 * `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
 * `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
 * `buyer_openid` varchar(64) NOT NULL COMMENT '买家微信openid',
 * `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
 * `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态, 默认为新下单',
 * `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态, 默认未支付',
 * `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
 * PRIMARY KEY (`order_id`),
 * KEY `idx_buyer_openid` (`buyer_openid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 */
@Entity
@Data
/**自动updatetime*/
@DynamicUpdate
public class OrderMaster {
    /**订单的主表*/

    /**
     * 订单id.
     */
    @Id
    private String orderId;

    /**
     * 买家名字.
     */
    private String buyerName;

    /**
     * 买家手机号.
     */
    private String buyerPhone;

    /**
     * 买家地址.
     */
    private String buyerAddress;

    /**
     * 买家微信Openid.
     */
    private String buyerOpenid;

    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为0新下单.
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态, 默认为0未支付.
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

}
