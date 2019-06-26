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
<<<<<<< HEAD
     * 名字.
=======
     * 1 名字.
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    private String productName;

    /**
<<<<<<< HEAD
     * 单价.
=======
     * 2 单价.
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    private BigDecimal productPrice;

    /**
<<<<<<< HEAD
     * 库存.
=======
     * 3 库存.
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    private Integer productStock;

    /**
<<<<<<< HEAD
     * 描述.
=======
     * 4 描述.
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    private String productDescription;

    /**
<<<<<<< HEAD
     * 小图.
=======
     * 5 小图.
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    private String productIcon;

    /**
<<<<<<< HEAD
     * 类目编号.
=======
     * 6 类目编号.
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    private Integer categoryType;
}
