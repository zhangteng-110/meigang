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

 Date: 12/01/2021 14:52:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户主键\r\n',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `userCode` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  PRIMARY KEY (`userId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `userCode`(`userCode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '13072320001121381X');
INSERT INTO `user` VALUES (15, 'zhangteng', 'zhangteng', '13072320001121391X');
INSERT INTO `user` VALUES (20, NULL, NULL, '130723199609213812');
INSERT INTO `user` VALUES (21, NULL, NULL, '13072319690221381X');
INSERT INTO `user` VALUES (22, NULL, NULL, '131313131313131214');
INSERT INTO `user` VALUES (23, NULL, NULL, '111111111111111111');
INSERT INTO `user` VALUES (24, NULL, NULL, '130222666666666668');
INSERT INTO `user` VALUES (25, NULL, NULL, '163111111111111111');
INSERT INTO `user` VALUES (26, NULL, NULL, '141333333333333335');
INSERT INTO `user` VALUES (27, NULL, NULL, '143555555555444669');
INSERT INTO `user` VALUES (31, NULL, NULL, '13072319931121381X');
INSERT INTO `user` VALUES (32, NULL, NULL, '130723199811213802');
INSERT INTO `user` VALUES (34, NULL, NULL, '153223199911213815');
INSERT INTO `user` VALUES (35, NULL, NULL, '13082319991121381X');
INSERT INTO `user` VALUES (36, NULL, NULL, '130832199011243975');

SET FOREIGN_KEY_CHECKS = 1;
