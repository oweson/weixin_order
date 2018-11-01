package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/30 0030 15:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findByPage() {
    }

    @Test
    public void save() {
    }

    @Test
    public void increaseStock() {
    }

    @Test
    public void decreaseStock() {
    }

    @Test
    public void onSale() {
        ProductInfo productInfo = productService.onSale("123457");
        Assert.assertEquals(ProductStatusEnum.UP, productInfo.getProductStatusEnum());

    }

    @Test
    public void offSale() {
        ProductInfo productInfo = productService.offSale("123457");
        Assert.assertEquals(ProductStatusEnum.DOWN, productInfo.getProductStatusEnum());
    }
}