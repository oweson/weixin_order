package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.utils.EnumUtil;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

<<<<<<< HEAD
/**
 * Created by 廖师兄
 * 2017-06-11 18:30
 */
=======

>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /**
     * 1 订单id.
     */
    private String orderId;

    /**
     * 2 买家名字.
     */
    private String buyerName;

    /**
     * 3 买家手机号.
     */
    private String buyerPhone;

    /**
     * 4 买家地址.
     */
    private String buyerAddress;

    /**
     * 5 买家微信Openid.
     */
    private String buyerOpenid;

    /**
     * 6 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 7 订单状态, 默认为0新下单.
     */
    private Integer orderStatus;

    /**
     * 8 支付状态, 默认为0未支付.
     */
    private Integer payStatus;

    /**
     * 9 创建时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 10 更新时间.去掉后面的三个0
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    /**
     * 一个订单多个商品详情
     */
    List<OrderDetail> orderDetailList;

    /**
     * 获得枚举状态的信息,
     *
     * @JsonIgnore对象转换json字段会忽略掉
     */
    //todo 下面的方法蒙逼！！
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    /**
     * 获得支付状态的，枚举信息
     */
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
