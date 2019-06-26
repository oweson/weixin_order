package com.imooc.repository;

<<<<<<< HEAD
=======
import com.imooc.dataobject.OrderDetail;
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.stream.Collectors;
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944

import static org.junit.Assert.*;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/2 0002 9:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    private final String OPENID="10101002";
    @Autowired
    private OrderMasterRepository repository;
    @Test
    public void saveOrderMasterTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234569");
        orderMaster.setBuyerName("tom");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("river");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);


    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0,1);
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid("10101001", request);
        assertNotNull(byBuyerOpenid);



    }
<<<<<<< HEAD
=======
    @Test
    public void lambdaTest() {
        /** List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());*/
        PageRequest request = new PageRequest(0,10);
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid("1234567", request);
        System.out.println(byBuyerOpenid.getTotalElements());
        List<OrderDetail> collect = byBuyerOpenid.getContent()
                .stream().map(e -> new OrderDetail(e.getOrderId(), 2)).collect(Collectors.toList());
        System.out.println(collect.toString());

        assertNotNull(byBuyerOpenid);



    }
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
}