/*
Navicat MySQL Data Transfer

Source Server         : ppx
Source Server Version : 50723
Source Host           : 47.94.153.206:3306
Source Database       : sell

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-04-13 22:22:16
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
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1234567810', '1234567', '11111112', 'fish meat!!!', '2.20', '3', 'http://xxxx.jpg', '2018-10-02 01:54:15', '2018-10-02 04:00:34');
INSERT INTO `order_detail` VALUES ('1234567811', '1234567', '11111110', 'bird meat!!!', '2.20', '3', 'http://xxxx.jpg', '2018-10-02 01:56:34', '2018-10-02 04:01:06');
INSERT INTO `order_detail` VALUES ('1538961986109347849', '1538961986000539498', '123456', 'banan', '3.20', '10', 'http://xxxxx.jpg', '2018-10-08 01:26:27', '2018-10-08 01:26:27');
INSERT INTO `order_detail` VALUES ('1538961986204738896', '1538961986000539498', '123457', 'watermelon', '3.20', '20', 'http://xxxxx.jpg', '2018-10-08 01:26:27', '2018-10-08 01:26:27');

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
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1234567', 'tom', '123456789123', 'river', '10101002', '2.50', '0', '0', '2018-10-02 01:48:31', '2018-10-02 01:48:31');
INSERT INTO `order_master` VALUES ('1234568', 'tom', '123456789123', 'river', '10101002', '2.50', '0', '0', '2018-10-02 01:49:28', '2018-10-02 01:49:28');
INSERT INTO `order_master` VALUES ('1234569', 'tom', '123456789123', 'river', '10101002', '2.50', '0', '0', '2018-10-02 04:00:06', '2018-10-02 04:00:06');
INSERT INTO `order_master` VALUES ('1538961986000539498', 'tiger', '123456789012', 'mountain', '1101110', '96.00', '0', '0', '2018-10-08 01:26:27', '2018-10-08 01:26:27');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('2', 'girl love', '1', '2018-10-01 00:50:11', '2018-10-01 01:03:15');
INSERT INTO `product_category` VALUES ('3', 'boy love', '3', '2018-10-01 00:56:29', '2018-10-01 00:56:29');
INSERT INTO `product_category` VALUES ('4', 'animal love', '3', '2018-10-01 00:58:10', '2018-10-01 00:58:10');
INSERT INTO `product_category` VALUES ('5', 'fish love', '3', '2018-10-01 00:58:36', '2018-10-01 00:58:36');
INSERT INTO `product_category` VALUES ('6', 'dog love', '10', '2018-10-01 07:22:31', '2018-10-01 07:22:31');
INSERT INTO `product_category` VALUES ('8', 'monkey love', '10', '2018-10-16 04:07:01', '2018-10-16 04:07:01');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('123456', 'banan', '3.20', '90', 'the apple from sourth', 'http://xxxxx.jpg', '0', '3', '2018-10-01 03:48:47', '2018-10-08 01:26:27');
INSERT INTO `product_info` VALUES ('123457', 'watermelon', '3.20', '80', 'the apple from sourth', 'http://xxxxx.jpg', '1', '3', '2018-10-01 03:51:02', '2018-10-30 07:22:51');
INSERT INTO `product_info` VALUES ('123458', 'apple', '3.20', '100', 'the apple from sourth', 'http://xxxxx.jpg', '0', '1', '2018-10-01 07:04:31', '2018-10-01 07:56:21');
INSERT INTO `product_info` VALUES ('123459', 'goldfish', '3.20', '100', 'the apple from sourth', 'http://xxxxx.jpg', '0', '2', '2018-10-01 09:39:16', '2018-10-01 09:42:31');
INSERT INTO `product_info` VALUES ('123460', 'fish', '3.20', '100', 'the apple from sourth', 'http://xxxxx.jpg', '0', '2', '2018-10-30 12:34:56', '2018-10-30 12:34:56');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info` (
  `seller_id` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `openid` varchar(64) NOT NULL COMMENT '微信openid',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='卖家信息表';

-- ----------------------------
-- Records of seller_info
-- ----------------------------
INSERT INTO `seller_info` VALUES ('1540903834745353071', 'ppx', '123', 'abc', '2018-10-30 12:50:35', '2018-10-30 12:50:35');
INSERT INTO `seller_info` VALUES ('1540904113552973578', 'admin', 'admin', 'cba', '2018-10-30 12:55:14', '2018-10-30 12:55:14');
