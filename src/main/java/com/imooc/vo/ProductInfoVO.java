package com.imooc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
/**
 * 商品的详情
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 12:08
 */


@Data
public class ProductInfoVO {
/**json序列化的时候记性映射*/
    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
