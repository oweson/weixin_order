package com.imooc.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 专门用来存储表单提交过来的字段；
 * 上架和下架的状态这个字段不需要修改的！
 */
@Data
public class ProductForm {


    private String productId;

    /**
     * 名字.
     */
    private String productName;

    /**
     * 单价.
     */
    private BigDecimal productPrice;

    /**
     * 库存.
     */
    private Integer productStock;

    /**
     * 描述.
     */
    private String productDescription;

    /**
     * 小图.
     */
    private String productIcon;

    /**
     * 类目编号.
     */
    private Integer categoryType;
}
