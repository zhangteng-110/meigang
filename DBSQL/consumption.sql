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

 Date: 12/01/2021 14:52:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consumption
-- ----------------------------
DROP TABLE IF EXISTS `consumption`;
CREATE TABLE `consumption`  (
  `consumptionId` int(0) NOT NULL AUTO_INCREMENT COMMENT '消费记录id',
  `consumptionDate` datetime(0) NULL DEFAULT NULL COMMENT '消费时间',
  `consumptionMoney` bigint(0) NULL DEFAULT NULL COMMENT '消费金额',
  `userId` tinyint(0) NULL DEFAULT NULL COMMENT '用户id',
  `consumptionStatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消费状态',
  `integral` bigint(0) NULL DEFAULT NULL COMMENT '积分',
  `projectId` tinyint(0) NULL DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`consumptionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumption
-- ----------------------------
INSERT INTO `consumption` VALUES (1, '2021-01-06 13:20:09', 20, 15, '1', 20, 1);
INSERT INTO `consumption` VALUES (2, '2021-01-06 13:25:00', 299, 20, '1', 299, 2);
INSERT INTO `consumption` VALUES (3, '2021-01-07 15:29:50', 499, 23, '1', 499, 4);
INSERT INTO `consumption` VALUES (4, '2021-01-08 09:29:33', 289, 24, '1', 289, 2);
INSERT INTO `consumption` VALUES (5, '2021-01-08 09:30:10', 20, 23, '1', 20, 3);
INSERT INTO `consumption` VALUES (6, '2021-01-08 09:30:23', 30, 25, '1', 30, 1);
INSERT INTO `consumption` VALUES (7, '2021-01-08 09:30:31', 20, 34, '1', 20, 2);
INSERT INTO `consumption` VALUES (8, '2021-01-08 09:31:39', 599, 31, '1', 599, 3);
INSERT INTO `consumption` VALUES (9, '2021-01-11 15:33:19', 289, 15, '1', 289, 1);
INSERT INTO `consumption` VALUES (10, '2021-01-11 15:34:25', 20, 24, '1', 20, 2);
INSERT INTO `consumption` VALUES (11, '2021-01-11 15:34:34', 20, 31, '1', 20, 2);
INSERT INTO `consumption` VALUES (12, '2021-01-11 15:35:16', 189, 1, '1', 189, 3);
INSERT INTO `consumption` VALUES (13, '2021-01-12 09:26:05', 30, 25, '1', 30, 3);
INSERT INTO `consumption` VALUES (14, '2021-01-12 09:28:36', 30, 31, '1', 30, 2);
INSERT INTO `consumption` VALUES (15, '2021-01-12 09:30:36', 30, 23, '1', 30, 3);
INSERT INTO `consumption` VALUES (16, '2021-01-12 09:40:38', 30, 15, '1', 30, 2);
INSERT INTO `consumption` VALUES (17, '2021-01-12 09:44:27', 30, 15, '1', 30, 2);

SET FOREIGN_KEY_CHECKS = 1;
