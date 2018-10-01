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
    List<ProductInfo> findByProductStatus(Integer productStatus);
    boolean existsByCategoryType(Integer categoryType);
}
