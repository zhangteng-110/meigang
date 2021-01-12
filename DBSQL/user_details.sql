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

 Date: 12/01/2021 14:53:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_details
-- ----------------------------
DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details`  (
  `userCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户代码',
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `userSex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  `startDate` date NULL DEFAULT NULL COMMENT '起始日期',
  `endDate` date NULL DEFAULT NULL COMMENT '结束日期',
  `isVip` tinyint(0) NULL DEFAULT NULL COMMENT '会员（0.不是；1是）',
  `integral` bigint(0) NULL DEFAULT NULL COMMENT '积分',
  `money` bigint(0) NULL DEFAULT NULL COMMENT '卡内金额',
  `cardNumber` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  PRIMARY KEY (`userCode`) USING BTREE,
  INDEX `userCode`(`userCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_details
-- ----------------------------
INSERT INTO `user_details` VALUES ('111111111111111111', '李四', '111@163.com', '18611111112', 'WEMAN', '2020-12-23', '2020-12-31', 1, 549, 1451, NULL);
INSERT INTO `user_details` VALUES ('130222666666666668', '王五', '999@qq.com', '18911111111', 'MAN', '2020-12-23', '2020-12-24', 1, 309, 1191, NULL);
INSERT INTO `user_details` VALUES ('13072319690221381X', '张先锋', '123@163.com', '17606103342', 'MAN', '2020-12-22', '2020-12-30', 0, NULL, NULL, NULL);
INSERT INTO `user_details` VALUES ('13072319931121381X', '小明', '991104@qq.com', '18127386921', 'MAN', '2020-12-31', '2021-01-08', 1, 649, 1351, '');
INSERT INTO `user_details` VALUES ('130723199609213812', '张青', '17606103342@163.com', '17606103342', 'MAN', '2020-12-22', '2020-12-30', 1, 299, 1201, NULL);
INSERT INTO `user_details` VALUES ('130723199811213802', '小红', '191919@163.com', '17932372670', 'WEMAN', '2020-12-31', NULL, 0, NULL, NULL, '');
INSERT INTO `user_details` VALUES ('13072320001121381X', '管理员', NULL, NULL, NULL, NULL, '2020-12-24', 1, 189, 811, NULL);
INSERT INTO `user_details` VALUES ('13072320001121391X', '张腾', '910547570@qq.com', '17606103342', 'MAN', '2020-12-11', '2100-12-11', 1, 369, 2631, NULL);
INSERT INTO `user_details` VALUES ('13082319991121381X', '萧炎', '910547@qq.com', '15932373630', 'MAN', '2021-01-12', NULL, 1, 0, 2000, '558963');
INSERT INTO `user_details` VALUES ('130832199011243975', '波塞冬', '7878@qq.com', '17845453691', 'WEMAN', '2021-01-12', NULL, 1, 0, 3000, '666897');
INSERT INTO `user_details` VALUES ('131313131313131214', '张三', '123@qq.com', '16666666666', 'WEMAN', '2020-12-23', NULL, 0, NULL, NULL, NULL);
INSERT INTO `user_details` VALUES ('141333333333333335', '钱七', '789@163.com', '15122222326', 'MAN', '2020-12-23', NULL, 0, NULL, NULL, NULL);
INSERT INTO `user_details` VALUES ('143555555555444669', '周八', '963@163.com', '17912154577', 'MAN', '2020-12-23', NULL, 0, NULL, NULL, NULL);
INSERT INTO `user_details` VALUES ('153223199911213815', '小白', '910547570@qq.com', '15832355555', 'MAN', '2021-01-04', NULL, 1, 20, 480, '5559');
INSERT INTO `user_details` VALUES ('163111111111111111', '赵六', '456@qq.com', '16932355555', 'WEMAN', '2020-12-23', '2020-12-31', 1, 60, 940, NULL);

SET FOREIGN_KEY_CHECKS = 1;
