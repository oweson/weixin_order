package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 11:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceimplTest {
    @Autowired
    private ProductService productService;

    @Test
    public void findOne() {
        ProductInfo one = productService.findOne("123456");
        assertNotNull(one);


    }

    @Test
    public void findAll() {
        List<ProductInfo> all = productService.findAll();
        for (ProductInfo productInfo : all) {
            System.out.println(productInfo);

        }
    }
    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        System.out.println(upAll);

    }

    @Test
    public void listProductInfoBtTypeId() {
    }

    @Test
    public void findByPage() {
        PageRequest request  =new PageRequest(0,2);
        /**得到分页对象*/
        Page<ProductInfo> byPage = productService.findByPage(request);
        for (ProductInfo productInfo : byPage) {
            System.out.println(productInfo);

        }
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123459");
        productInfo.setProductName("tomottow");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("the apple from sourth");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.UP.getStatus());
        /**商品类别的id,通过id加一区分，商品对应某个分类*/
        productInfo.setCategoryType(1);
        ProductInfo save = productService.save(productInfo);
        assertNotNull(save);


    }
}