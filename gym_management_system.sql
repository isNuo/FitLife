SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_account` int NOT NULL COMMENT '管理员账号',
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1001, '123456');
INSERT INTO `admin` VALUES (1002, '123456');
INSERT INTO `admin` VALUES (1003, '123456');


# -- ----------------------------
# -- Table structure for coach_table
# -- ----------------------------
# DROP TABLE IF EXISTS `coach_table`;
# CREATE TABLE `coach_table`  (
#                           `coach_account` int NOT NULL COMMENT '教练账号',
#                           `coach_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456' COMMENT '教练密码',
#                           `coach_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教练姓名',
#                           `coach_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教练性别',
#                           `coach_age` int NULL DEFAULT NULL COMMENT '教练年龄',
#                           `entry_time` date NULL DEFAULT NULL COMMENT '入职时间',
#                           `class_id` int NOT NULL DEFAULT 0 COMMENT '指导课程id',
#                           `coach_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
#                           PRIMARY KEY (`coach_account`) USING BTREE,
#                           FOREIGN KEY (`class_id`) references class_table(`class_id`)
# ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
#
# -- ----------------------------
# -- Records of coach_table
# -- ----------------------------
# INSERT INTO `coach_table` VALUES (101038721, '123456', '张晓', '女', 26, '2023-06-29', 0001, '健美冠军');
# INSERT INTO `coach_table` VALUES (101068283, '123456', '李铭', '男', 34, '2023-01-06', 0004, '职业教练');
# INSERT INTO `coach_table` VALUES (101053687, '123456', '王磊', '男', 30, '2023-06-06', 0007, '职业教练');
# INSERT INTO `coach_table` VALUES (101045354, '123456', '张天鸣', '男', 24, '2023-01-07', 0009 , '职业教练');


-- ----------------------------
-- Table structure for new coach
-- ----------------------------
DROP TABLE IF EXISTS `coach_table`;
CREATE TABLE `coach_table`  (
                          `coach_account` int NOT NULL COMMENT '教练账号',
                          `coach_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456' COMMENT '教练密码',
                          `coach_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教练姓名',
                          `coach_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教练性别',
                          `coach_age` int NULL DEFAULT NULL COMMENT '教练年龄',
                          `entry_time` date NULL DEFAULT NULL COMMENT '入职时间',
                          `coach_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
                          PRIMARY KEY (`coach_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of new coach_table
-- ----------------------------
INSERT INTO `coach_table` VALUES (101038721, '123456', '张晓', '女', 26, '2023-06-29', '健美冠军');
INSERT INTO `coach_table` VALUES (101068283, '123456', '李铭', '男', 34, '2023-01-06', '职业教练');
INSERT INTO `coach_table` VALUES (101053687, '123456', '王磊', '男', 30, '2023-06-06', '格斗冠军');
INSERT INTO `coach_table` VALUES (101045354, '123456', '张天鸣', '男', 24, '2023-01-07', '职业教练');


# -- ----------------------------
# -- Table structure for class_table
# -- ----------------------------
# DROP TABLE IF EXISTS `class_table`;
# CREATE TABLE `class_table`  (
#   `class_id` int NOT NULL DEFAULT 0 COMMENT '课程id',
#   `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
#   `class_begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课时间',
#   `class_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程时长',
#   `coach` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教练',
#   PRIMARY KEY (`class_id`) USING BTREE
# ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
# -- ----------------------------
# -- Records of class_table
# -- ----------------------------
# INSERT INTO `class_table` VALUES (0001, '增肌', '2023年1月1日 15:00', '60分钟', '增肌教练');
# INSERT INTO `class_table` VALUES (0002, '瑜伽', '2023年1月2日 10:20', '90分钟', '瑜伽教练');
# INSERT INTO `class_table` VALUES (0003, '减脂', '2023年3月6日 18:00', '90分钟', '减脂教练');
# INSERT INTO `class_table` VALUES (0004, '运动康复', '2023年2月2日 10:00', '45分钟', '运动康复教练');
# INSERT INTO `class_table` VALUES (0005, '综合格斗', '2023年2月3日 15:00', '60分钟', '综合格斗教练');
# INSERT INTO `class_table` VALUES (0006, '塑形', '2023年2月3日 15:00', '60分钟', '塑形教练');
# INSERT INTO `class_table` VALUES (0007, '普拉提', '2023年3月1日 17:30', '60分钟', '普拉提教练');
# INSERT INTO `class_table` VALUES (0008, '爵士舞', '2023年2月22日 09:00', '90分钟', '爵士舞教练');
# INSERT INTO `class_table` VALUES (0009, '杠铃操', '2023年2月4日 15:00', '60分钟', '杠铃操教练');
# INSERT INTO `class_table` VALUES (0010, '动感单车', '2023年3月8日 15:00', '45分钟', '动感单车教练');
# INSERT INTO `class_table` VALUES (0011, '健美操', '2023年2月22日 18:00', '60分钟', '健美操教练');

-- ----------------------------
-- Table structure for new class_table
-- ----------------------------
DROP TABLE IF EXISTS `class_table`;
CREATE TABLE `class_table`  (
#                                 `class_id` int NOT NULL DEFAULT 0 COMMENT '课程id',
                                `class_id` int Auto_Increment COMMENT '课程id',
                                `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
                                `class_begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课时间',
                                `class_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程时长',
                                `class_amount` int NOT NULL comment '课程费用（元）',
                                `coach_account` int NOT NULL COMMENT '教练账号',
                                PRIMARY KEY (`class_id`) USING BTREE,
                                foreign key (`coach_account`) references coach_table(`coach_account`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- ----------------------------
-- Records of new class_table
-- ----------------------------
INSERT INTO `class_table` VALUES (0001, '增肌', '2024年1月1日 15:00', '60分钟', 30, 101068283);
INSERT INTO `class_table` VALUES (0002, '瑜伽', '2024年1月2日 10:20', '90分钟', 45, 101038721);
INSERT INTO `class_table` VALUES (0003, '减脂', '2024年3月6日 18:00', '90分钟', 40, 101053687);
INSERT INTO `class_table` VALUES (0004, '运动康复', '2024年2月2日 10:00', '45分钟', 30, 101053687);
INSERT INTO `class_table` VALUES (0005, '综合格斗', '2024年2月3日 15:00', '60分钟', 50, 101068283);
INSERT INTO `class_table` VALUES (0006, '塑形', '2024年2月3日 15:00', '60分钟', 35, 101045354);
INSERT INTO `class_table` VALUES (0007, '普拉提', '2024年3月1日 17:30', '60分钟', 45, 101038721);
INSERT INTO `class_table` VALUES (0008, '爵士舞', '2024年2月22日 09:00', '90分钟', 55, 101038721);
INSERT INTO `class_table` VALUES (0009, '杠铃操', '2024年2月4日 15:00', '60分钟', 30, 101045354);
INSERT INTO `class_table` VALUES (0010, '动感单车', '2024年3月8日 15:00', '45分钟', 25, 101053687);
INSERT INTO `class_table` VALUES (0011, '健美操', '2024年2月22日 18:00', '60分钟', 30, 101038721);


# -- ----------------------------
# -- Table structure for class_order
# -- ----------------------------
# DROP TABLE IF EXISTS `class_order`;
# CREATE TABLE `class_order`  (
#   `class_order_id` int NOT NULL AUTO_INCREMENT COMMENT '报名表id',
#   `class_id` int NULL DEFAULT NULL COMMENT '课程id',
#   `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
#   `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员姓名',
#   `member_account` int NULL DEFAULT NULL COMMENT '会员账号',
#   `class_begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课时间',
#   PRIMARY KEY (`class_order_id`) USING BTREE
# ) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
# -- ----------------------------
# -- Records of class_order
# -- ----------------------------
# INSERT INTO `class_order` VALUES (1, 0002, '瑜伽', '瑜伽教练', '李四', 202100788, '2024年1月2日 10:20');
# INSERT INTO `class_order` VALUES (2, 0002, '瑜伽', '瑜伽教练', '王五', 202132539, '2024年1月2日 10:20');
# INSERT INTO `class_order` VALUES (3, 0004, '运动康复', '运动康复教练', 'Mike', 202156754, '2024年2月2日 10:00');
# INSERT INTO `class_order` VALUES (4, 0001, '增肌', '增肌教练', 'Mike', 202156754, '2024年1月1日 15:00');
# INSERT INTO `class_order` VALUES (5, 0001, '增肌', '增肌教练', 'Tylor', 202183406, '2024年1月1日 15:00');
# INSERT INTO `class_order` VALUES (6, 0002, '瑜伽', '瑜伽教练', 'Tylor', 202183406, '2024年1月2日 10:20');
# INSERT INTO `class_order` VALUES (7, 0001, '增肌', '增肌教练', '李四', 202100788, '2024年1月1日 15:00');
# INSERT INTO `class_order` VALUES (8, 0001, '增肌', '增肌教练', '马六', 202186416, '2024年1月1日 15:00');
# INSERT INTO `class_order` VALUES (9, 0003, '减脂', '减脂教练', '马六', 202186416, '2024年3月6日 18:00');
# INSERT INTO `class_order` VALUES (10, 0003, '减脂', '减脂教练', 'Lily', 202123664, '2024年3月6日 18:00');
# INSERT INTO `class_order` VALUES (11, 0003, '减脂', '减脂教练', 'Emma', 202153468, '2024年3月6日 18:00');


-- ----------------------------
-- Table structure for new class_order
-- ----------------------------
DROP TABLE IF EXISTS `class_order`;
CREATE TABLE `class_order`  (
                                `class_order_id` int NOT NULL AUTO_INCREMENT COMMENT '报名表id',
                                `class_id` int NULL DEFAULT NULL COMMENT '课程id',
                                `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
                                `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员姓名',
                                `member_account` int NULL DEFAULT NULL COMMENT '会员账号',
                                `class_begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课时间',
                                PRIMARY KEY (`class_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- ----------------------------
-- Records of new class_order
-- ----------------------------
INSERT INTO `class_order` VALUES (1, 0002, '瑜伽', '李四', 202100788, '2024年1月2日 10:20');
INSERT INTO `class_order` VALUES (2, 0002, '瑜伽', '王五', 202132539, '2024年1月2日 10:20');
INSERT INTO `class_order` VALUES (3, 0004, '运动康复', 'Mike', 202156754, '2024年2月2日 10:00');
INSERT INTO `class_order` VALUES (4, 0001, '增肌', 'Mike', 202156754, '2024年1月1日 15:00');
INSERT INTO `class_order` VALUES (5, 0001, '增肌', 'Tylor', 202183406, '2024年1月1日 15:00');
INSERT INTO `class_order` VALUES (6, 0002, '瑜伽', 'Tylor', 202183406, '2024年1月2日 10:20');
INSERT INTO `class_order` VALUES (7, 0001, '增肌', '李四', 202100788, '2024年1月1日 15:00');
INSERT INTO `class_order` VALUES (8, 0001, '增肌', '马六', 202186416, '2024年1月1日 15:00');
INSERT INTO `class_order` VALUES (9, 0003, '减脂', '马六', 202186416, '2024年3月6日 18:00');
INSERT INTO `class_order` VALUES (10, 0003, '减脂', 'Lily', 202123664, '2024年3月6日 18:00');
INSERT INTO `class_order` VALUES (11, 0003, '减脂', 'Emma', 202153468, '2024年3月6日 18:00');


# -- ----------------------------
# -- Table structure for member
# -- ----------------------------
# DROP TABLE IF EXISTS `member`;
# CREATE TABLE `member`  (
#   `member_account` int NOT NULL COMMENT '会员账号',
#   `member_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456' COMMENT '会员密码',
#   `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员姓名',
#   `member_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '会员性别',
#   `member_age` int NULL DEFAULT NULL COMMENT '会员年龄',
#   `member_height` int NULL DEFAULT NULL COMMENT '会员身高',
#   `member_weight` int NULL DEFAULT NULL COMMENT '会员体重',
#   `member_phone` bigint NULL DEFAULT NULL COMMENT '会员电话',
#   `card_time` date NULL DEFAULT NULL COMMENT '办卡时间',
#   `card_class` int NULL DEFAULT NULL COMMENT '购买课时',
#   `card_next_class` int NULL DEFAULT NULL COMMENT '剩余课时',
#   PRIMARY KEY (`member_account`) USING BTREE
# ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
# -- ----------------------------
# -- Records of member
# -- ----------------------------
# INSERT INTO `member` VALUES (202009867, '123456', '张三', '女', 24, 182, 60, 13515548482, '2024-03-05', 40, 40);
# INSERT INTO `member` VALUES (202100788, '123456', '李四', '男', 31, 178, 60, 13131554873, '2024-01-01', 50, 50);
# INSERT INTO `member` VALUES (202132539, '123456', '王五', '男', 31, 178, 60, 13154875489, '2024-01-01', 40, 40);
# INSERT INTO `member` VALUES (202186416, '123456', '马六', '女', 23, 160, 45, 13124576857, '2024-01-16', 30, 30);
# INSERT INTO `member` VALUES (202106725, '123456', 'Tom', '男', 24, 178, 88, 13758784959, '2024-02-26', 30, 30);
# INSERT INTO `member` VALUES (202183406, '123456', 'Tylor', '女', 19, 170, 60, 13786457488,'2024-02-27', 30, 30);
# INSERT INTO `member` VALUES (202176587, '123456', 'Jack', '男', 33, 177, 90, 13767546666, '2024-02-27', 30, 30);
# INSERT INTO `member` VALUES (202156754, '123456', 'Mike', '男', 36, 166, 67, 13786532448, '2024-02-28', 30, 30);
# INSERT INTO `member` VALUES (202153468, '123456', 'Emma', '女', 25, 173, 44, 13786457124,  '2024-03-01', 50, 50);
# INSERT INTO `member` VALUES (202121345, '123456', 'Ava', '女', 28, 160, 40, 13754457488, '2024-03-02', 30, 30);
# INSERT INTO `member` VALUES (202189776, '123456', 'Chloe', '女', 27, 170, 50, 13986337489,  '2024-03-23', 30, 30);
# INSERT INTO `member` VALUES (202123664, '123456', 'Lily', '女', 25, 165, 51, 15986457423,  '2024-03-27', 30, 30);


# -- ----------------------------
# -- Table structure for new member
# -- ----------------------------
# DROP TABLE IF EXISTS `member`;
# CREATE TABLE `member`  (
#                            `member_account` int NOT NULL COMMENT '会员账号',
#                            `member_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456' COMMENT '会员密码',
#                            `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员姓名',
#                            `member_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '会员性别',
#                            `member_age` int NULL DEFAULT NULL COMMENT '会员年龄',
#                            `member_height` int NULL DEFAULT NULL COMMENT '会员身高',
#                            `member_weight` int NULL DEFAULT NULL COMMENT '会员体重',
#                            `member_phone` bigint NULL DEFAULT NULL COMMENT '会员电话',
#                            `card_time` date NULL DEFAULT NULL COMMENT '办卡时间',
#                            `card_balance` int NULL DEFAULT NULL COMMENT '账户余额',
#                            `card_remain_class` int NULL DEFAULT NULL COMMENT '剩余课时',
#                            PRIMARY KEY (`member_account`) USING BTREE
# ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
# -- ----------------------------
# -- Records of new member
# -- ----------------------------
# INSERT INTO `member` VALUES (202009867, '123456', '张三', '女', 24, 182, 60, 13515548482, '2023-03-05', 400, 40);
# INSERT INTO `member` VALUES (202100788, '123456', '李四', '男', 31, 178, 60, 13131554873, '2023-01-01', 100, 50);
# INSERT INTO `member` VALUES (202132539, '123456', '王五', '男', 31, 178, 60, 13154875489, '2023-01-01', 400, 40);
# INSERT INTO `member` VALUES (202186416, '123456', '马六', '女', 23, 160, 45, 13124576857, '2023-01-16', 100, 30);
# INSERT INTO `member` VALUES (202106725, '123456', 'Tom', '男', 24, 178, 88, 13758784959, '2023-02-26', 600, 30);
# INSERT INTO `member` VALUES (202183406, '123456', 'Tylor', '女', 19, 170, 60, 13786457488,'2023-02-27', 200, 30);
# INSERT INTO `member` VALUES (202176587, '123456', 'Jack', '男', 33, 177, 90, 13767546666, '2023-02-27', 500, 30);
# INSERT INTO `member` VALUES (202156754, '123456', 'Mike', '男', 36, 166, 67, 13786532448, '2023-02-28', 400, 30);
# INSERT INTO `member` VALUES (202153468, '123456', 'Emma', '女', 25, 173, 44, 13786457124,  '2023-03-01', 500, 50);
# INSERT INTO `member` VALUES (202121345, '123456', 'Ava', '女', 28, 160, 40, 13754457488, '2023-03-02', 100, 30);
# INSERT INTO `member` VALUES (202189776, '123456', 'Chloe', '女', 27, 170, 50, 13986337489,  '2023-03-23', 400, 30);
# INSERT INTO `member` VALUES (202123664, '123456', 'Lily', '女', 25, 165, 51, 15986457423,  '2023-03-27', 200, 30);


-- ----------------------------
-- Table structure for new member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
                           `member_account` int NOT NULL COMMENT '会员账号',
                           `member_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456' COMMENT '会员密码',
                           `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员姓名',
                           `member_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '会员性别',
                           `member_age` int NULL DEFAULT NULL COMMENT '会员年龄',
                           `member_height` int NULL DEFAULT NULL COMMENT '会员身高',
                           `member_weight` int NULL DEFAULT NULL COMMENT '会员体重',
                           `member_phone` bigint NULL DEFAULT NULL COMMENT '会员电话',
                           `card_time` date NULL DEFAULT NULL COMMENT '办卡时间',
                           `card_balance` int NULL DEFAULT NULL COMMENT '账户余额（元）',
                           PRIMARY KEY (`member_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- ----------------------------
-- Records of new member
-- ----------------------------
INSERT INTO `member` VALUES (202009867, '123456', '张三', '女', 24, 182, 60, 13515548482, '2023-03-05', 400);
INSERT INTO `member` VALUES (202100788, '123456', '李四', '男', 31, 178, 60, 13131554873, '2023-01-01', 100);
INSERT INTO `member` VALUES (202132539, '123456', '王五', '男', 31, 178, 60, 13154875489, '2023-01-01', 400);
INSERT INTO `member` VALUES (202186416, '123456', '马六', '女', 23, 160, 45, 13124576857, '2023-01-16', 100);
INSERT INTO `member` VALUES (202106725, '123456', 'Tom', '男', 24, 178, 88, 13758784959, '2023-02-26', 600);
INSERT INTO `member` VALUES (202183406, '123456', 'Tylor', '女', 19, 170, 60, 13786457488,'2023-02-27', 200);
INSERT INTO `member` VALUES (202176587, '123456', 'Jack', '男', 33, 177, 90, 13767546666, '2023-02-27', 500);
INSERT INTO `member` VALUES (202156754, '123456', 'Mike', '男', 36, 166, 67, 13786532448, '2023-02-28', 400);
INSERT INTO `member` VALUES (202153468, '123456', 'Emma', '女', 25, 173, 44, 13786457124,  '2023-03-01', 500);
INSERT INTO `member` VALUES (202121345, '123456', 'Ava', '女', 28, 160, 40, 13754457488, '2023-03-02', 100);
INSERT INTO `member` VALUES (202189776, '123456', 'Chloe', '女', 27, 170, 50, 13986337489,  '2023-03-23', 400);
INSERT INTO `member` VALUES (202123664, '123456', 'Lily', '女', 25, 165, 51, 15986457423,  '2023-03-27', 200);


-- ----------------------------
-- Table structure for member_payment 充值记录
-- ----------------------------
DROP TABLE IF EXISTS `member_payment`;
CREATE TABLE `member_payment`  (
                           `member_payment_id` int NOT NULL AUTO_INCREMENT COMMENT '缴费记录id',
                           `member_account` int NOT NULL COMMENT '会员账号',
                           `recharge_amount` int NULL DEFAULT NULL COMMENT '充值金额',
                           `recharge_time` date NULL DEFAULT NULL COMMENT '充值时间',
                           PRIMARY KEY (`member_payment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- ----------------------------
-- Records of member_payment
-- ----------------------------
INSERT INTO `member_payment` VALUES (1, 202009867, 400, '2023-03-17');
INSERT INTO `member_payment` VALUES (2, 202100788, 100, '2023-04-09');
INSERT INTO `member_payment` VALUES (3, 202106725, 600, '2023-06-25');
INSERT INTO `member_payment` VALUES (4, 202121345, 100, '2023-09-05');
INSERT INTO `member_payment` VALUES (5, 202123664, 200, '2023-12-05');
INSERT INTO `member_payment` VALUES (6, 202132539, 400, '2024-01-05');
INSERT INTO `member_payment` VALUES (7, 202153468, 500, '2024-01-17');
INSERT INTO `member_payment` VALUES (8, 202156754, 400, '2024-02-01');
INSERT INTO `member_payment` VALUES (9, 202176587, 500, '2024-02-01');
INSERT INTO `member_payment` VALUES (10, 202183406, 200, '2024-03-06');
INSERT INTO `member_payment` VALUES (11, 202186416, 100, '2024-03-11');
INSERT INTO `member_payment` VALUES (12, 202189776, 400, '2024-03-20');



# -- ----------------------------
# -- Table structure for employee
# -- ----------------------------
# DROP TABLE IF EXISTS `employee`;
# CREATE TABLE `employee`  (
#     `employee_account` int NOT NULL COMMENT '员工账号',
#     `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
#     `employee_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工性别',
#     `employee_age` int NULL DEFAULT NULL COMMENT '员工年龄',
#     `entry_time` date NULL DEFAULT NULL COMMENT '入职时间',
#     `staff` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务',
#     `employee_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
#     PRIMARY KEY (`employee_account`) USING BTREE
# ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
#
# -- ----------------------------
# -- Records of employee
# -- ----------------------------
# INSERT INTO `employee` VALUES (101038721,  '教练1', '女', 26, '2016-06-29', '健身教练', '健美冠军');
# INSERT INTO `employee` VALUES (101068283,  '教练2', '男', 34, '2020-01-06', '健身教练', '职业教练');
# INSERT INTO `employee` VALUES (101053687,  '教练3', '男', 30, '2020-06-06', '健身教练', '职业教练');
# INSERT INTO `employee` VALUES (101045354,  '教练4', '男', 24, '2021-01-07', '健身教练', '职业教练');
# INSERT INTO `employee` VALUES (101058973,  '保洁1', '女', 48, '2019-08-24', '保洁员', '模范员工');
# INSERT INTO `employee` VALUES (101034208,  '保洁2', '女', 48, '2010-08-01', '保洁员', '');



# -- ----------------------------
# -- Table structure for equipment
# -- ----------------------------
# DROP TABLE IF EXISTS `equipment`;
# CREATE TABLE `equipment`  (
#   `equipment_id` int NOT NULL AUTO_INCREMENT COMMENT '器材id',
#   `equipment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '器材名称',
#   `equipment_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '器材位置',
#   `equipment_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '器材状态',
#   `equipment_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '器材备注信息',
#   PRIMARY KEY (`equipment_id`) USING BTREE
# ) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
#
# -- ----------------------------
# -- Records of equipment
# -- ----------------------------
# INSERT INTO `equipment` VALUES (1, '哑铃1', '1号房间', '正常', '');
# INSERT INTO `equipment` VALUES (2, '杠铃1', '2号房间', '损坏', '待维修');
# INSERT INTO `equipment` VALUES (3, '跑步机1', '2号房间', '维修中', '联系厂家维修');
# INSERT INTO `equipment` VALUES (4, '跑步机2', '2号房间', '正常', '');
# INSERT INTO `equipment` VALUES (5, '跑步机3', '2号房间', '正常', '');
# INSERT INTO `equipment` VALUES (6, '杠铃1', '1号房间', '正常', '');
# INSERT INTO `equipment` VALUES (7, '杠铃2', '1号房间', '正常', '');

-- ----------------------------
-- Table structure for new equipment
-- ----------------------------
DROP TABLE IF EXISTS equipment;
CREATE TABLE equipment (
                           equipment_id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
                           equipment_name VARCHAR(255) COMMENT '器材名称',
                           equipment_location VARCHAR(255) COMMENT '器材位置',
                           equipment_status VARCHAR(255) COMMENT '器材状态',
                           unit_price DECIMAL(10, 2) COMMENT '器材单价',
                           equipment_number int NOT NULL COMMENT '购买数量',
                           purchase_time date COMMENT '购买时间',
                           equipment_message VARCHAR(255) COMMENT '备注信息'
)ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- ----------------------------
-- Records of new equipment
-- ----------------------------
INSERT INTO equipment (equipment_id, equipment_name, equipment_location, equipment_status, unit_price, equipment_number, purchase_time, equipment_message)
VALUES (1,'哑铃', '1号房间', '正常', 50, 10, '2023-06-18', ''),
       (2,'杠铃', '1号房间', '损坏', 100, 5, '2023-12-20', ''),
       (3,'跑步机', '2号房间', '正常', 50, 15, '2024-2-1', '');


# -- ----------------------------
# -- Table structure for checkin_table
# -- ----------------------------
# CREATE TABLE `checkin_table`  (
#                                   `id` INT AUTO_INCREMENT PRIMARY KEY COMMENT'自增长数字',
#                                   `member_account` int(20) COMMENT '会员账号',
#                                   `checkin_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打卡日期',
#                                   `checkin_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打卡描述',
#                                   `checkin_image_path` VARCHAR(255) COMMENT '图片路径'
# )ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;




SET FOREIGN_KEY_CHECKS = 1;
