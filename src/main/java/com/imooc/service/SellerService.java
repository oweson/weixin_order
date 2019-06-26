package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/31 0031 8:54
 */
public interface SellerService {
    SellerInfo findSellerInfoByOpenId(String openId);
}
