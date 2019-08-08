/*
 Navicat Premium Data Transfer

 Source Server         : localhost-本地
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : bootdo

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 08/08/2019 15:06:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ds_score_match
-- ----------------------------
DROP TABLE IF EXISTS `ds_score_match`;
CREATE TABLE `ds_score_match`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `match` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '赛事',
  `match_bg` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '赛事背景',
  `selection` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '精选',
  `start_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '开赛时间',
  `host_team` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主队',
  `host_rank` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主队排名',
  `host_red` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主队红牌',
  `host_yellow` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主队黄牌',
  `over_score` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '全场比分',
  `guest_team` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客队',
  `guest_rank` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客队排名',
  `guest_red` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客队红牌',
  `guest_yellow` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客队黄牌',
  `half_score` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '半场比分',
  `let_ball` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '初让球',
  `size_ball` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '初大小球',
  `corner_ball` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '初角球',
  `half_corner` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '半场角球比分',
  `over_corner` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '全场角球比分',
  `match_time` datetime(0) NULL DEFAULT NULL COMMENT '赛事日期时间',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_match`(`match`) USING BTREE,
  INDEX `idx_start_time`(`start_time`) USING BTREE,
  INDEX `idx_half_score`(`half_score`) USING BTREE,
  INDEX `idx_over_score`(`over_score`) USING BTREE,
  INDEX `idx_host_team`(`host_team`) USING BTREE,
  INDEX `idx_guest_team`(`guest_team`) USING BTREE,
  INDEX `idx_let_ball`(`let_ball`) USING BTREE,
  INDEX `idx_size_ball`(`size_ball`) USING BTREE,
  INDEX `idx_corner_ball`(`corner_ball`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
