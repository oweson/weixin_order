package com.imooc.controller;

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.exception.SellException;
import com.imooc.form.ProductForm;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1 订单列表
     *
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        /**findByPage注意无条件的查询所有的商品，商上架的和下架的*/
        Page<ProductInfo> productInfoPage = productService.findByPage(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    /**
     * 2 商品上架,下架状态修改为上架
     *
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            /**错误的页面，并携带错误的提示信息和url商品的列表url*/
            return new ModelAndView("common/error", map);
        }
        /**成功了，商品的列表页*/
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 3 商品下架
     *
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 4 修改商品
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        //todo 修改id不是一定会有，传入的？？？
        /**判断id是否为空不是必须传入的*/
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        /**查询所有的类目,回显示显示可以修改选择*/
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);

        return new ModelAndView("product/index", map);
    }

    /**
     * 5 保存/更新
     *
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    //todo 表单验证 @valid
    //todo bindresult???
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            /**错了就到商品的新增的页面*/
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        /**n的时候productStatusEnum就由了初始值了*/
        ProductInfo productInfo = new ProductInfo();
        try {
            /**如果productId为空, 说明是新增*/
            if (!StringUtils.isEmpty(form.getProductId())) {
                /**到了这里是修改，先付给productInfo初始值，然后新的form值传入，把有的覆盖；
                 * 没有对与的不会覆盖掉！*/
                productInfo = productService.findOne(form.getProductId());
            } else {
                /**这里是新增，设置主键*/
                form.setProductId(KeyUtil.genUniqueKey());
            }
            /**productInfo等于新的值和原先不变的值*/
            BeanUtils.copyProperties(form, productInfo);
            /**入库*/
            productService.save(productInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
/**没有问题最后跳转到列表页面；
 * 首先提示成功，三秒后跳转到成功的页面*/
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
