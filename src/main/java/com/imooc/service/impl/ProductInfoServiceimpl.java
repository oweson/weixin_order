package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 11:26
 */
@Service
public class ProductInfoServiceimpl implements ProductService {
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getStatus());
    }

    @Autowired
    ProductInfoRepository repository;
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findAll() {
        /**获得上架的商品*/
        return repository.findAll();
    }

    @Override
    public List<ProductInfo> ListProductInfoBtTypeId(List<Integer> list) {
        return null;
    }

    @Override
    public Page<ProductInfo> findByPage(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
