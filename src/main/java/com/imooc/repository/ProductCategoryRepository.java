package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SqMax on 2018/3/17.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * 根据商品的类别进行查询
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);


    /**自己的接口*/
}
