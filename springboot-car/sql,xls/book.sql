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

 Date: 08/05/2019 14:32:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bookSprice` decimal(10, 2) NULL DEFAULT NULL,
  `bookAuthor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bookCount` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`bookId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 115 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '老人与海', 98.00, '海明威', 77);
INSERT INTO `book` VALUES (2, '百年孤独', 55.00, '马尔克斯', 20);
INSERT INTO `book` VALUES (4, '数据结构', 12.00, '严蔚敏', 12);
INSERT INTO `book` VALUES (5, '小猪佩奇', 20.00, '乔治', 700);
INSERT INTO `book` VALUES (19, 'python网络数据采集', 59.00, 'Ryan Mitchell', 18);
INSERT INTO `book` VALUES (35, '概率论', 11.00, '打啊', 1);
INSERT INTO `book` VALUES (36, '计算机网络', 12.00, '阿大', 2);
INSERT INTO `book` VALUES (37, '雪国', 2.00, '阿二', 3);
INSERT INTO `book` VALUES (38, '白鹿原', 22.00, '阿三', 4);
INSERT INTO `book` VALUES (39, '线性代数', 33.00, '阿四', 5);
INSERT INTO `book` VALUES (55, '啊啊', 12.00, '啊啊', 12);
INSERT INTO `book` VALUES (56, '概率论', 11.00, '打啊', 1);
INSERT INTO `book` VALUES (57, '计算机网络', 12.00, '阿大', 2);
INSERT INTO `book` VALUES (58, '雪国', 2.00, '阿二', 3);
INSERT INTO `book` VALUES (59, '白鹿原', 22.00, '阿三', 4);
INSERT INTO `book` VALUES (60, '线性代数', 33.00, '阿四', 5);
INSERT INTO `book` VALUES (61, '人生', 44.00, '阿五', 5);
INSERT INTO `book` VALUES (62, '暮光之城', 55.00, '阿六', 6);
INSERT INTO `book` VALUES (63, 'Javaweb项目实战', 55.00, '阿七', 6);
INSERT INTO `book` VALUES (64, '朝花夕拾', 66.00, '阿八', 7);
INSERT INTO `book` VALUES (65, '啊啊', 12.00, '啊啊', 12);
INSERT INTO `book` VALUES (66, '概率论', 11.00, '打啊', 1);
INSERT INTO `book` VALUES (67, '计算机网络', 12.00, '阿大', 2);
INSERT INTO `book` VALUES (68, '雪国', 2.00, '阿二', 3);
INSERT INTO `book` VALUES (69, '白鹿原', 22.00, '阿三', 4);
INSERT INTO `book` VALUES (70, '线性代数', 33.00, '阿四', 5);
INSERT INTO `book` VALUES (71, '人生', 44.00, '阿五', 5);
INSERT INTO `book` VALUES (72, '暮光之城', 55.00, '阿六', 6);
INSERT INTO `book` VALUES (73, 'Javaweb项目实战', 55.00, '阿六', 6);
INSERT INTO `book` VALUES (74, '朝花夕拾', 66.00, '阿久', 7);
INSERT INTO `book` VALUES (76, '概率论', 11.00, '打啊', 1);
INSERT INTO `book` VALUES (77, '计算机网络', 12.00, '阿大', 2);
INSERT INTO `book` VALUES (78, '雪国', 2.00, '阿二', 3);
INSERT INTO `book` VALUES (79, '白鹿原', 22.00, '阿三', 4);
INSERT INTO `book` VALUES (83, 'Javaweb项目实战', 55.00, '阿七', 6);
INSERT INTO `book` VALUES (84, '朝花夕拾', 66.00, '阿室', 7);
INSERT INTO `book` VALUES (95, '啊啊', 12.00, '啊啊', 12);
INSERT INTO `book` VALUES (96, '概率论', 11.00, '打啊', 1);
INSERT INTO `book` VALUES (97, '计算机网络', 12.00, '阿大', 2);
INSERT INTO `book` VALUES (98, '雪国', 2.00, '阿二', 3);
INSERT INTO `book` VALUES (99, '白鹿原', 22.00, '阿三', 4);
INSERT INTO `book` VALUES (100, '线性代数', 33.00, '阿四', 5);

SET FOREIGN_KEY_CHECKS = 1;
