/*
 Navicat Premium Data Transfer
 Source Server         : 本地数据库Root
 Source Server Type    : MySQL
 Source Schema         : Servlet

 Date: 08/06/2021 08:59:31
*/
CREATE DATABASE Servlet;
USE Servlet;
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1', '1', '1');
INSERT INTO `user` VALUES ('2', 'user', 'user', '0', '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
