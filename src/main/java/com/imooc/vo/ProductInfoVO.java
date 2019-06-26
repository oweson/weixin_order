package com.imooc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品的详情,因为返回的时候，
<<<<<<< HEAD
 * 有的字段木有不要返回
=======
 * 有的字段没有必要，不要返回
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 12:08
 */


@Data
public class ProductInfoVO {
    /**
<<<<<<< HEAD
     * json序列化的时候记性映射
=======
     * json序列化的时候映射
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
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
