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

 Date: 12/01/2021 14:52:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `staffId` int(0) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `accountNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `staffName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工名字',
  `staffSex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工性别',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工手机号',
  `staffCode` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工证件号',
  `staffPositionId` int(0) NULL DEFAULT NULL COMMENT '员工职位id',
  `startDate` date NULL DEFAULT NULL COMMENT '工作日期',
  `endDate` date NULL DEFAULT NULL COMMENT '离职日期',
  `salary` bigint(0) NULL DEFAULT NULL COMMENT '薪资',
  `status` int(0) NULL DEFAULT NULL COMMENT '员工状态(1.在职；0.离职)',
  PRIMARY KEY (`staffId`) USING BTREE,
  INDEX `username`(`accountNumber`) USING BTREE,
  INDEX `password`(`password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, 'admin', 'admin', '美港管理员', NULL, NULL, NULL, 1, '2020-12-17', NULL, NULL, 1);
INSERT INTO `staff` VALUES (2, 'zhangteng', 'zhangteng', '张腾', 'MAN', '17606103342', '13072320001121381X', 5, '2020-12-25', NULL, 5500, 1);
INSERT INTO `staff` VALUES (3, NULL, NULL, '王鹏', 'MAN', '15632145698', '130723199511203915', 5, '2021-01-08', NULL, 4500, 1);
INSERT INTO `staff` VALUES (4, NULL, NULL, '张磊', 'MAN', '16932372680', '14072319961021391X', 7, '2021-01-08', NULL, 2000, 1);
INSERT INTO `staff` VALUES (5, NULL, NULL, '李志飞', 'MAN', '15836376761', '148723188912213912', 5, '2021-01-11', NULL, 4500, 1);

SET FOREIGN_KEY_CHECKS = 1;
