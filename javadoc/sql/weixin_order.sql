/*
Navicat MySQL Data Transfer

Source Server         : fuzhou
Source Server Version : 50725
Source Host           : 127.0.0.1:3306
Source Database       : weixin_order

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-10-20 23:11:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '当前价格,单位分',
  `product_quantity` int(11) NOT NULL COMMENT '数量',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1234567811', '11111111', '11111110', 'fish meat!!!', '2.20', '3', 'http://xxxx.jpg', '2019-06-26 23:18:18');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL,
  `buyer_name` varchar(32) NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态, 默认为新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态, 默认未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1234569', 'tom', '123456789123', 'river', '10101002', '2.50', '0', '0', '2019-06-26 23:36:38', '2019-06-26 23:36:38');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', '男生最爱', '1', '2018-05-14 17:11:03', '2018-05-14 17:11:03');
INSERT INTO `product_category` VALUES ('2', '女生最爱', '2', '2018-05-14 17:11:28', '2018-05-14 17:11:03');
INSERT INTO `product_category` VALUES ('3', '粉红少女最爱', '3', '2018-05-14 17:11:58', '2018-05-14 17:11:03');
INSERT INTO `product_category` VALUES ('4', '钟情少男最爱', '4', '2018-05-14 17:12:13', '2018-05-14 17:11:03');
INSERT INTO `product_category` VALUES ('5', '儿童最爱', '0', '2018-05-14 17:12:15', '2018-05-14 17:11:03');
INSERT INTO `product_category` VALUES ('7', '少妇最爱', '4', '2018-05-14 17:50:00', '2018-05-14 17:11:03');
INSERT INTO `product_category` VALUES ('9', '老人最爱', '1', '2018-05-15 14:00:22', '2018-05-14 17:11:03');
INSERT INTO `product_category` VALUES ('10', '习近平最爱金三胖', '10', '2018-06-20 16:34:17', '2018-05-14 17:11:03');
INSERT INTO `product_category` VALUES ('11', 'monkey love', '10', '2019-06-26 23:35:56', '2019-06-26 23:35:56');
INSERT INTO `product_category` VALUES ('12', '酸柴鱼', '100001', '2019-07-27 18:03:56', '2019-07-27 18:03:56');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '商品单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图的url',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `product_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1564221881055440733', '鱼', '11.00', '11', '12121', '1212', '1', '2019-07-27 18:04:41', '2019-07-27 18:04:41', '0');
INSERT INTO `product_info` VALUES ('1564221959215753786', 'bird', '12.00', '12', '121212', '121212', '4', '2019-07-27 18:05:59', '2019-07-27 18:05:59', '0');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `openid` varchar(64) NOT NULL COMMENT '微信openid',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卖家信息表';

-- ----------------------------
-- Records of seller_info
-- ----------------------------
INSERT INTO `seller_info` VALUES ('1', 'ppx', '123456', '1212121', '2019-07-27 18:06:24');
