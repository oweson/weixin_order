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

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;
    /**
     * 一个热榜对应多个商品的详情
     */
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
