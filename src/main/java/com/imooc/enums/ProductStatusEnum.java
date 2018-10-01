package com.imooc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 11:15
 */
@Getter
public enum ProductStatusEnum {
    /**商品的状态枚举类*/
    UP(0,"上架商品"),
    DOWN(1,"下架商品");
    private Integer status;
    private String message;


    ProductStatusEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
