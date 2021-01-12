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

 Date: 12/01/2021 14:52:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for service_items
-- ----------------------------
DROP TABLE IF EXISTS `service_items`;
CREATE TABLE `service_items`  (
  `projectId` int(0) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`projectId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_items
-- ----------------------------
INSERT INTO `service_items` VALUES (1, '男士冷烫', 'MAN');
INSERT INTO `service_items` VALUES (2, '男士精剪', 'MAN');
INSERT INTO `service_items` VALUES (3, '女士精剪', 'WEMAN');
INSERT INTO `service_items` VALUES (4, '女士羊毛卷', 'WEMAN');
INSERT INTO `service_items` VALUES (5, '女士大波浪', 'WEMAN');

SET FOREIGN_KEY_CHECKS = 1;
