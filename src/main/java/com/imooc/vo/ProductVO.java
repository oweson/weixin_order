package com.imooc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品包含类目
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 12:06
 */
@Data
public class ProductVO {
    /**
     * 序列化为name返回前端
     */
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;
    /**
     * 一个热榜对应多个商品的详情，category_type，
     * 处于安全需要什么返回什么；
     * 序列化为foods
     */
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
