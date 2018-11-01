package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 9:41
 */
public interface CategoryService {
    /**
     * 1 根据分类的id查询一条分类信息
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 2 查询所有的分类信息
     */
    List<ProductCategory> findAll();

    /**
     * 3 查询具体的分类信息，套餐啦，热榜啦......
     */
    List<ProductCategory> listCatogoryByCategoryIdType(List<Integer> list);

    /**
     * 4 新增分类
     */
    ProductCategory save(ProductCategory productCategory);

}
