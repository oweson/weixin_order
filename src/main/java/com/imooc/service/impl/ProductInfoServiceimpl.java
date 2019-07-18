package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 11:26
 */
@Service
public class ProductInfoServiceimpl implements ProductService {
    @Autowired
    ProductInfoRepository repository;

    /**
     * 1 增加库存
     */
    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO: cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            repository.save(productInfo);
        }

    }

    @Override
    @Transactional
    /** 2 减去库存*/
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            /**查看库存是否足够*/
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
/**把新的库存写入数据库*/
            productInfo.setProductStock(result);
/**为何保存？？？？？*/
          /**把新的库存写入数据库*/
            productInfo.setProductStock(result);
            /**重新入库，更改数量*/
            repository.save(productInfo);
        }
    }



    /**
     * 4 修改商品的状态，上架修改为下架
     */
    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

        }
        /**已经下架了不允许修改*/
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);

        }
        /**更新，吧商品从上架架修改为下架状态*/
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }

    /**
     * 5 查询所有上架的商品
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    /**
     * 6 根据产品的id查询一个产品信息
     */
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }


    /**
     * 7 获得全部的商品，上架的和非上架的,进行分页显示
     */

    @Override
    public Page<ProductInfo> findByPage(Pageable page) {
        return repository.findAll(page);
    }

    /**
     * 8 保存商品
     */
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
