package com.imooc.controller;

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import com.imooc.vo.ProductInfoVO;
import com.imooc.vo.ProductVO;
import com.imooc.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/1 0001 15:07
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 1 查询所有上架的商品
     */

    @GetMapping("/list")
    public ResultVO list() {
        List<ProductInfo> upAll = productService.findUpAll();
        /** 1 查询所有上架商品的类目，一次性的查询*/
        /**传统的查询
         List<Integer> list = new ArrayList<>();
         for (ProductInfo productInfo : upAll) {
         list.add(productInfo.getCategoryType());
         }
         categoryService.listCatogoryByCategoryIdType(list);*/

        /** 2 lambda表达式的写法,
         * collect,toList()作为list来收集*/
        List<Integer> collect = upAll.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategories = categoryService.listCatogoryByCategoryIdType(collect);
        /** 3 拼装数据*/
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            /**下面是一个商品的集合根据类别分的类*/
            List<ProductInfoVO> list = new ArrayList<>();
            for (ProductInfo productInfo : upAll) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();

                    /**数据拷贝到商品详情*/
                    BeanUtils.copyProperties(productInfo, productInfoVO);

                    /**封装某个商品类别下的商品集合*/
                    list.add(productInfoVO);
                }


            }
            productVO.setProductInfoVOList(list);
            productVOList.add(productVO);


        }


        return ResultVOUtil.success(productVOList);

    }
}
