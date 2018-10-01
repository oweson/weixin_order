package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

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
    @Test
    public void findOne() {
        ProductCategory one = categoryService.findOne(2);
        assertNotNull(one);

    }

    @Test
    public void findAll() {
       categoryService.findAll();
    }

    @Test
    public void listCatogoryByCategoryIdType() {
       categoryService.listCatogoryByCategoryIdType(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
    }
}