package com.imooc.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/12 0012 15:33
 */
@Data
public class OrderForm {
    /**
     * 1 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 2  买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 3 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 4 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 5 购物车的信息也是字符串
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
