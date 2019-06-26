package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 10:13
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**
     * 主键是string
     */
    /**
     * 1 根据商品的状态查询商品
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 2 根据商品的类别，判断商品是否存在
     */
    boolean existsByCategoryType(Integer categoryType);
}
