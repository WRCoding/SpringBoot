/*
 Navicat Premium Data Transfer

 Source Server         : L
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : loginweb

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 08/05/2019 14:32:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bookuser
-- ----------------------------
DROP TABLE IF EXISTS `bookuser`;
CREATE TABLE `bookuser`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_level_id` int(11) NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookuser
-- ----------------------------
INSERT INTO `bookuser` VALUES (1, 0, 'admin', '123456');
INSERT INTO `bookuser` VALUES (2, 1, 'user', '1234');
INSERT INTO `bookuser` VALUES (4, 1, 'wwj', '111');
INSERT INTO `bookuser` VALUES (10, 1, 'www', '777');
INSERT INTO `bookuser` VALUES (11, 1, 'hhh', '777');
INSERT INTO `bookuser` VALUES (12, 1, '777', 'wlj');
INSERT INTO `bookuser` VALUES (13, 1, '888', '888');
INSERT INTO `bookuser` VALUES (14, 1, '1', '1');
INSERT INTO `bookuser` VALUES (15, 1, '1', '1');
INSERT INTO `bookuser` VALUES (16, 1, '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
