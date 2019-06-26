package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import com.imooc.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/7 0007 10:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    private final String BUYER_OPENID = "1101110";

    private final String ORDER_ID = "1497183332311989948";

    /**
     * 1 测试买家下订单
     */

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("tiger");
        orderDTO.setBuyerAddress("mountain");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        /** 1 购物车，一个购物车，多个订单项，
         * 一个订单对应多个订单的详情*/
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        /** 2 订单详情一*/
        o1.setProductId("123456");
        o1.setProductQuantity(10);
/**定的详情二*/
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(20);
        /** 3 填充订单详情到集合*/
        orderDetailList.add(o1);
        orderDetailList.add(o2);
/** 4 订单详情的集合设置到订单*/
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO one = orderService.findOne("1234567");
        System.out.println(one);
        System.out.println(one.toString());
        for (OrderDetail orderDetail : one.getOrderDetailList()) {
            System.out.println(orderDetail + "===============================================");

        }

    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> list = orderService.findList("10101002", request);
        for (OrderDTO orderDTO : list) {
            System.out.println(orderDTO.toString() + "=========================================");

        }
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }

    @Test
    public void findList1() {
    }
}