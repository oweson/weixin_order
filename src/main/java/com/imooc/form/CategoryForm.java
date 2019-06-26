package com.imooc.form;

import lombok.Data;

/**
 * 用来存储新增分类传递过来的字段
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /**
<<<<<<< HEAD
     * 类目名字.
=======
     * 1 类目名字.
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    private String categoryName;

    /**
<<<<<<< HEAD
     * 类目编号.
=======
     * 2 类目编号.
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    private Integer categoryType;
}
