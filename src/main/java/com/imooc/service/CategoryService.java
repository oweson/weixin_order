package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 9:41
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> listCatogoryByCategoryIdType(List<Integer> list);
}
