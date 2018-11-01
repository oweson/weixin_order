package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 9:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;

    /**
     * 1 根据分类的id查询一条分类信息
     */
    @Test
    public void findOne() {
        ProductCategory one = categoryService.findOne(2);
        assertNotNull(one);

    }

    /**
     * 2 查询所有的分类信息
     */
    @Test
    public void findAll() {
        List<ProductCategory> categoryList = categoryService.findAll();
        for (ProductCategory productCategory : categoryList) {
            System.out.println(productCategory);

        }
    }

    /**
     * 3 查询具体的分类信息，套餐啦，热榜啦......
     */
    @Test
    public void listCatogoryByCategoryIdType() {
        List<ProductCategory> listCatogoryByCategoryIdType = categoryService.listCatogoryByCategoryIdType(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        for (ProductCategory productCategory : listCatogoryByCategoryIdType) {
            System.out.println(productCategory);

        }
    }
}