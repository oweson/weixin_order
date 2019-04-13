package com.imooc.form;

import lombok.Data;

/**
 * 用来存储新增分类传递过来的字段
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /**
     * 1 类目名字.
     */
    private String categoryName;

    /**
     * 2 类目编号.
     */
    private Integer categoryType;
}
