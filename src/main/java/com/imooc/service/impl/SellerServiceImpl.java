package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.repository.SellerInfoRepository;
import com.imooc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/31 0031 8:54
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;
<<<<<<< HEAD
/**根据卖家的openId查询卖家的信息*/
    @Override
    public SellerInfo findSellerInfoByOpenId(String openId) {

        return null;
=======

    /**
     * 1 根据卖家的openId查询卖家的信息
     */
    @Override
    public SellerInfo findSellerInfoByOpenId(String openId) {
        SellerInfo repositoryByOpenid = repository.findByOpenid(openId);
        if (repositoryByOpenid == null) {
            return null;
        }

        return repositoryByOpenid;
>>>>>>> 5fd7457610e704a4c1cc6cbd6deef03a264b3944
    }
}
