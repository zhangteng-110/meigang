/*
 Navicat Premium Data Transfer

 Source Server         : test01
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : test01

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 12/01/2021 14:52:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction`  (
  `transactionId` int(0) NOT NULL AUTO_INCREMENT COMMENT '交易id',
  `transactionDate` datetime(0) NULL DEFAULT NULL COMMENT '交易日期',
  `transactionMoney` bigint(0) NULL DEFAULT NULL COMMENT '交易金额',
  `transactionStatus` tinyint(0) NULL DEFAULT NULL COMMENT '交易状态',
  `userId` int(0) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`transactionId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transaction
-- ----------------------------
INSERT INTO `transaction` VALUES (8, '2020-12-30 16:58:30', 3000, 1, 15);
INSERT INTO `transaction` VALUES (9, '2020-12-30 16:59:04', 1500, 1, 20);
INSERT INTO `transaction` VALUES (10, '2021-01-04 09:18:38', 2000, 1, 23);
INSERT INTO `transaction` VALUES (11, '2021-01-04 13:55:30', 500, 1, 34);
INSERT INTO `transaction` VALUES (12, '2021-01-04 14:01:48', 1000, 1, 25);
INSERT INTO `transaction` VALUES (13, '2021-01-06 09:58:43', 1500, 1, 24);
INSERT INTO `transaction` VALUES (14, '2021-01-08 09:31:22', 2000, 1, 31);
INSERT INTO `transaction` VALUES (15, '2021-01-11 15:35:07', 1000, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
