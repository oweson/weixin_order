package com.imooc.repository;

import com.imooc.dataobject.SellerInfo;
import com.imooc.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/30 0030 20:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("cba");
        sellerInfo.setPassword("admin");
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        SellerInfo save = repository.save(sellerInfo);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOpenId() {
        SellerInfo sellerInfo = repository.findByOpenid("cba");
        Assert.assertEquals("cba",sellerInfo.getOpenid());

    }
}