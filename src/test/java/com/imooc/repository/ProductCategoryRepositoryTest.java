package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by SqMax on 2018/3/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void updateTest() {
        /**测试更新*/
        ProductCategory one = repository.findOne(2);
        one.setCategoryType(1);
        repository.save(one);
    }

    @Test
    public void testFindByCategoryListType() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<ProductCategory> categoryByTypeIn = repository.findByCategoryTypeIn(list);
        for (ProductCategory productCategory : categoryByTypeIn) {
            System.out.println(productCategory);

        }
    }

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(2);
        System.out.println(productCategory.toString());
    }

    @Test
    //@Transactional
    public void saveTest() {
//        ProductCategory productCategory =repository.findOne(2);

//        productCategory.setCategoryType(5);
        ProductCategory productCategory = new ProductCategory("dog love", 10);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}