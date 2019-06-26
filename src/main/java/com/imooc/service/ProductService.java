package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 11:22
 */
public interface ProductService {
    /**
     * -1 查询所有在架子的商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 1 根据产品的id查询一个产品信息
     */
    ProductInfo findOne(String productId);


    /**
     * 3 无条件查询分页
     */
    Page<ProductInfo> findByPage(Pageable page);

    /**
     * 4 新增产品
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 5加库存
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 6减库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 7上架,id更方便，对象的话好要每次查出来.....
     */
    ProductInfo onSale(String productId);

    /**
     * 8下架
     */
    ProductInfo offSale(String productId);
}
