package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 11:22
 */
public interface ProductService  {
    List<ProductInfo> findUpAll();
    ProductInfo findOne(String productId);
    List<ProductInfo> findAll();
    List<ProductInfo> ListProductInfoBtTypeId(List<Integer> list);
    Page<ProductInfo> findByPage(Pageable page);
    ProductInfo save(ProductInfo productInfo);
}
