package com.imooc.service;

import com.imooc.dataobject.SellerInfo;
import com.imooc.repository.SellerInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/31 0031 8:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceTest {
    @Autowired
    private SellerInfoRepository repository;
    @Autowired
    private SellerService sellerService;
    public static final String openId = "abc";

    /**
     * 1 dao测试
     */
    @Test
    public void findSellerInfoByOpenId() {
        SellerInfo sellerInfo = repository.findByOpenid(openId);
        Assert.assertEquals(openId, sellerInfo.getOpenid());
    }

    /**
     * 2 service测试
     */
    @Test
    public void findSellerInfoByOpenIdInService() {
        SellerInfo sellerInfoByOpenId = sellerService.findSellerInfoByOpenId(openId);
        assertNotNull(sellerInfoByOpenId);

    }
}