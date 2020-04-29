/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : kjcc_cloud

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 29/04/2020 14:54:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `parent_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父账户名，创建子账户时所用',
  `company` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户所在公司',
  `cpy_branch` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司所属分支',
  `user_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户IP',
  `upload_amount` int(11) NULL DEFAULT NULL COMMENT '上传文件总数量',
  `upload_residue` int(11) NULL DEFAULT NULL COMMENT '文件上传剩余数量',
  `status` int(11) NULL DEFAULT NULL COMMENT '用户状态：1正常     -1禁用',
  `role` int(11) NOT NULL COMMENT '用户权限，对应权限表',
  `pwd_role` int(11) NULL DEFAULT -1 COMMENT '用户䬪可以自己修改密码：1 可以  -1不可以',
  `createtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '用户创建时间',
  `start_time` date NULL DEFAULT NULL COMMENT '用户有效开始时间',
  `end_time` date NULL DEFAULT NULL COMMENT '用户有效结束时间',
  `phone_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `mail` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '本系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$w5HfTqBR7QTkLDKcj95nLuKEKuZ0HFR/1bdFVcHlhs8ZWH/x82n9a', '', '1', '总公司', '89', 299856, 299849, 1, 1, 1, '2019-07-15 08:54:04', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (27, 'admin1', '$2a$10$XlftNY9T52IbLlVAT6Nx7ezyYlcSFkVzC.3n3h5jihyzo1g/KtAPa', 'admin', '科研诚信', NULL, '89', 3, 0, 1, 2, 1, '2020-04-15 17:13:56', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
