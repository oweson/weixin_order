package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

<<<<<<< HEAD
/**
 * Created by SqMax on 2018/3/17.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * 根据商品的类别进行查询
=======

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * 1 根据商品的类目进行查询
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    //todo jpa定义接口是有规范的，不能乱起名字
}
