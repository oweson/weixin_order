package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertNotNull;


/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 10:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductInfoRepositoryTest {
    @Autowired


    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123460");
        productInfo.setProductName("fish");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("the apple from sourth");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(0);
        /**商品类别的id,通过id加一区分，商品对应某个分类*/
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);

        assertNotNull(result);

    }

    @Test
    public void listProductInfoByStatus() {
        List<ProductInfo> byProductStatus = repository.findByProductStatus(0);
        assertNotNull(byProductStatus);

    }

    @Test
    public void isEsistsTest() {
        boolean b = repository.existsByCategoryType(2);
        System.out.println(b);
    }
}