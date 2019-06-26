package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 廖师兄
 * 2017-07-23 23:02
 * CREATE TABLE `seller_info` (
 * `id` varchar(32) NOT NULL,
 * `username` varchar(32) NOT NULL,
 * `password` varchar(32) NOT NULL,
 * `openid` varchar(64) NOT NULL COMMENT '微信openid',
 * `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卖家信息表';
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
