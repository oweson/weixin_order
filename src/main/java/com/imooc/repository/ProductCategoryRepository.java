package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * 1 根据商品的类目进行查询
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    //todo jpa定义接口是有规范的，不能乱起名字
}
