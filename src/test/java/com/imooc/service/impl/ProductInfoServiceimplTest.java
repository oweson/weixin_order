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

    /**
     * 1 根据产品的id查询一个产品信息
     */

    @Test
    public void findOne() {
        ProductInfo one = productService.findOne("123456");
        assertNotNull(one);


    }

    /**
     * 2 查询所有上架的商品
     */
    @Test
    public void findUpAll() {
        List<ProductInfo> all = productService.findUpAll();
        for (ProductInfo productInfo : all) {
            System.out.println(productInfo);

        }
    }


    /**
     * 3 获得全部的商品，上架的和非上架的,进行分页显示
     */

    @Test
    public void findByPage() {
        PageRequest request = new PageRequest(0, 2);
        /**得到分页对象*/
        Page<ProductInfo> byPage = productService.findByPage(request);
        for (ProductInfo productInfo : byPage) {
            System.out.println(productInfo);

        }
    }

    /**
     * 4 新增商品
     */
    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123459");
        productInfo.setProductName("tomottow");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("the apple from sourth");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        /**商品类别的id,通过id加一区分，
         * 商品对应某个分类*/
        productInfo.setCategoryType(1);
        ProductInfo save = productService.save(productInfo);
        assertNotNull(save);


    }
    /** 5 增加库存*/
    /**
     * 6 减少库存
     */
    /**
     * 同三
     */
    @Test
    public void pageTest() {
        PageRequest pageRequest = new PageRequest(0, 8);
        Page<ProductInfo> productServiceByPage = productService.findByPage(pageRequest);
        for (ProductInfo productInfo : productServiceByPage) {
            System.out.println(productInfo);

        }
    }

}