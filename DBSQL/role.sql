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

 Date: 12/01/2021 14:52:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `roleId` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '董事');
INSERT INTO `role` VALUES (2, '股东');
INSERT INTO `role` VALUES (3, '店长');
INSERT INTO `role` VALUES (4, '经理');
INSERT INTO `role` VALUES (5, '大工');
INSERT INTO `role` VALUES (6, '小工');
INSERT INTO `role` VALUES (7, '学徒');

SET FOREIGN_KEY_CHECKS = 1;
