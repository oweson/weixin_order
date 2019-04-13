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
     * 1 名字.
     */
    private String productName;

    /**
     * 2 单价.
     */
    private BigDecimal productPrice;

    /**
     * 3 库存.
     */
    private Integer productStock;

    /**
     * 4 描述.
     */
    private String productDescription;

    /**
     * 5 小图.
     */
    private String productIcon;

    /**
     * 6 类目编号.
     */
    private Integer categoryType;
}
