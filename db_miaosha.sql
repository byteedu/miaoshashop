/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : db_miaosha

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-05-19 19:31:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `addressDesc` varchar(255) DEFAULT NULL,
  `addressUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` longtext,
  `userPw` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a');

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `cartUserId` int(11) NOT NULL,
  `cartGoodsId` int(11) DEFAULT NULL COMMENT '商品id',
  `cartQuantity` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`cartId`),
  KEY `user_id_index` (`cartUserId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES ('126', '21', '26', '1');

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(200) DEFAULT NULL,
  `goodsDesc` varchar(5000) DEFAULT NULL,
  `goodsPic` varchar(100) DEFAULT NULL,
  `goodsPrice` decimal(11,2) DEFAULT NULL,
  `goodsStarttime` varchar(50) DEFAULT NULL,
  `goodsEndtime` varchar(50) DEFAULT NULL,
  `goodsCatelogId` int(11) DEFAULT NULL,
  `goodsInitnum` int(11) DEFAULT NULL,
  `goodsResnum` int(11) DEFAULT NULL,
  `goodsDel` int(50) DEFAULT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('2', '漂亮藤椅', '漂亮藤椅', '/upload/item1.jpg', '800.00', '800', 'no', '1', null, null, '0');
INSERT INTO `t_goods` VALUES ('3', '老板转椅', '老板转椅', '/upload/item2.jpg', '700.00', '700', 'no', '2', null, null, '0');
INSERT INTO `t_goods` VALUES ('4', '高端办公椅', '高端办公椅', '/upload/item3.jpg', '500.00', '500', 'no', '2', null, null, '0');
INSERT INTO `t_goods` VALUES ('5', '简易玻璃茶几', '简易玻璃茶几', '/upload/item4.jpg', '200.00', '200', 'no', '1', null, null, '0');
INSERT INTO `t_goods` VALUES ('6', '真皮小沙发', '真皮小沙发', '/upload/item5.jpg', '100.00', '100', 'no', '1', null, null, '0');
INSERT INTO `t_goods` VALUES ('7', '休闲椅', '休闲椅', '/upload/item6.jpg', '100.00', '100', 'no', '1', null, null, '0');
INSERT INTO `t_goods` VALUES ('8', '高端转椅', '真皮转椅', '/upload/item7.jpg', '100.00', '100', 'no', '2', null, null, '0');
INSERT INTO `t_goods` VALUES ('9', '真皮转椅', '真皮转椅', '/upload/item8.jpg', '100.00', '100', 'no', '2', null, null, '0');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(200) DEFAULT NULL,
  `orderDate` varchar(50) DEFAULT NULL,
  `orderAddressId` int(50) DEFAULT NULL,
  `orderPrice` int(11) DEFAULT NULL,
  `orderUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '20131121031708', '2013-11-21 03:17:08', '0', '1000', '1');
INSERT INTO `t_order` VALUES ('2', '20170426061635', '2017-04-26 06:16:35', '2222', '0', '1');
INSERT INTO `t_order` VALUES ('3', '20170426061729', '2017-04-26 06:17:29', '2222', '0', '1');
INSERT INTO `t_order` VALUES ('4', '20170427095009', '2017-04-27 09:50:09', '2222', '100', '1');
INSERT INTO `t_order` VALUES ('5', '20170427090100', '2017-04-27 09:01:00', '5555', '100', '1');
INSERT INTO `t_order` VALUES ('6', '20170428081642', '2017-04-28 08:16:42', '2222', '300', '1');
INSERT INTO `t_order` VALUES ('7', '20170428085250', '2017-04-28 08:52:50', '8888', '200', '1');

-- ----------------------------
-- Table structure for t_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `t_orderitem`;
CREATE TABLE `t_orderitem` (
  `orderItemId` int(11) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(100) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `goodsQuantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderItemId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderitem
-- ----------------------------
INSERT INTO `t_orderitem` VALUES ('1', '1', '2', '1');
INSERT INTO `t_orderitem` VALUES ('2', '1', '6', '1');
INSERT INTO `t_orderitem` VALUES ('3', '1', '9', '1');
INSERT INTO `t_orderitem` VALUES ('4', '4', '9', '1');
INSERT INTO `t_orderitem` VALUES ('5', '5', '7', '1');
INSERT INTO `t_orderitem` VALUES ('6', '6', '5', '1');
INSERT INTO `t_orderitem` VALUES ('7', '6', '7', '1');
INSERT INTO `t_orderitem` VALUES ('8', '7', '5', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `userPw` varchar(50) DEFAULT NULL,
  `userTel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'liusan', '000000', '13444444444');
