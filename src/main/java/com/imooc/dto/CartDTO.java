package com.imooc.dto;

import lombok.Data;

/**
 * 购物车
 * Created by oweson
 * 2018-06-11 19:37
 */
@Data
public class CartDTO {

    /** 1 商品Id. */
    private String productId;

    /** 2 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
