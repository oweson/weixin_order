package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.repository.ProductCategoryRepository;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 9:44
 */
@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    ProductCategoryRepository repository;

    /**
     * 1 新增分类
     */
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }

    /**
<<<<<<< HEAD
     * 1 根据分类的id查询一条分类信息
=======
     * 2 根据分类的id查询一条分类信息
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    /**
<<<<<<< HEAD
     * 2 查询所有的分类信息
=======
     * 3 查询所有的分类信息
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    /**
<<<<<<< HEAD
     * 3 查询具体的分类信息，套餐啦，热榜啦......
=======
     * 4 查询具体的分类信息，套餐啦，热榜啦......
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    @Override
    public List<ProductCategory> listCatogoryByCategoryIdType(List<Integer> list) {
        return repository.findByCategoryTypeIn(list);
    }
}
