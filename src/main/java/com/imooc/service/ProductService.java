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
<<<<<<< HEAD
     * -1 查询所有在架子的商品列表
=======
     * 1 查询所有在架子的商品列表
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    List<ProductInfo> findUpAll();

    /**
<<<<<<< HEAD
     * 1 根据产品的id查询一个产品信息
=======
     * 2 根据产品的id查询一个产品信息
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
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
<<<<<<< HEAD
     * 5加库存
=======
     * 5 加库存
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
<<<<<<< HEAD
     * 6减库存
=======
     * 6 减库存，传入的是购物车：商品的id和数量
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
<<<<<<< HEAD
     * 7上架,id更方便，对象的话好要每次查出来.....
=======
     * 7上架,id更方便，对象的话还要每次查出来.....
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    ProductInfo onSale(String productId);

    /**
<<<<<<< HEAD
     * 8下架
=======
     * 8 下架
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
     */
    ProductInfo offSale(String productId);
}
