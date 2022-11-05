/*
 Navicat Premium Data Transfer

 Source Server         : tx_mysql
 Source Server Type    : MySQL
 Source Server Version : 50739
 Source Host           : www.cxaou.com:3306
 Source Schema         : the_test_system

 Target Server Type    : MySQL
 Target Server Version : 50739
 File Encoding         : 65001

 Date: 05/11/2022 17:59:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for affiche
-- ----------------------------
DROP TABLE IF EXISTS `affiche`;
CREATE TABLE `affiche`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `create_id` bigint(20) NOT NULL COMMENT '创建者 id',
  `update_id` bigint(20) NOT NULL COMMENT '修改者 id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间 ',
  `type` int(4) NOT NULL COMMENT '公告类型 0 系统公告 1 教师公告',
  `data` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告内容',
  `affiche_static` int(4) NOT NULL DEFAULT 0 COMMENT '0 发布中， 1 已近回收',
  `is_delete` int(4) NOT NULL DEFAULT 0 COMMENT '是否删除公告 0 否 1 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of affiche
-- ----------------------------
INSERT INTO `affiche` VALUES (1, 0, 0, '2022-10-29 12:40:05', '2022-10-29 12:40:12', 0, '测试', 1, 0);
INSERT INTO `affiche` VALUES (2, 0, 0, '2022-10-30 00:00:00', '2022-10-30 00:00:00', 0, '测试1', 1, 0);
INSERT INTO `affiche` VALUES (3, 1585813386104492034, 1585813386104492034, '2022-10-29 13:05:15', '2022-10-29 13:05:22', 1, '测试2', 0, 0);
INSERT INTO `affiche` VALUES (4, 1585544271687155714, 1585544271687155714, '2022-10-30 00:00:00', '2022-10-30 00:00:00', 1, 'admin测试PUT方法', 0, 0);
INSERT INTO `affiche` VALUES (1586917378054238210, 0, 0, '2022-10-31 00:00:00', '2022-10-31 00:00:00', 0, '考试系统正式上线', 0, 0);

-- ----------------------------
-- Table structure for examination_paper
-- ----------------------------
DROP TABLE IF EXISTS `examination_paper`;
CREATE TABLE `examination_paper`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '试卷科目',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_name` bigint(20) NOT NULL COMMENT '创建人 ',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `update_name` bigint(20) NOT NULL COMMENT '修改人',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍试卷题型',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `duration` time(0) NOT NULL COMMENT '考试时长',
  `test_scores` double(11, 0) NOT NULL COMMENT '试卷分值',
  `is_delete` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '0 存在 1 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examination_paper
-- ----------------------------
INSERT INTO `examination_paper` VALUES (1, '1+x', '2022-10-22 19:14:23', 0, '2022-11-05 13:56:06', 0, '点击开始评测即计时开始，中途关闭页面再进入不会重新计时，本评测共有3个部分，共55道题目，限时240分钟', '1+X云计算平台运维与开发认证（中级）样卷A', '04:00:00', 1010, '0');
INSERT INTO `examination_paper` VALUES (1587437104111140866, '1+x', '2022-11-01 00:00:00', 0, '2022-11-02 00:00:00', 0, '点击开始评测即计时开始，中途关闭页面再进入不会重新计时，本评测共有3个部分，共55道题目，限时240分钟', '1+X云计算平台运维与开发认证（中级）样卷A', '04:00:00', 1030, '0');
INSERT INTO `examination_paper` VALUES (1587604117206880258, '1+x测试', '2022-11-02 00:00:00', 1585544271687155714, '2022-11-02 00:00:00', 1585544271687155714, '点击开始评测即计时开始，中途关闭页面再进入不会重新计时，本评测共有3个部分，共55道题目，限时240分钟', '1+X云计算平台运维与开发认证（中级）样卷A', '04:00:00', 1030, '0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1585917503648825346, 1);
INSERT INTO `student` VALUES (1585917504328302594, 2);
INSERT INTO `student` VALUES (1585917504860979202, 5);
INSERT INTO `student` VALUES (1585917505318158338, 6);
INSERT INTO `student` VALUES (1585917505976664066, 7);
INSERT INTO `student` VALUES (1585917506496757762, 8);
INSERT INTO `student` VALUES (1585917508002512898, 9);
INSERT INTO `student` VALUES (1585917509176918018, 10);
INSERT INTO `student` VALUES (1585917510556844033, 20);
INSERT INTO `student` VALUES (1585917511404093441, 28);
INSERT INTO `student` VALUES (1585917513119563778, 29);
INSERT INTO `student` VALUES (1585917514881171458, 31);
INSERT INTO `student` VALUES (1585917515728420865, 35);
INSERT INTO `student` VALUES (1585917516902825985, 46);
INSERT INTO `student` VALUES (1585917517754269698, 63);
INSERT INTO `student` VALUES (1585917518551187457, 64);
INSERT INTO `student` VALUES (1585917519994028034, 71);
INSERT INTO `student` VALUES (1585917520778362882, 73);
INSERT INTO `student` VALUES (1585917521311039490, 83);
INSERT INTO `student` VALUES (1585917521831133185, 94);
INSERT INTO `student` VALUES (1585917522359615490, 98);
INSERT INTO `student` VALUES (1585917522892292098, 192);
INSERT INTO `student` VALUES (1585917523403997185, 221);
INSERT INTO `student` VALUES (1585917523936673794, 397);
INSERT INTO `student` VALUES (1585917524528070658, 601);
INSERT INTO `student` VALUES (1585917524985249794, 682);
INSERT INTO `student` VALUES (1585917525501149186, 785);
INSERT INTO `student` VALUES (1585917526025437185, 791);
INSERT INTO `student` VALUES (1585917526549725185, 829);
INSERT INTO `student` VALUES (1585917527006904321, 870);
INSERT INTO `student` VALUES (1585917527526998018, 4103);
INSERT INTO `student` VALUES (1585917527988371457, 5220);
INSERT INTO `student` VALUES (1585917528378441730, 6126);
INSERT INTO `student` VALUES (1585917528911118338, 6727);
INSERT INTO `student` VALUES (1585917529431212033, 7494);
INSERT INTO `student` VALUES (1585917529959694337, 7753);
INSERT INTO `student` VALUES (1585917530421067778, 8888);
INSERT INTO `student` VALUES (1585917530941161473, 9841);
INSERT INTO `student` VALUES (1585917531452866562, 14037);
INSERT INTO `student` VALUES (1585917531977154561, 30221);
INSERT INTO `student` VALUES (1585917532430139394, 39816);
INSERT INTO `student` VALUES (1585917533021536257, 41823);
INSERT INTO `student` VALUES (1585917533545824258, 45671);
INSERT INTO `student` VALUES (1585917534128832514, 54700);
INSERT INTO `student` VALUES (1585917534590205954, 75887);
INSERT INTO `student` VALUES (1585917535110299649, 89884);
INSERT INTO `student` VALUES (1585917535567478785, 451434);
INSERT INTO `student` VALUES (1585917536221790210, 533000);
INSERT INTO `student` VALUES (1585917536813187073, 622286);
INSERT INTO `student` VALUES (1585917537324892162, 690872);
INSERT INTO `student` VALUES (1585917537853374465, 770783);
INSERT INTO `student` VALUES (1585917538436382722, 829846);
INSERT INTO `student` VALUES (1585917538897756161, 992954);
INSERT INTO `student` VALUES (1585917539627565057, 1303047);
INSERT INTO `student` VALUES (1585917540277682177, 3414040);
INSERT INTO `student` VALUES (1585917540877467650, 3580992);
INSERT INTO `student` VALUES (1585917541343035393, 3634946);
INSERT INTO `student` VALUES (1585917541938626561, 3672363);
INSERT INTO `student` VALUES (1585917542391611394, 4192256);
INSERT INTO `student` VALUES (1585917542915899393, 4637114);
INSERT INTO `student` VALUES (1585917543427604481, 4910464);
INSERT INTO `student` VALUES (1585917544014807042, 8752246);
INSERT INTO `student` VALUES (1585917544664924162, 9106880);
INSERT INTO `student` VALUES (1585917545134686210, 9265222);
INSERT INTO `student` VALUES (1585917545596059649, 9741989);
INSERT INTO `student` VALUES (1585917546128736257, 9750964);
INSERT INTO `student` VALUES (1585917546728521729, 22662849);
INSERT INTO `student` VALUES (1585917547315724289, 31109690);
INSERT INTO `student` VALUES (1585917547911315458, 35971109);
INSERT INTO `student` VALUES (1585917548574015490, 42960132);
INSERT INTO `student` VALUES (1585917549102497793, 47470524);
INSERT INTO `student` VALUES (1585917549836500994, 50026477);
INSERT INTO `student` VALUES (1585917550360788994, 74074880);
INSERT INTO `student` VALUES (1585917551015100418, 82578702);
INSERT INTO `student` VALUES (1585917552130785281, 86147008);
INSERT INTO `student` VALUES (1585917552713793537, 89787616);
INSERT INTO `student` VALUES (1585917553300996097, 93163640);
INSERT INTO `student` VALUES (1585917553884004353, 240051753);
INSERT INTO `student` VALUES (1585917554479595522, 388499899);
INSERT INTO `student` VALUES (1585917555142295553, 479095665);
INSERT INTO `student` VALUES (1585917555859521537, 510678694);
INSERT INTO `student` VALUES (1585917556446724098, 735296534);
INSERT INTO `student` VALUES (1585917556975206402, 800258967);
INSERT INTO `student` VALUES (1585917557629517826, 1898951627);
INSERT INTO `student` VALUES (1585917558418046978, 3235364446);
INSERT INTO `student` VALUES (1585917559068164098, 5411665003);
INSERT INTO `student` VALUES (1585917559659560961, 7508205189);
INSERT INTO `student` VALUES (1585917560515198978, 7791743228);
INSERT INTO `student` VALUES (1585917561559580673, 8033366478);
INSERT INTO `student` VALUES (1585917562213892098, 8252667120);

-- ----------------------------
-- Table structure for student_score
-- ----------------------------
DROP TABLE IF EXISTS `student_score`;
CREATE TABLE `student_score`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `student_id` bigint(20) NOT NULL COMMENT '学生id',
  `examination_paper_id` bigint(20) NOT NULL COMMENT '试卷id',
  `user_examination_paper_id` bigint(20) NOT NULL COMMENT '考试id',
  `score` double(11, 0) NOT NULL COMMENT '成绩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_score
-- ----------------------------
INSERT INTO `student_score` VALUES (1588515879204794370, 2, 1, 1588377490409127938, 100);
INSERT INTO `student_score` VALUES (1588515952118575105, 2, 1, 1588377490409127938, 10);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1585918340743917570, 1585544271687155714);
INSERT INTO `teacher` VALUES (1585918341326925825, 1585813386104492034);

-- ----------------------------
-- Table structure for teacher_student
-- ----------------------------
DROP TABLE IF EXISTS `teacher_student`;
CREATE TABLE `teacher_student`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `thacher_id` bigint(20) NOT NULL COMMENT '教师id',
  `student_id` bigint(20) NOT NULL COMMENT '学生id',
  `is_delete` int(4) NOT NULL DEFAULT 0 COMMENT '0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `thacher_id`(`thacher_id`, `student_id`) USING BTREE COMMENT '教师跟学生两个记录应该同时唯一'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_student
-- ----------------------------
INSERT INTO `teacher_student` VALUES (1, 1585813386104492034, 1, 0);
INSERT INTO `teacher_student` VALUES (1585591105184935938, 1585544271687155714, 1, 0);
INSERT INTO `teacher_student` VALUES (1585592711557279746, 1585544271687155714, 7, 0);
INSERT INTO `teacher_student` VALUES (1585596683215040514, 1585544271687155714, 2, 0);
INSERT INTO `teacher_student` VALUES (1585596854023876609, 1585544271687155714, 3, 0);
INSERT INTO `teacher_student` VALUES (1585834477522907138, 1585544271687155714, 10, 0);
INSERT INTO `teacher_student` VALUES (1585876820552675329, 1585544271687155714, 5, 0);
INSERT INTO `teacher_student` VALUES (1585880057812983810, 1585544271687155714, 6, 0);
INSERT INTO `teacher_student` VALUES (1585882011037437954, 1585544271687155714, 8, 0);
INSERT INTO `teacher_student` VALUES (1585882202029264897, 1585813386104492034, 9, 1);
INSERT INTO `teacher_student` VALUES (1585882627075837953, 1585813386104492034, 31, 0);
INSERT INTO `teacher_student` VALUES (1585882876834058242, 1585813386104492034, 35, 1);
INSERT INTO `teacher_student` VALUES (1585886353752596481, 1585813386104492034, 46, 0);
INSERT INTO `teacher_student` VALUES (1585886506844692481, 1585813386104492034, 192, 1);
INSERT INTO `teacher_student` VALUES (1585920458682793986, 1585813386104492034, 47470524, 0);
INSERT INTO `teacher_student` VALUES (1585921118677499905, 1585813386104492034, 4637114, 1);
INSERT INTO `teacher_student` VALUES (1585921472957775874, 1585813386104492034, 3580992, 1);
INSERT INTO `teacher_student` VALUES (1585938197338247170, 1585813386104492034, 8752246, 1);
INSERT INTO `teacher_student` VALUES (1586204797232603137, 1585813386104492034, 3235364446, 0);
INSERT INTO `teacher_student` VALUES (1586205131988393985, 1585813386104492034, 510678694, 0);
INSERT INTO `teacher_student` VALUES (1586205781845442561, 1585813386104492034, 1898951627, 0);
INSERT INTO `teacher_student` VALUES (1586209049770291201, 1585813386104492034, 8033366478, 0);

-- ----------------------------
-- Table structure for test_questions
-- ----------------------------
DROP TABLE IF EXISTS `test_questions`;
CREATE TABLE `test_questions`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `examination_paper_id` bigint(20) NOT NULL COMMENT '试卷id',
  `test_questions_type` int(4) NOT NULL COMMENT '0 单选 1 多选 2 主观',
  `data` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '试题',
  `options` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '选项',
  `answer` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '答案',
  `score` double(11, 0) NOT NULL COMMENT '分数',
  `min_similarity` int(11) NULL DEFAULT NULL COMMENT '最小相似度 ， 只有主观题有',
  `max_similarity` int(11) NULL DEFAULT NULL COMMENT '最大相似度， 只有主观题有',
  `is_delete` int(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_questions
-- ----------------------------
INSERT INTO `test_questions` VALUES (1, 1, 0, '下面哪个是软件代码版本控制软件？', '{}', 'B', 20, 0, 0, 0);
INSERT INTO `test_questions` VALUES (2, 1, 0, '下面哪个阶段不是项目管理流程中的阶段？', '{\"A\":\" 项目立项\", \"B\": \"项目开发\", \"C\": \"项目测试\", \"D\":\"项目质保\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (3, 1, 0, 'VRRP协议报文使用的固定组播地址是？ ', '{\"A\": \"127.0.0.1\",\"B\": \"192.168.0.1\", \"C\": \"169.254.254.254\", \"D\":\" 224.0.0.18\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (4, 1, 0, '每个物理端口传输速率为100 M/，将2个物理端口聚合成逻辑端口后，该聚合端口AP的传输速率为多少？ ', '{\"A\": \"200Mb/s\" , \"B\": \"100Mb/s\", \"C\": \"300Mb/s\", \"D\": \"50Mb/s\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (5, 1, 0, ' 下列关于DHCP服务器的描述中，正确的是？', '{\"A\": \"客户端只能接受本网段DHCP服务器提供的IP地址\",  \"B\": \"需要保留的IP地址可以包含在DHCP服务器的地址池中\", \"C\": \"DHCP服务器不能帮助用户指定DNS服务器\",  \"D\": \"DHCP服务器可以将一个IP地址同时分配给两个不同的用户\"}', 'B', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (6, 1, 0, '下列选项当中，创建名称为test的数据库的正确命令是？', '{\"A\": \"mysql -uroot –p000000 create test\",  \"B\": \"mysqladmin -uroot –p000000 create test\",  \"C\": \"mysql -u root-p 000000 create test\",  \"D\": \"mysqladmin -u root-p 000000 create test\"}', 'B', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (7, 1, 0, ' 操作Nginx时需要与哪个进程进行通讯？', '{\"A\": \"主进程\", \"B\": \"通讯进程\" , \"C\": \"网络进程\" ,\"D\": \"worker进程\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (8, 1, 0, 'Nginx中重新加载配置Master在接受到什么信号后，会先重新加载配置？', '{\"A\": \"kill -HUP pid\", \"B\": \"start -HUP pid\" ,  \"C\": \"stop -HUP pid\" , \"D\": \"restart -HUP pid\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (9, 1, 0, '以下哪个服务为OpenStack平台提供了消息服务？', '{\"A\": \"Keystone\", \"B\": \"Neutron\" , \"C\": \"RabbitMQ\" , \"D\": \"Nova\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (10, 1, 0, ' OpenStack在以下哪个版本正式发布Horizon？', '{\"A\": \"Cactus\",  \"B\": \"Diablo\",  \"C\": \"Essex\",\"D\": \"Folsom\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (11, 1, 0, '下列选项当中，哪个是Neutron查询网络服务列表信息的命令？', '{\"A\": \"neutron agent-list\", \"B\": \"neutron network-show\",\"C\": \"neutron agent-show\",\"D\": \"neutron network-list\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (12, 1, 0, '以下关于腾讯云按量计费的描述中，哪项是错误的？', '{\"A\": \"先使用后付款，相对预付费更灵活，用多少付多少，计费准确，无资源浪费。\", \"B\": \"可按需紧急增加或者减少资源，快速根据业务需要调整资源购买需求。\",\"C\": \"单位价格较预付费低。\",\"D\":\" 较大量资源临时增加时，可能出现无资源可用情况。\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (13, 1, 0, '下列关于CDN的说法，错误的是？', '{\"A\":\"简单接入\",\"B\":\"统计简单\", \"C\":\"配置复杂\",\"D\":\"多样管理\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (14, 1, 0, 'VPN连接与专线接入是两种连接企业数据中心与腾讯云的方法，下列说法错误的是？', '{\"A\":\"专线接入具备更安全:更稳定:更低时延:更大带宽等特性\", \"B\":\"VPN 连接具有配置简单，云端配置实时生效:可靠性高等特点\", \"C\":\"专线接入的定价由物理专线定价:专用通道定价组成\", \"D\":\"VPN 通道:对端网关:VPN 网关需要付费使用\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (15, 1, 0, '关于腾讯云关系型数据库CDB的产品优势，下列说法不正确的是？', '{\"A\":\"默认支持双主备份模式\",\"B\":\"用户可根据业务情况选择精确到秒粒度的按量计费模式，或者价格更优惠的包年包月模式。\", \"C\":\"提供多种存储介质选型，可根据业务情况灵活选择。\",\"D\":\"仅需几步可轻松完成数据库从部署到访问，不需要预先准备基础设施，也不需要安装和维护数据库软件。\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (16, 1, 0, ' 以下关于腾讯云按量计费的描述中，哪项是错误的？', '{\"A\":\"先使用后付款，相对预付费更灵活，用多少付多少，计费准确，无资源浪费。\",\"B\":\"可按需紧急增加或者减少资源，快速根据业务需要调整资源购买需求。\",\"C\":\"单位价格较预付费低。\",\"D\":\"较大量资源临时增加时，可能出现无资源可用情况。\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (17, 1, 0, ' 用户购买了上海地区按量计费 500G SSD 云硬盘，使用2小时后释放，已知上海地区SSD云硬盘单价为0.0033元GB*结算单位，则用户需要付费多少元？', '{\"A\":\"3.3\",\"B\":\"198\", \"C\":\"11880\",\"D\":\"0.14\"}', 'B', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (18, 1, 0, ' 腾讯云CDN提供哪些加速服务，使用高性能缓存系统，降低访问时延，提高资源可用性？', '{\"A\":\"静态内容加速\", \"B\":\"下载分发加速\", \"C\":\"音视频点播加速\", \"D\":\"以上所有\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (19, 1, 0, ' 下面哪个是Kubernetes可操作的最小对象？', '{\"A\": \"container\", \"B\": \"Pod\",\"C\": \"image\",\"D\": \"volume\"}', 'B', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (20, 1, 0, '下面哪个不是属于Shell的种类_____。', '{\"A\":\"Bourne Shell\",\"B\":\"Bourne-Again Shell\", \"C\":\"Korn Shell\", \"D\":\"J2SE\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (21, 1, 1, '常见的项目开发模型有哪些？', '{\"A\":\"快速原型模型\",\"B\":\"增量模型\", \"C\":\"瀑布模型\",\"D\":\"敏捷开发模型\"}', 'CD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (22, 1, 1, ' 下面关于项目立项启动表述正确的是？', '{\"A\":\"项目启动阶段，将项目的目标:规划与任务进行完整地定义和阐述，成一份完成的项目工作任务书\",\"B\":\"项目启动会是宣导项目重要性的关键节点，必须就项目目标:上线条件:管理权限和项目干系人列表达成共识\", \"C\":\"项目启动阶段必须确定明确的责任人\", \"D\":\"项目立项启动过程需要明确开发:测试阶段的任务\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (23, 1, 1, 'VRRP协议的优点有哪些？', '{\"A\":\"容错率低\",\"B\":\"适应性强\",\"C\":\"网络开销小\", \"D\":\"简化网络管理\"}', 'BCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (24, 1, 1, 'VRRP协议中定义了哪些状态？', '{ \"A\":\"活动状态\", \"B\":\"转发状态\",\"C\":\"备份状态\",\"D\":\"初始状态\"}', 'ACD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (25, 1, 1, '在Linux系统，关于硬链接的描述正确的是？', '{\"A\":\"跨文件系统\",\"B\":\"不可以跨文件系统\",\"C\":\"为链接文件创建新的i节点\",\"D\":\"链接文件的i节点与被链接文件的i节点相同\"}', 'BD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (26, 1, 1, '批量删除当前目录下后缀名为.c的文件。如a.c:b.c。', '{ \"A\":\"rm *.c\", \"B\":\"find . -name \\\"*.c\\\" -maxdepth 1 | xargs rm\",\"C\":\"find . -name \\\"*.c\\\"   | xargs  rm\",\"D\":\"以上都不正确\"}', 'AB', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (27, 1, 1, '哪些是zookeeper主要角色？', '{ \"A\":\"领导者\",\"B\":\"学习者\",\"C\":\"客户端\", \"D\":\"服务端\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (28, 1, 1, ' Kafka应用场景有哪些？', '{\"A\": \"日志收集\",\"B\": \"消息系统\",\"C\": \"运营指标\",\"D\": \"流式处理\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (29, 1, 1, '制定银行容器平台的需求时，建议考虑包括的方面有哪些？', '{ \"A\":\"管理大规模容器集群能力\", \"B\":\"为满足金融业务的监管和安全要求，平台需要考虑应用的高可用性和业务连续性:多租户安全隔离:不同等级业务隔离\",\"C\":\"器平台还对公网提供访问，那么还需要考虑访问链路加密:安全证书\",\"D\":\"防火墙策略:安全漏洞扫描:镜像安全:后台运维的4\\\"A\\\"纳管:审计日志\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (30, 1, 1, '下面属于nova组件中的服务的是？', '{ \"A\":\"nova-api\", \"B\":\"nova-scheduler\",\"C\":\"nova-novncproxy\", \"D\":\"nova-controller\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (31, 1, 1, 'Glance服务可以采用的后端存储有哪些？', '{ \"A\":\"简单文件系统\", \"B\":\"Swift\",\"C\":\"Ceph\",\"D\":\"S3云存储\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (32, 1, 1, 'Ceilometer数据收集方式有哪些？', '{\"A\":\"触发收集\",\"B\":\"自发收集\",\"C\":\"循环收集\",\"D\":\"轮询收集\"}', 'AD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (33, 1, 1, '腾讯云服务器多地域多可用区部署有哪些优势？', '{\"A\":\"用户就近选择，降低时延提高速度\",\"B\":\"可用区间故障相互隔离，无故障扩散\", \"C\":\"保障业务连续性\",\"D\":\"保证高可用性\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (34, 1, 1, '云服务器可用的镜像类型有哪几个？', '{\"A\":\"公有镜像\",\"B\":\"自定义镜像\",\"C\":\"服务市场镜像\",\"D\":\"个人镜像\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (35, 1, 1, '以下关于弹性伸缩特点描述正确的有哪几项？', '{\"A\":\"弹性伸缩可以根据您的业务需求和策略，自动调整 CVM 计算资源\",\"B\":\"弹性伸缩的计费方式为按云服务器所使用的资源来计费\",\"C\":\"弹性伸缩的计费方式为按年度计费\",\"D\":\"以上皆无\"}', 'AB', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (36, 1, 1, '下列关于腾讯云负载均衡说法正确的是？', '{ \"A\":\"公网应用型支持七层:四层转发\", \"B\":\"内网应用型不支持四层转发\",\"C\":\"公网传统型支持七层:四层转发\",\"D\":\"内网传统型不支持七层转发\"}', 'ACD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (37, 1, 1, '下面关于容器编排的说法，不正确的是？', '{ \"A\": \"容器编排是指对单独组件和应用层的工作进行组织的流程\",\"B\": \"应用一般由单独容器化的组件（通常称为微服务）组成\", \"C\": \"对单个容器进行组织的流程即称为容器编排\",\"D\": \"容器编排工具仅允许用户指导容器部署与自动更新\"}', 'CD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (38, 1, 1, '下面关于OpenShift集群缩容的说法，正确的是？', '{\"A\": \"缩容是指减少集群的网络资源\",\"B\": \"缩容时集群管理员需要保证新的容器不会再创建于要缩减的计算节点之上\", \"C\": \"缩容时要保证当前运行在计划缩减的计算节点之上的容器能迁移到其他计算节点之上\",\"D\": \"般的缩容过程主要步骤包括禁止参与调度:节点容器撤离和移除计算节点\"}', 'BCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (39, 1, 1, 'IaaS平台中拥有下面哪些项目_____。', '{\"A\":\"ERP\",\"B\":\"Openstack\",\"C\":\"Cloudstack\",\"D\":\"CRM\"}', 'BC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (40, 1, 1, 'Python中使用requests第三方库的优点在于_____。', '{ \"A\":\"持使用Cookie保持会话\",\"B\":\"支持文件上传\",\"C\":\"支持自动确定响应内容的编码\", \"D\":\"对用户来说比较人性化\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (41, 1, 2, '路由器管理   配置R1和R2路由器（路由器使用R2220），R1路由器配置端口g001地址为192.168.1.130，端口g001连接R2路由器。配置端口g002地址为192.168.2.124，作为内部PC1机网关地址。R2路由器配置端口g001地址为192.168.1.230，端口g001连接R1路由器，配置端口g002地址为192.168.3.124，作为内部PC2机网关地址。R1和R2路由器启用OSPF动态路由协议自动学习路由。使PC1和PC2可以相互访问。（所有配置命令使用完整命令）将上述所有操作命令及返回结果以文本形式提交到答题框。', '', '[Huawei]interface GigabitEthernet 001\r\n[Huawei-GigabitEthernet001]ip address 192.168.1.1 30\r\n[Huawei-GigabitEthernet001]quit\r\n[Huawei]interface GigabitEthernet 002\r\n[Huawei-GigabitEthernet002]ip address 192.168.2.1 24\r\n[Huawei-GigabitEthernet002]quit\r\n[Huawei]ospf 1\r\n[Huawei-ospf-1]area 0\r\n[Huawei-ospf-1-area-0.0.0.0]network 192.168.1.0 0.0.0.3\r\n[Huawei-ospf-1-area-0.0.0.0]network 192.168.2.0 0.0.0.255\r\n[Huawei]interface GigabitEthernet 001\r\n[Huawei-GigabitEthernet001]ip address 192.168.1.2 30\r\n[Huawei-GigabitEthernet001]quit\r\n[Huawei]interface GigabitEthernet 002\r\n[Huawei-GigabitEthernet002]ip address 192.168.3.1 24\r\n[Huawei-GigabitEthernet002]quit\r\n[Huawei]ospf 1\r\n[Huawei-ospf-1]area 0\r\n[Huawei-ospf-1-area-0.0.0.0]network 192.168.1.0 0.0.0.3\r\n[Huawei-ospf-1-area-0.0.0.0]network 192.168.3.0 0.0.0.255', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (42, 1, 2, '无线AC管理  配置无线AC控制器（型号使用AC6005），开启dhcp功能，设置vlan20网关地址为172.16.20.124，并配置vlan20接口服务器池，设置dhcp分发dns为114.114.114.114:223.5.5.5。将上述所有操作命令及返回结果以文本形式提交到答题框。', NULL, '[SW1]vlan batch 20\r\n[SW1]dhcp enable\r\n[SW1]interface vlanif 20\r\n[SW1-Vlanif20]ip address 172.16.20.1 24\r\n[SW1-Vlanif20]dhcp select interface\r\n[SW1-Vlanif20]dhcp server dns-list 114.114.114.114 223.5.5.5', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (43, 1, 2, 'YUM源管理 若存在一个CentOS-7-x86_64-DVD-1511.iso的镜像文件，使用这个镜像文件配置本地yum源，要求将这个镜像文件挂载在optcentos目录，请问如何配置自己的local.repo文件，使得可以使用该镜像中的软件包，安装软件。请将local.repo文件的内容以文本形式提交到答题框。', NULL, '[centos]\r\nname=centos\r\nbaseurl=file:optcentos\r\ngpgcheck=0\r\nenabled=1', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (44, 1, 2, 'Raid存储管理 使用提供的虚拟机，该虚拟机存在一块大小为20G的磁盘devvdb，使用fdisk命令对该硬盘进形分区，要求分出三个大小为5G的分区。使用这三个分区，创建名为devmd5:raid级别为5的磁盘阵列。创建完成后使用xfs文件系统进形格式化，并挂载到mnt目录下。将mdadm -D devmd5命令和返回结果；df -h命令和返回结果以文本形式提交到答题框。', NULL, '[root@xiandian ~]# mdadm -D devmd0\r\ndevmd0:\r\nVersion : 1.2\r\nCreation Time : Wed Oct 23 17:08:07 2019\r\nRaid Level : raid5\r\nArray Size : 5238784 (5.00 GiB 5.36 GB)\r\nUsed Dev Size : 5238784 (5.00 GiB 5.36 GB)\r\nRaid Devices : 3\r\nTotal Devices : 3\r\nPersistence : Superblock is persistent\r\nUpdate Time : Wed Oct 23 17:13:37 2019\r\nState : clean\r\nActive Devices : 3\r\nWorking Devices : 3\r\nFailed Devices : 0\r\nSpare Devices : 0\r\nName : xiandian:0  (local to host xiandian)\r\nUUID : 71123d35:b354bc98:2e36589d:f0ed3491\r\nEvents : 17\r\nNumber   Major   Minor   RaidDevice State\r\n0     253       17        0      active sync   devvdb1\r\n1     253       18        1      active sync   devvdb2\r\n2     253       19        2      active sync   devvdb3\r\n[root@xiandian ~]# df -h\r\nFilesystem      Size  Used Avail Use% Mounted on\r\ndevvda1        41G  2.4G   39G   6% \r\ndevtmpfs        3.9G     0  3.9G   0% dev\r\ntmpfs           3.9G  4.0K  3.9G   1% devshm\r\ntmpfs           3.9G   17M  3.9G   1% run\r\ntmpfs           3.9G     0  3.9G   0% sysfscgroup\r\ndevloop0      2.8G   33M  2.8G   2% swiftnode\r\ntmpfs           799M     0  799M   0% runuser0\r\ndevmd5        10.0G   33M  10.0G   1% mnt', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (45, 1, 2, ' 主从数据库管理 使用提供的两台虚拟机，在虚拟机上安装mariadb数据库，并配置为主从数据库，实现两个数据库的主从同步。配置完毕后，请在从节点上的数据库中执行“show slave status \\G”命令查询从节点复制状态，将查询到的结果以文本形式提交到答题框。', NULL, 'MariaDB [(none)]&gt; start slave;\r\nMariaDB [(none)]&gt; show slave status\\G\r\n*************************** 1. row ***************************\r\nSlave_IO_State: Waiting for master to send event\r\nMaster_Host: mysql1\r\nMaster_User: user\r\nMaster_Port: 3306\r\nConnect_Retry: 60\r\nMaster_Log_File: mysql-bin.000003\r\nRead_Master_Log_Pos: 245\r\nRelay_Log_File: mariadb-relay-bin.000005\r\nRelay_Log_Pos: 529\r\nRelay_Master_Log_File: mysql-bin.000003\r\nSlave_IO_Running: Yes\r\nSlave_SQL_Running: Yes\r\nReplicate_Do_DB:\r\nReplicate_Ignore_DB:\r\nReplicate_Do_Table:\r\nReplicate_Ignore_Table:\r\nReplicate_Wild_Do_Table:\r\nReplicate_Wild_Ignore_Table:\r\nLast_Errno: 0\r\nLast_Error:\r\nSkip_Counter: 0\r\nExec_Master_Log_Pos: 245\r\nRelay_Log_Space: 1256\r\nUntil_Condition: None\r\nUntil_Log_File:\r\nUntil_Log_Pos: 0\r\nMaster_SSL_Allowed: No\r\nMaster_SSL_CA_File:\r\nMaster_SSL_CA_Path:\r\nMaster_SSL_Cert:\r\nMaster_SSL_Cipher:\r\nMaster_SSL_Key:\r\nSeconds_Behind_Master: 0\r\nMaster_SSL_Verify_Server_Cert: No\r\nLast_IO_Errno: 0\r\nLast_IO_Error:\r\nLast_SQL_Errno: 0\r\nLast_SQL_Error:\r\nReplicate_Ignore_Server_Ids:\r\nMaster_Server_Id: 30\r\n1 row in set (0.00 sec)', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (46, 1, 2, ' 应用商城系统 使用提供的软件包和提供的虚拟机，完成单节点应用系统部署。部署完成后，进行登录，（订单中填写的收货地址填写自己学校的地址，收货人填写自己的实际联系方式）最后使用curl命令去获取商城首页的返回信息，将curl http:你自己的商城IP#home获取到的结果以文本形式提交到答题框。', NULL, '[root@server ~]# curl http:172.30.11.27#home\r\n&lt;!DOCTYPE html&gt;&lt;html&gt;&lt;head&gt;&lt;meta charset=utf-8&gt;&lt;title&gt;1+x-示例项目&lt;title&gt;&lt;meta name=keywords content=\"\"&gt;&lt;meta name=description content=\"\"&gt;&lt;meta http-equiv=X-UA-Compatible content=\"IE=Edge\"&gt;&lt;meta name=wap-font-scale content=no&gt;&lt;link rel=\"shortcut icon \" type=imagesx-icon href=staticimagesfavicon.ico&gt;&lt;link href=staticcssapp.8d4edd335a61c46bf5b6a63444cd855a.css rel=stylesheet&gt;&lt;head&gt;&lt;body&gt;&lt; id=app&gt;&lt;&gt;&lt;script type=textjavascript src=staticjsmanifest.2d17a82764acff8145be.js&gt;&lt;script&gt;&lt;script type=textjavascript src=staticjsvendor.4f07d3a235c8a7cd4efe.js&gt;&lt;script&gt;&lt;script type=textjavascript src=staticjsapp.81180cbb92541cdf912f.js&gt;&lt;script&gt;&lt;body&gt;&lt;html&gt;&lt;style&gt;body{\r\nmin-width:1250px;', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (47, 1, 2, ' Zookeeper集群 使用提供的三台虚拟机和软件包，完成Zookeeper集群的安装与配置，配置完成后，在相应的目录使用.zkServer.sh status命令查看三个Zookeeper节点的状态，将三个节点的状态以文本形式提交到答题框。', NULL, '[root@zookeeper1 bin]# .zkServer.sh status\r\nZooKeeper JMX enabled by default\r\nUsing config: rootzookeeper-3.4.14bin..confzoo.cfg\r\nMode: follower\r\n[root@zookeeper2 bin]# .zkServer.sh status\r\nZooKeeper JMX enabled by default\r\nUsing config: rootzookeeper-3.4.14bin..confzoo.cfg\r\nMode: leader\r\n[root@zookeeper3 bin]# .zkServer.sh status\r\nZooKeeper JMX enabled by default\r\nUsing config: rootzookeeper-3.4.14bin..confzoo.cfg\r\nMode: follower', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (48, 1, 2, 'Kafka集群  使用提供的三台虚拟机和软件包，完成Kafka集群的安装与配置，配置完成后，在相应的目录使用 .kafka-topics.sh --create --zookeeper 你的IP:2181 --replication-factor 1 --partitions 1 --topic test创建topic，将输入命令后的返回结果以文本形式提交到答题框。', NULL, '[root@zookeeper1 bin]# .kafka-topics.sh --create --zookeeper 172.16.51.23:2181 --replication-factor 1 --partitions 1 --topic test\r\nCreated topic \"test\".', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (49, 1, 2, 'Zabbix-server节点搭建 使用提供的虚拟机和软件包，完成Zabbix监控系统server端的搭建，搭建完毕后启动服务，然后使用netstat -ntpl命令查看端口启动情况，将netstat -ntpl命令的返回结果以文本形式提交到答题框。', NULL, '[root@zabbix-server ~]# netstat -ntpl\r\nActive Internet connections (only servers)\r\nProto Recv-Q Send-Q Local Address           Foreign Address         State       PIDProgram name\r\ntcp        0      0 0.0.0.0:10051           0.0.0.0:*               LISTEN      10611zabbix_server\r\ntcp        0      0 0.0.0.0:3306            0.0.0.0:*               LISTEN      10510mysqld\r\ntcp        0      0 0.0.0.0:22              0.0.0.0:*               LISTEN      975sshd\r\ntcp        0      0 127.0.0.1:25            0.0.0.0:*               LISTEN      886master\r\ntcp6       0      0 :::10051                :::*                    LISTEN      10611zabbix_server\r\ntcp6       0      0 :::80                   :::*                    LISTEN      10579httpd\r\ntcp6       0      0 :::21                   :::*                    LISTEN      10015vsftpd\r\ntcp6       0      0 :::22                   :::*                    LISTEN      975sshd\r\ntcp6       0      0 ::1:25                  :::*                    LISTEN      886master', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (50, 1, 2, ' Keystone管理 使用提供的“all-in-one”镜像，自行检查openstack中各服务的状态，若有问题自行排查。在keystone中创建用户testuser，密码为password，创建好之后，查看testuser的详细信息。将openstack user show testuser命令的返回结果以文本形式提交到答题框。', NULL, '[root@xiandian~]# source etckeystoneadmin-openrc.sh\r\n[root@xiandian~]# openstack user show testuser\r\n+-----------+----------------------------------+\r\n| Field     | Value                            |\r\n+-----------+----------------------------------+\r\n| domain_id | 639e7d52170d4759b5438e3b29bbf339 |\r\n| enabled   | True                             |\r\n| id        | df8ca15f17a8435d8889987b4b78c7a2 |\r\n| name      | testuser                         |\r\n+-----------+----------------------------------+', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (51, 1, 2, 'Glance管理 使用提供的“all-in-one”镜像，自行检查openstack中各服务的状态，若有问题自行排查。使用提供的cirros-0.3.4-x86_64-disk.img镜像；使用glance命令将镜像上传，并命名为mycirros，最后将glance image-show id命令的返回结果以文本形式提交到答题框。', NULL, '[root@xiandian ~]# glance image-show d3663be2-3ebf-443a-b3fc-b3e39bda8783\r\n+------------------+--------------------------------------+\r\n| Property         | Value                                |\r\n+------------------+--------------------------------------+\r\n| checksum         | ee1eca47dc88f4879d8a229cc70a07c6     |\r\n| container_format | bare                                 |\r\n| created_at       | 2019-10-24T10:16:52Z                 |\r\n| disk_format      | qcow2                                |\r\n| id               | d3663be2-3ebf-443a-b3fc-b3e39bda8783 |\r\n| min_disk         | 0                                    |\r\n| min_ram          | 0                                    |\r\n| name             | mycirros                             |\r\n| owner            | 0ab2dbde4f754b699e22461426cd0774     |\r\n| protected        | False                                |\r\n| size             | 13287936                             |\r\n| status           | active                               |\r\n| tags             | []                                   |\r\n| updated_at       | 2019-10-24T10:16:52Z                 |\r\n| virtual_size     | None                                 |\r\n| visibility       | private                              |\r\n+------------------+--------------------------------------+', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (52, 1, 2, ' Nova管理 使用提供的“all-in-one”镜像，自行检查openstack中各服务的状态，若有问题自行排查。通过nova的相关命令创建名为exam，ID为1234，内存为1024M，硬盘为20G，虚拟内核数量为2的云主机类型，查看exam的详细信息。将nova flavor-show id操作命令的返回结果以文本形式提交到答题框。', NULL, '[root@xiandian ~]# nova flavor-show 1234\r\n+----------------------------+-------+\r\n| Property                   | Value |\r\n+----------------------------+-------+\r\n| OS-FLV-DISABLED:disabled   | False |\r\n| OS-FLV-EXT-DATA:ephemeral  | 0     |\r\n| disk                       | 20    |\r\n| extra_specs                | {}    |\r\n| id                         | 1234  |\r\n| name                       | exam  |\r\n| os-flavor-access:is_public | True  |\r\n| ram                        | 1024  |\r\n| rxtx_factor                | 1.0   |\r\n| swap                       |       |\r\n| vcpus                      | 2     |\r\n+----------------------------+-------+', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (53, 1, 2, 'Docker安装 使用提供的虚拟机和软件包，自行配置YUM源，安装docker-ce服务。安装完毕后执行docker info命令的返回结果以文本形式提交到答题框。', NULL, 'Containers: 33\r\nRunning: 16\r\nPaused: 0\r\nStopped: 17\r\nImages: 22\r\nServer Version: 18.09.6\r\nStorage Driver: devicemapper\r\nPool Name: docker-253:0-113162281-pool\r\nPool Blocksize: 65.54kB\r\nBase Device Size: 10.74GB\r\nBacking Filesystem: xfs\r\nUdev Sync Supported: true\r\nData file: devloop0\r\nMetadata file: devloop1\r\nData loop file: varlibdockerdevicemapperdevicemapperdata\r\nMetadata loop file: varlibdockerdevicemapperdevicemappermetadata\r\nData Space Used: 3.573GB\r\nData Space Total: 107.4GB\r\nData Space Available: 18.72GB\r\nMetadata Space Used: 22.59MB\r\nMetadata Space Total: 2.147GB\r\nMetadata Space Available: 2.125GB\r\nThin Pool Minimum Free Space: 10.74GB\r\nDeferred Removal Enabled: true\r\nDeferred Deletion Enabled: true\r\nDeferred Deleted Device Count: 0\r\nLibrary Version: 1.02.158-RHEL7 (2019-05-13)\r\nLogging Driver: json-file\r\nCgroup Driver: cgroupfs\r\nPlugins:\r\nVolume: local\r\nNetwork: bridge host macvlan null overlay\r\nLog: awslogs fluentd gcplogs gelf journald json-file local logentries splunk syslog\r\nSwarm: inactive\r\nRuntimes: runc\r\nDefault Runtime: runc\r\nInit Binary: docker-init\r\ncontainerd version: b34a5c8af56e510852c35414db4c1f4fa6172339\r\nrunc version: 3e425f80a8c931f88e6d94a8c831b9d5aa481657\r\ninit version: fec3683\r\nSecurity Options:\r\nseccomp\r\nProfile: default\r\nKernel Version: 3.10.0-1062.7.1.el7.x86_64\r\nOperating System: CentOS Linux 7 (Core)\r\nOSType: linux\r\nArchitecture: x86_64\r\nCPUs: 2\r\nTotal Memory: 1.913GiB\r\nName: master\r\nID: U4ME:YWV6:WZEK:7R7W:5OLN:MO4A:NVNH:AEPR:L7GE:UD4S:UZOY:GZXQ\r\nDocker Root Dir: varlibdocker\r\nDebug Mode (client): false\r\nDebug Mode (server): false\r\nRegistry: https:index.docker.iov1\r\nLabels:\r\nExperimental: false\r\nInsecure Registries:\r\n192.168.70.10:5000\r\n127.0.0.08\r\nLive Restore Enabled: false\r\nProduct License: Community Engine\r\nWARNING: the devicemapper storage-driver is deprecated, and will be removed in a future release.\r\nWARNING: devicemapper: usage of loopback devices is strongly discouraged for production use.\r\nUse `--storage-opt dm.thinpooldev` to specify a custom block storage device.', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (54, 1, 2, ' 部署Swarm集群 使用提供的虚拟机和软件包，安装好docker-ce。部署Swarm集群，并安装Portainer图形化管理工具，部署完成后，使用浏览器登录ip:9000界面，进入Swarm控制台。将curl swarm ip:9000返回的结果以文本形式提交到答题框。', NULL, '[root@master ~]# curl 192.168.100.10:9000\r\n&lt;!DOCTYPE html&gt;&lt;html lang=\"en\" ng-app=\"portainer\"&gt;\r\n&lt;head&gt;\r\n&lt;meta charset=\"utf-8\"&gt;\r\n&lt;title&gt;Portainer&lt;title&gt;\r\n&lt;meta name=\"description\" content=\"\"&gt;\r\n&lt;meta name=\"author\" content=\"Portainer.io\"&gt;\r\n&lt; class=\"row\" style=\"text-align: center\"&gt;\r\nLoading Portainer...\r\n&lt;i class=\"fa fa-cog fa-spin\" style=\"margin-left: 5px\"&gt;&lt;i&gt;\r\n&lt;&gt;\r\n&lt;!-- !panel --&gt;\r\n&lt;&gt;', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (55, 1, 2, 'Shell脚本补全 下面有一段脚本，作用是自动配置redis服务，由于工程师的失误，将脚本中的某些代码删除了，但注释还在，请根据注释，填写代码。最后将填写的代码按照顺序以文本形式提交至答题框。  redis(){\r\ncd\r\n#修改redis的配置文件，将bind 127.0.0.1注释\r\nsed -i （此处填写） etcredis.conf\r\n#修改redis的配置文件，将protected-mode yes改为protected-mode no\r\nsed -i （此处填写） etcredis.conf\r\n#启动redis服务\r\nsystemctl start redis\r\n#设置开机自启\r\nsystemctl enable redis\r\nif [ $? -eq 0 ]\r\nthen\r\nsleep 3\r\necho -e \"\\033[36m==========redis启动成功==========\\033[0m\"\r\nelse\r\necho -e \"\\033[31m**********redis启动失败，请检查**********\\033[0m\"\r\nexit 1\r\nfi\r\nsleep 2\r\n}', NULL, 'sed -i \'sbind 127.0.0.1#bind 127.0.0.1g\' etcredis.conf\r\nsed -i \'sprotected-mode yesprotected-mode nog\' etcredis.conf\r\n    < bbe3c3cc=\"\" c19108e2=\"\" class=\"answer-card-box anwser-card\">< bbe3c3cc=\"\" class=\"answer-card-move\" style=\"cursor: move;\">', 40, 0, 100, 0);
INSERT INTO `test_questions` VALUES (1587437104966778882, 1587437104111140866, 0, '项目部署与测试阶段中，不需要参与的角色是', '{\"A\":\"系统运维人员\",\"B\":\"测试人员\",\"C\":\"项目经理\",\"D\":\"开发人员\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778883, 1587437104111140866, 0, '在项目立项启动阶段，开发经理不需要验证哪份报告', '{\"A\":\"《用户需求说明书》\",\"B\":\"《项目立项建议书》\",\"C\":\"《可行分析报告》\",\"D\":\"《项目计划书》\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778884, 1587437104111140866, 0, '在交换机中可以VLAN的取值范围是多少', '{\"A\":\"1-4094\",\"B\":\"0-4096\",\"C\":\"1-4096\",\"D\":\"1-4095\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778885, 1587437104111140866, 0, '二层以太网交换机在MAC地址表中查找与帧目的MAC地址匹配的表项，从而将帧从相应接口转发出去，如果查找失败，交换机将', '{\"A\":\"查找路由表\",\"B\":\"把帧丢弃\",\"C\":\"查找快速转发表\",\"D\":\"把帧由除入端口以外的所有其他端口发送出去\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778886, 1587437104111140866, 0, '下面哪个命令不是用来查看网络故障？', '{\"A\":\"telnet\",\"B\":\"ping\",\"C\":\"init\",\"D\":\"netstat\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778887, 1587437104111140866, 0, '在Linux系统的vi编辑器中，如果不保存对文件进行的修改，应使用什么命令强制退出vi编辑器', '{\"A\":\":q\",\"B\":\":wq\",\"C\":\":q!\",\"D\":\":!q\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778888, 1587437104111140866, 0, '如果使用SQLite，Zabbix Web界面必须要跟Zabbix Server满足什么条件？', '{\"A\":\"运行在同一台物理机器上\",\"B\":\"不能在同一台物理机器上\",\"C\":\"需要在同一局域网\",\"D\":\"无需在同一局域网\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778889, 1587437104111140866, 0, '主从数据库复制整体来说分为几个步骤?', '{\"A\":\"1\",\"B\":\"2\",\"C\":\"3\",\"D\":\"4\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778890, 1587437104111140866, 0, '关于Keystone认证服务下列说法中错误的是？', '{\"A\":\"认证是确认允许一个用户访问的进程。\",\"B\":\"证书用于确认用户身份的数据。\",\"C\":\"令牌的有效期是无限的，可以随时被撤回。\",\"D\":\"使用服务的用户，可以是人、服务或系统使用OpenStack相关服务的一个组织。\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778891, 1587437104111140866, 0, 'Openstack系统架构不包含以下哪个组件？', '{\"A\":\"Hive\",\"B\":\"Neutron\",\"C\":\"Glance\",\"D\":\"Heat\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778892, 1587437104111140866, 0, 'OpenStack中的计算模块是以下哪个模块？', '{\"A\":\"Nova\",\"B\":\"Glance\",\"C\":\"Swift\",\"D\":\"Cinder\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778893, 1587437104111140866, 0, '某客户为快速开展业务，需要一个开箱即用的业务系统，要求统一服务、流程、模型和体验，那么应该选择哪一类型的云计算服务？', '{\"A\":\"基础设施即服务（IaaS）\",\"B\":\"平台即服务（PaaS）\",\"C\":\"软件即服务（SaaS）\",\"D\":\"云即服务（CaaS）\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778894, 1587437104111140866, 0, '下列哪个不是上云业务的需求特征？', '{\"A\":\"广泛的网络访问\",\"B\":\"按需使用服务\",\"C\":\"超大的资源池\",\"D\":\"拥有更多的固定资产\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778895, 1587437104111140866, 0, ' 以下关于跨地域网络设计的描述中，正确的选项是？', '{\"A\":\"同一个子网可以跨地域部署\",\"B\":\"同一个子网不可以跨地域部署\",\"C\":\"将同一个子网部署到多地域可以提供容灾能力\",\"D\":\"将同一个子网部署到多地域可以提供网络性能\"}', 'B', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437104966778896, 1587437104111140866, 0, '关于腾讯云的CDN加速功能，主要包括全面加速和安全防护两个方面，下列哪个选项不属于全面加速？', '{\"A\":\"静态内容加速\",\"B\":\"直播加速\",\"C\":\"下载分发加速\",\"D\":\"海外加速\"}', 'B', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693442, 1587437104111140866, 0, 'Yml是一种什么语言？', '{\"A\":\"标记\",\"B\":\"非标记\",\"C\":\"静态\",\"D\":\"动态\"}', 'B', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693443, 1587437104111140866, 0, '在K8S的核心组件中负责维护集群状态的组件是', '{\"A\":\"controller manage\",\"B\":\"scheduler\",\"C\":\"kubelet\",\"D\":\"etcd\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693444, 1587437104111140866, 0, '关于Keystone认证服务下列说法中错误的是？', '{\"A\":\"认证是确认允许一个用户访问的进程。\",\"B\":\"证书用于确认用户身份的数据。\",\"C\":\"令牌的有效期是无限的，可以随时被撤回。\",\"D\":\"使用服务的用户，可以是人、服务或系统使用OpenStack相关服务的一个组织。\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693445, 1587437104111140866, 0, 'Ansible自动化运维工具是基于以下哪种语言开发？', '{\"A\":\"Java\",\"B\":\"C语言\",\"C\":\"Python\",\"D\":\"C++\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693446, 1587437104111140866, 1, '下面关于原生NAT方案中叙述正确的是', '{\"A\":\"同一宿主机上不同容器在宿主机上的映射端口必须区分开以避免端口冲突；\",\"B\":\"容器迁移到不同宿主机时，很可能需要改变所映射的宿主机端口，控制比较麻烦\",\"C\":\"通过NAT通信使得容器网络数据包在骨干网上使用的不是自身的IP，给防火墙策略带来不便\",\"D\":\"端口映射带来的网络性能损失，笔者自己的环境下测试结果是，使用NAT方式的容器在进行跨宿主机通信是，吞吐率只能达到宿主机间吞吐率的1/2\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693447, 1587437104111140866, 1, '下面关于隧道方案中，叙述正确的是', '{\"A\":\"隧道方案是借助容器宿主机网络，构建出一个对于容器来说三层路由可达虚拟网络\",\"B\":\"隧道方案的好处是没有NAT方案的端口冲突问题、不消耗额外的骨干网络IP\",\"C\":\"隧道方案的实施、定制化、维护的成本比较低\",\"D\":\"如果容器平台中运行业务与其它平台上运行业务需要通信，则需要配置从容器外部访问容器的路由，否则容器的地址从容器平台外部不能直接路由访问\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693448, 1587437104111140866, 1, '在计算机局域网中，常用通信设备有', '{\"A\":\"集线器\",\"B\":\"交换机\",\"C\":\"调制解调器\",\"D\":\"路由器\"}', 'ABD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693449, 1587437104111140866, 1, '交换机的主要功能有哪些', '{\"A\":\"环路避免\",\"B\":\"路由转发\",\"C\":\"转发\\\\过滤\",\"D\":\"地址学习\"}', 'ACD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693450, 1587437104111140866, 1, '将文件file1复制为file2可以用下面哪些命令', '{\"A\":\"cp file1 file2\",\"B\":\"cat file1 &amp;gt;file2\",\"C\":\"cat &amp;lt; file1 &amp;gt;file2\",\"D\":\"dd if=file1 of=file2\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693451, 1587437104111140866, 1, '在将/目录下的www文件权限改为只有主用户有执行的权限的有', '{\"A\":\"chmod 100 /www\",\"B\":\"chmod 001 /www\",\"C\":\"chmod u+x ,g-x,o-x /www\",\"D\":\"chmod o-x,g-x,u-x /www\"}', 'AC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693452, 1587437104111140866, 1, '下列哪些是zookeeper的选举算法', '{\"A\":\"basic paxos\",\"B\":\"fast paxos\",\"C\":\"master paxos\",\"D\":\"slaver paxos\"}', 'AB', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693453, 1587437104111140866, 1, 'Zabbix是一款能够监控各种网络参数以及服务器____和____的软件。', '{\"A\":\"健康性\",\"B\":\"完整性\",\"C\":\"运行速度\",\"D\":\"漏洞修复\"}', 'AB', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693454, 1587437104111140866, 1, '在OpenStack平台中，下面哪些不是用于定义可以访问资源的集合', '{\"A\":\"User\",\"B\":\"Project\",\"C\":\"Role\",\"D\":\"Domain\"}', 'ACD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693455, 1587437104111140866, 1, '下列选项当中，哪些不是Neutron查询网络详情的命令', '{\"A\":\"neutron agent-list\",\"B\":\"neutron net-list\",\"C\":\"neutron agent-show\",\"D\":\"neutron net-show\"}', 'ACD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693456, 1587437104111140866, 1, '一个典型的HOT模板由下列哪些元素构成？', '{\"A\":\"模板版本\",\"B\":\"参数列表\",\"C\":\"资源列表\",\"D\":\"输出列表\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693457, 1587437104111140866, 1, '下列关于地域和可用区的描述中，正确的是？', '{\"A\":\"每个地域（region）都是一个独立的地理区域\",\"B\":\"每个地域都是完全独立的\",\"C\":\"每个可用区都是不独立的，同一地域下的可用区通过低时延的内网链路相连\",\"D\":\"每个可用区都是独立的，但同一地域下的可用区不提供互相通信能力\"}', 'AB', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693458, 1587437104111140866, 1, '以下哪些是黑石服务器的应用场景？', '{\"A\":\"游戏应用\",\"B\":\"直播应用\",\"C\":\"低频应用\",\"D\":\"政企应用\"}', 'ABD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693459, 1587437104111140866, 1, '使用云计算的好处有哪些？', '{\"A\":\"无需关注规划建设类工作，包括：机房设计、土建施工、机柜摆放、UPS供电、精密空调温湿度调整等\",\"B\":\"无需关注部署类工作，包括：服务器、存储、网络等物理设备的上架和安装、基础架构部署、业务系统部署等\",\"C\":\"无需关注运维类工作，包括：安全运维、可用性、可靠性管理等\",\"D\":\"任何工作都无需自己做\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693460, 1587437104111140866, 1, '在NIST（美国国家标准技术研究院）的“The NIST Definition of Cloud Computing”文档中，定义了云的哪几种模式？', '{\"A\":\"公有云\",\"B\":\"私有云\",\"C\":\"混合云\",\"D\":\"行业云\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693461, 1587437104111140866, 1, 'Kubernetes可以实现容器集群的____等功能', '{\"A\":\"自动化部署\",\"B\":\"自动扩缩容\",\"C\":\"维护\",\"D\":\"状态动态协调及负载均衡\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693462, 1587437104111140866, 1, '下面关于Docker Registry的说法，错误的是？', '{\"A\":\"一个集中的存储、分发镜像的服务\",\"B\":\"一个Docker Registry中可以包含多个仓库，每个仓库可以包含多个标签（Tag）；每个标签对应多个镜像\",\"C\":\"仓库名经常以两段式路径形式出现\",\"D\":\"Docker Registry服务可以分为三种\"}', 'BD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693463, 1587437104111140866, 1, '下面关于OpenShift核心流程的说法，正确的是？', '{\"A\":\"OpenShift项目，最核心的流程就是将应用从静态的源代码变成动态的应用服务的过程\",\"B\":\"应用构建分为部署应用、触发构建、实例化构建、生成镜像、更新Image Stream几个步骤\",\"C\":\"应用部署分为触发镜像部署、实例化镜像部署、生成Replication Cotroller、部署容器几个步骤\",\"D\":\"请求处理分为用户访问、请求处理并返回两个步骤\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693464, 1587437104111140866, 1, ' OpenStack项目作为一个IaaS平台，提供了哪几种使用方式_____。', '{\"A\":\"通过Web界面\",\"B\":\"通过命令行\",\"C\":\"通过API\",\"D\":\"通过实时编译\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693465, 1587437104111140866, 1, 'Requests库中提供了如下哪些常用的类_____。', '{\"A\":\"requests.Request\",\"B\":\"requests.Response\",\"C\":\"request.Session\",\"D\":\"class\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587437105029693466, 1587437104111140866, 2, '网络管理 通过一条命令在S1交换机上创建vlan100、vlan101，配置vlan100网关为：172.16.100.254/24。配置vlan101网关为：172.16.101.254/24。配置g0/0/1端口为trunk模式，放行vlan100。配置g0/0/2端口为access模式，所属vlan101。将上述操作命令及返回结果以文本形式提交到答题框。', 'null', '\n[SW1]vlan batch 101 102\n[SW1]interface Vlanif 100\n[SW1-Vlanif100]ip address 172.16.100.254 24\n[SW1]interface Vlanif 101\n[SW1-Vlanif101]ip address 172.16.101.254 24\n[SW1]interface GigabitEthernet 0/0/1\n[SW1-GigabitEthernet0/0/1]port link-type trunk\n[SW1-GigabitEthernet0/0/1]port trunk allow-pass vlan 100\n[SW1-GigabitEthernet0/0/1]quit\n[SW1]interface GigabitEthernet 0/0/2\n[SW1-GigabitEthernet0/0/2]port link-type access\n[SW1-GigabitEthernet0/0/2]port default vlan 101\n[SW1-GigabitEthernet0/0/2]quit', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693467, 1587437104111140866, 2, '防火墙管理  配置防火墙g0/0/2为trust域，配置g0/0/1为untrust域，配置g0/0/2地址为10.10.5.1/24，配置g0/0/1端口地址为192.168.10.254/24，配置默认路由下一跳为192.168.10.1，配置从trust域到untrust域策略，匹配放行内部地址为172.16.0.0/16网段，配置从trust域到untrust域nat策略，匹配内部地址为172.16.0.0/16网段，使用g0/0/1端口地址。将上述操作命令及返回结果以文本形式提交到答题框。', 'null', '\n[SRG]firewall zone trust\n[SRG-zone-trust]add interface GigabitEthernet 0/0/2\n[SRG-zone-trust]quit\n[SRG]firewall zone untrust\n[SRG-zone-untrust]add interface GigabitEthernet 0/0/1\n[SRG-zone-untrust]quit\n[SRG]interface GigabitEthernet 0/0/2\n[SRG-GigabitEthernet0/0/2]ip address 10.10.5.1 24\n[SRG-GigabitEthernet0/0/2]quit\n[SRG]interface GigabitEthernet 0/0/1\n[SRG-GigabitEthernet0/0/1]ip address 192.168.10.254 24\n[SRG-GigabitEthernet0/0/1]quit\n[SRG]ip route-static 0.0.0.0 0 192.168.10.1\n[SRG]policy interzone trust untrust outbound\n[SRG-policy-interzone-trust-untrust-outbound]policy 0\n[SRG-policy-interzone-trust-untrust-outbound-0]action permit\n[SRG-policy-interzone-trust-untrust-outbound-0]policy source 172.16.0.0 0.0.255.255\n[SRG-policy-interzone-trust-untrust-outbound-0]quit\n[SRG-policy-interzone-trust-untrust-outbound]quit\n[SRG]nat-policy interzone trust untrust outbound\n[SRG-nat-policy-interzone-trust-untrust-outbound]policy 1\n[SRG-nat-policy-interzone-trust-untrust-outbound-1]action source-nat\n[SRG-nat-policy-interzone-trust-untrust-outbound-1]policy source 172.16.0.0 0.0.255.255\n[SRG-nat-policy-interzone-trust-untrust-outbound-1]easy-ip GigabitEthernet 0/0/1\n[SRG-nat-policy-interzone-trust-untrust-outbound-1]quit', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693468, 1587437104111140866, 2, 'YUM源管理 假设当前有一个centos7.2-1511.iso的镜像文件，使用这个文件配置yum源，要求将这个镜像文件挂载在/opt/centos目录。还存在一个ftp源，IP地址为192.168.100.200，ftp配置文件中配置为anon_root=/opt，/opt目录中存在一个iaas目录（该目录下存在一个repodata目录）请问如何配置自己的local.repo文件，使得可以使用这两个地方的软件包，安装软件。请将local.repo文件的内容以文本形式提交到答题框。', 'null', '\n[centos]\nname=centos\nbaseurl=file:///opt/centos\ngpgcheck=0\nenabled=1\n[iaas]\nname=iaas\nbaseurl=ftp://192.168.100.200/iaas\ngpgcheck=0\nenabled=1', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693469, 1587437104111140866, 2, 'Raid管理 使用提供的虚拟机和软件包，完成Raid磁盘阵列的创建。当前虚拟机存储在一个大小为20G的磁盘vdb，利用磁盘分区新建4个磁盘分区，每个大小为5 GB。用3个5 GB的分区来模拟一个名为md5，级别为raid 5，外加一个热备盘的磁盘阵列。创建完成后将mdadm -D /dev/md5的返回结果以文本形式提交到答题框。', 'null', '\n[root@localhost ~]# mdadm -D /dev/md5\n/dev/md5:\nVersion : 1.2\nCreation Time : Sat Oct  5 13:17:41 2019\nRaid Level : raid5\nArray Size : 41908224 (39.97 GiB 42.91 GB)\nUsed Dev Size : 20954112 (19.98 GiB 21.46 GB)\nRaid Devices : 3\nTotal Devices : 4\nPersistence : Superblock is persistent\nUpdate Time : Sat Oct  5 13:19:27 2019\nState : clean\nActive Devices : 3\nWorking Devices : 4\nFailed Devices : 0\nSpare Devices : 1\nLayout : left-symmetric\nChunk Size : 512K\nConsistency Policy : unknown\nName : localhost.localdomain:5  (local to host localhost.localdomain)\nUUID : f51467bd:1199242b:bcb73c7c:160d523a\nEvents : 18\nNumber   Major   Minor   RaidDevice State\n0  8  16   0 active sync   /dev/sdb\n1  8  32   1 active sync   /dev/sdc\n4  8  48   2 active sync   /dev/sdd\n3  8  64   - spare   /dev/sde', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693470, 1587437104111140866, 2, '应用商城系统  使用提供的软件包和提供的虚拟机，完成单节点应用系统部署。部署完成后，进行登录，（订单中填写的收货地址填写自己学校的地址，收货人填写自己的实际联系方式）最后使用curl命令去获取商城首页的返回信息，将curl http://你自己的商城IP/#/home获取到的结果以文本形式提交到答题框。', 'null', '\n[root@server ~]# curl http://172.30.11.27/#/home\n&lt;!DOCTYPE html&gt;&lt;html&gt;&lt;head&gt;&lt;meta charset=utf-8&gt;&lt;title&gt;1+x-示例项目&lt;/title&gt;&lt;meta name=keywords content=\"\"&gt;&lt;meta name=description content=\"\"&gt;&lt;meta http-equiv=X-UA-Compatible content=\"IE=Edge\"&gt;&lt;meta name=wap-font-scale content=no&gt;&lt;link rel=\"shortcut icon \" type=images/x-icon href=/static/images/favicon.ico&gt;&lt;link href=/static/css/app.8d4edd335a61c46bf5b6a63444cd855a.css rel=stylesheet&gt;&lt;/head&gt;&lt;body&gt;&lt;div id=app&gt;&lt;/div&gt;&lt;script type=text/javascript src=/static/js/manifest.2d17a82764acff8145be.js&gt;&lt;/script&gt;&lt;script type=text/javascript src=/static/js/vendor.4f07d3a235c8a7cd4efe.js&gt;&lt;/script&gt;&lt;script type=text/javascript src=/static/js/app.81180cbb92541cdf912f.js&gt;&lt;/script&gt;&lt;/body&gt;&lt;/html&gt;&lt;style&gt;body{\nmin-width:1250px;', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693471, 1587437104111140866, 2, '数据库运维  使用上一题安装的数据库，进行数据库备份操作，要求使用mysqldump命令将gpmall数据库导出进行备份，备份名为gpmall_bak.sql，并存放在/opt目录下（使用绝对路径），将上述所有操作命令和返回结果以文本形式提交到答题框。', 'null', '[root@mysql ~]\n# mysqldump -uroot -p123456 gpmall &gt; /opt/gpmall_bak.sql\n[root@mysql opt ]# ls\ngpmall_bak.sql', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693472, 1587437104111140866, 2, '主从数据库管理 使用提供的两台虚拟机，在虚拟机上安装mariadb数据库，并配置为主从数据库，实现两个数据库的主从同步。配置完毕后，请在从节点上的数据库中执行 “show slave status \\G” 命令查询从节点复制状态，将查询到的结果以文本形式提交到答题框。', 'null', '\nMariaDB [(none)]&gt; start slave;\nMariaDB [(none)]&gt; show slave status\\G\n*************************** 1. row ***************************\nSlave_IO_State: Waiting for master to send event\nMaster_Host: mysql1\nMaster_User: user\nMaster_Port: 3306\nConnect_Retry: 60\nMaster_Log_File: mysql-bin.000003\nRead_Master_Log_Pos: 245\nRelay_Log_File: mariadb-relay-bin.000005\nRelay_Log_Pos: 529\nRelay_Master_Log_File: mysql-bin.000003\nSlave_IO_Running: Yes\nSlave_SQL_Running: Yes\nReplicate_Do_DB:\nReplicate_Ignore_DB:\nReplicate_Do_Table:\nReplicate_Ignore_Table:\nReplicate_Wild_Do_Table:\nReplicate_Wild_Ignore_Table:\nLast_Errno: 0\nLast_Error:\nSkip_Counter: 0\nExec_Master_Log_Pos: 245\nRelay_Log_Space: 1256\nUntil_Condition: None\nUntil_Log_File:\nUntil_Log_Pos: 0\nMaster_SSL_Allowed: No\nMaster_SSL_CA_File:\nMaster_SSL_CA_Path:\nMaster_SSL_Cert:\nMaster_SSL_Cipher:\nMaster_SSL_Key:\nSeconds_Behind_Master: 0\nMaster_SSL_Verify_Server_Cert: No\nLast_IO_Errno: 0\nLast_IO_Error:\nLast_SQL_Errno: 0\nLast_SQL_Error:\nReplicate_Ignore_Server_Ids:\nMaster_Server_Id: 30\n1 row in set (0.00 sec)', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693473, 1587437104111140866, 2, '  读写分离数据库管理  使用提供的虚拟机与软件包，基于上一题构建的主从数据库，进一步完成Mycat读写分离数据库的配置安装。需要用的配置文件schema.xml文件如下所示（server.xml文件不再给出）：', 'null', '<!--?xml version=\"1.0\"?-->\n\n<mycat:schema xmlns:mycat=\"http://io.mycat/\">\n<schema name=\"USERDB\" checksqlschema=\"true\" sqlmaxlimit=\"100\" datanode=\"dn1\"></schema>\n<datanode name=\"dn1\" datahost=\"localhost1\" database=\"test\">\n<datahost name=\"localhost1\" maxcon=\"1000\" mincon=\"10\" balance=\"3\" dbtype=\"mysql\" dbdriver=\"native\" writetype=\"0\" switchtype=\"1\" slavethreshold=\"100\">\n<heartbeat>select user()</heartbeat>\n<writehost host=\"hostM1\" url=\"172.16.51.18:3306\" user=\"root\" password=\"123456\">\n<readhost host=\"hostS1\" url=\"172.16.51.30:3306\" user=\"root\" password=\"123456\">\n</readhost></writehost>\n</datahost>\n</datanode></mycat:schema>', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693474, 1587437104111140866, 2, '配置读写分离数据库完毕后，使用netstat -ntpl命令查询端口启动情况。最后将netstat -ntpl命令的返回结果以文本形式提交到答题框。', 'null', '', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693475, 1587437104111140866, 2, 'Keystone服务运维  使用提供的“all-in-one”虚拟机，使用openstack命令，创建一个名称为“alice”账户，密码为“mypassword123”，邮箱为“alice@example.com”。并且创建一个名为“acme”项目。创建一个角色“compute-user”。给用户“alice”分配“acme”项目下的“compute-user”角色。将以上操作命令及结果以文本形式填入答题框。', 'null', '\n[root@xiandian ~]# source /etc/keystone/admin-openrc.sh\"[root@xiandian ~]# openstack user create --password mypassword123 --email alice@example.com --domain domain alice\"+-----------+----------------------------------+\"| Field| Value |\"+-----------+----------------------------------+\"| domain_id | 3ac89594c8e944a9b5bb567fca4e75aa |\"| email| alice@example.com|\"| enabled   | True  |\"| id   | 17122f34cbf94aba835195bd94758753 |\"| name | alice |\"+-----------+----------------------------------+\"[root@xiandian ~]# openstack project create --domain domain acme\"+-------------+----------------------------------+\"| Field  | Value |\"+-------------+----------------------------------+\"| description | |\"| domain_id   | 3ac89594c8e944a9b5bb567fca4e75aa |\"| enabled| True  |\"| id| b1304aa3b53a4203821c1eef5fcc05fc |\"| is_domain   | False |\"| name   | acme  |\"| parent_id   | 3ac89594c8e944a9b5bb567fca4e75aa |\"+-------------+----------------------------------+\"[root@xiandian ~]# openstack role create compute-user\"+-----------+----------------------------------+\"| Field| Value |\"+-----------+----------------------------------+\"| domain_id | None  |\"| id   | 87b10d35ed044038b7bf0960ca2f37c0 |\"| name | compute-user|\"+-----------+----------------------------------+\"[root@xiandian ~]# openstack role add --user alice  --project acme  compute-user', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693476, 1587437104111140866, 2, ' Glance服务运维  <使用提供的“all-in-one”虚拟机，使用Glance命令，创建一个名称为“cirros”镜像，镜像文件使用提供的为“cirros-0.3.4-x86_64-disk.img”。通过glance 命令查看镜像“cirros”的详细信息。使用glance 命令更新镜像信息min-disk（min-disk默认单位为G）为1G。将以上操作命令及结果以文本形式填入答题框。', 'null', '[root@xiandian images]# glance image-create --name \"cirros\" --disk-format qcow2 --container-format bare --progress &lt; cirros-0.3.4-x86_64-disk.img\n[=============================&gt;] 100%\n+------------------+--------------------------------------+\n| Property    | Value|\n+------------------+--------------------------------------+\n| checksum    | 64d7c1cd2b6f60c92c14662941cb7913|\n| container_format | bare|\n| created_at  | 2019-09-28T04:57:59Z |\n| disk_format | qcow2|\n| id    | db715025-a795-4519-9947-c5acbe2d5788 |\n| min_disk    | 0   |\n| min_ram| 0   |\n| name  | cirros    |\n| owner | 0ab2dbde4f754b699e22461426cd0774|\n| protected   | False|\n| size  | 13167616  |\n| status| active    |\n| tags  | []  |\n| updated_at  | 2019-09-28T04:58:00Z |\n| virtual_size| None|\n| visibility  | private   |\n+------------------+--------------------------------------+\n# glance image-show db715025-a795-4519-9947-c5acbe2d5788\n+------------------+--------------------------------------+\n| Property    | Value|\n+------------------+--------------------------------------+\n| checksum    | 64d7c1cd2b6f60c92c14662941cb7913|\n| container_format | bare|\n| created_at  | 2019-09-28T04:57:59Z |\n| disk_format | qcow2|\n| id    | db715025-a795-4519-9947-c5acbe2d5788 |\n| min_disk    | 0   |\n| min_ram| 0   |\n| name  | cirros    |\n| owner | 0ab2dbde4f754b699e22461426cd0774|\n| protected   | False|\n| size  | 13167616  |\n| status| active    |\n| tags  | []  |\n| updated_at  | 2019-09-28T04:58:00Z |\n| virtual_size| None|\n| visibility  | private   |\n+------------------+--------------------------------------+\n# glance image-update --min-disk=1 db715025-a795-4519-9947-c5acbe2d5788\n+------------------+--------------------------------------+\n| Property    | Value|\n+------------------+--------------------------------------+\n| checksum    | 64d7c1cd2b6f60c92c14662941cb7913|\n| container_format | bare|\n| created_at  | 2019-09-28T04:57:59Z |\n| disk_format | qcow2|\n| id    | db715025-a795-4519-9947-c5acbe2d5788 |\n| min_disk    | 1   |\n| min_ram| 0   |\n| name  | cirros    |\n| owner | 0ab2dbde4f754b699e22461426cd0774|\n| protected   | False|\n| size  | 13167616  |\n| status| active    |\n| tags  | []  |\n| updated_at  | 2019-09-28T05:22:09Z |\n| virtual_size| None|\n| visibility  | private   |\n+------------------+--------------------------------------+', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693477, 1587437104111140866, 2, ' Nova服务运维(40分)  <使用提供的“all-in-one”虚拟机，使用Nova命令，创建一个名为test的安全组，描述为\'test the nova command about the rules\'。并且使用命令创建一个名为test，ID为6，内存为2048 MB，磁盘为20 GB，vcpu数量为2的云主机类型，查看test云主机类型的详细信息。将以上操作命令及结果以文本形式填入答题框。', 'null', '# nova secgroup-create test \'test the nova command about the rules\'\n+--------------------------------------+------+---------------------------------------+\n| Id  | Name | Description|\n+--------------------------------------+------+---------------------------------------+\n| d1ce4ef1-26c8-4b3d-958b-bc778bf283f3 | test | test the nova command about the rules |\n+--------------------------------------+------+---------------------------------------+\n# nova flavor-create test 6 2048 20 2\n+----+------+-----------+------+-----------+------+-------+-------------+-----------+\n| ID | Name | Memory_MB | Disk | Ephemeral | Swap | VCPUs | RXTX_Factor | Is_Public |\n+----+------+-----------+------+-----------+------+-------+-------------+-----------+\n| 6  | test | 2048 | 20   | 0    | | 2| 1.0    | True |\n+----+------+-----------+------+-----------+------+-------+-------------+-----------+\n# nova flavor-show test\n+----------------------------+-------+\n| Property   | Value |\n+----------------------------+-------+\n| OS-FLV-DISABLED:disabled   | False |\n| OS-FLV-EXT-DATA:ephemeral  | 0|\n| disk | 20    |\n| extra_specs| {}    |\n| id   | 6|\n| name | test  |\n| os-flavor-access:is_public | True  |\n| ram  | 2048  |\n| rxtx_factor| 1.0   |\n| swap |  |\n| vcpus| 2|\n+----------------------------+-------+', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693478, 1587437104111140866, 2, 'Docker安装  使用提供的虚拟机和软件包，自行配置YUM源，安装docker-ce服务。安装完毕后执行docker info命令的返回结果以文本形式提交到答题框。', 'null', '\nContainers: 33\nRunning: 16\nPaused: 0\nStopped: 17\nImages: 22\nServer Version: 18.09.6\nStorage Driver: devicemapper\nPool Name: docker-253:0-113162281-pool\nPool Blocksize: 65.54kB\nBase Device Size: 10.74GB\nBacking Filesystem: xfs\nUdev Sync Supported: true\nData file: /dev/loop0\nMetadata file: /dev/loop1\nData loop file: /var/lib/docker/devicemapper/devicemapper/data\nMetadata loop file: /var/lib/docker/devicemapper/devicemapper/metadata\nData Space Used: 3.573GB\nData Space Total: 107.4GB\nData Space Available: 18.72GB\nMetadata Space Used: 22.59MB\nMetadata Space Total: 2.147GB\nMetadata Space Available: 2.125GB\nThin Pool Minimum Free Space: 10.74GB\nDeferred Removal Enabled: true\nDeferred Deletion Enabled: true\nDeferred Deleted Device Count: 0\nLibrary Version: 1.02.158-RHEL7 (2019-05-13)\nLogging Driver: json-file\nCgroup Driver: cgroupfs\nPlugins:\nVolume: local\nNetwork: bridge host macvlan null overlay\nLog: awslogs fluentd gcplogs gelf journald json-file local logentries splunk syslog\nSwarm: inactive\nRuntimes: runc\nDefault Runtime: runc\nInit Binary: docker-init\ncontainerd version: b34a5c8af56e510852c35414db4c1f4fa6172339\nrunc version: 3e425f80a8c931f88e6d94a8c831b9d5aa481657\ninit version: fec3683\nSecurity Options:\nseccomp\nProfile: default\nKernel Version: 3.10.0-1062.7.1.el7.x86_64\nOperating System: CentOS Linux 7 (Core)\nOSType: linux\nArchitecture: x86_64\nCPUs: 2\nTotal Memory: 1.913GiB\nName: master\nID: U4ME:YWV6:WZEK:7R7W:5OLN:MO4A:NVNH:AEPR:L7GE:UD4S:UZOY:GZXQ\nDocker Root Dir: /var/lib/docker\nDebug Mode (client): false\nDebug Mode (server): false\nRegistry: https://index.docker.io/v1/\nLabels:\nExperimental: false\nInsecure Registries:\n192.168.70.10:5000\n127.0.0.0/8\nLive Restore Enabled: false\nProduct License: Community Engine\nWARNING: the devicemapper storage-driver is deprecated, and will be removed in a future release.\nWARNING: devicemapper: usage of loopback devices is strongly discouraged for production use.\nUse `--storage-opt dm.thinpooldev` to specify a custom block storage device.', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693479, 1587437104111140866, 2, '部署Swarm集群  使用提供的虚拟机，自行配置好网络，安装好docker-ce。部署Swarm集群，并安装Portainer图形化管理工具，部署完成后，使用浏览器登录ip:9000界面，进入Swarm控制台。将curl swarm ip:9000返回的结果以文本形式提交到答题框。', 'null', '[root@master ~]# curl 192.168.100.10:9000\n&lt;!DOCTYPE html&gt;&lt;html lang=\"en\" ng-app=\"portainer\"&gt;\n&lt;head&gt;\n&lt;meta charset=\"utf-8\"&gt;\n&lt;title&gt;Portainer&lt;/title&gt;\n&lt;meta name=\"description\" content=\"\"&gt;\n&lt;meta name=\"author\" content=\"Portainer.io\"&gt;\n&lt;div class=\"row\" style=\"text-align: center\"&gt;\nLoading Portainer...\n&lt;i class=\"fa fa-cog fa-spin\" style=\"margin-left: 5px\"&gt;&lt;/i&gt;\n&lt;/div&gt;\n&lt;!-- !panel --&gt;\n&lt;/div&gt;', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693480, 1587437104111140866, 2, 'Kubernetes平台搭建  使用提供的虚拟机和软件包，搭建Kubernetes平台，平台的两个节点分别为master和node节点，在将node节点加入到集群后，登录master节点，使用kubectl get nodes查询各节点状态。将查询节点状态的返回结果以文本形式提交到答题框。', 'null', '\n kubectl get nodes\nNAMESTATUS   ROLES    AGEVERSION\nmaster   Ready    master   117m    v1.14.1\nnodeReady    &lt;none&gt;   6m30s   v1.14.1', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587437105029693481, 1587437104111140866, 2, '送分题', 'null', '送分了', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118251261953, 1587604117206880258, 0, '项目部署与测试阶段中，不需要参与的角色是', '{\"A\":\"系统运维人员\",\"B\":\"测试人员\",\"C\":\"项目经理\",\"D\":\"开发人员\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261954, 1587604117206880258, 0, '在项目立项启动阶段，开发经理不需要验证哪份报告', '{\"A\":\"《用户需求说明书》\",\"B\":\"《项目立项建议书》\",\"C\":\"《可行分析报告》\",\"D\":\"《项目计划书》\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261955, 1587604117206880258, 0, '在交换机中可以VLAN的取值范围是多少', '{\"A\":\"1-4094\",\"B\":\"0-4096\",\"C\":\"1-4096\",\"D\":\"1-4095\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261956, 1587604117206880258, 0, '二层以太网交换机在MAC地址表中查找与帧目的MAC地址匹配的表项，从而将帧从相应接口转发出去，如果查找失败，交换机将', '{\"A\":\"查找路由表\",\"B\":\"把帧丢弃\",\"C\":\"查找快速转发表\",\"D\":\"把帧由除入端口以外的所有其他端口发送出去\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261957, 1587604117206880258, 0, '下面哪个命令不是用来查看网络故障？', '{\"A\":\"telnet\",\"B\":\"ping\",\"C\":\"init\",\"D\":\"netstat\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261958, 1587604117206880258, 0, '在Linux系统的vi编辑器中，如果不保存对文件进行的修改，应使用什么命令强制退出vi编辑器', '{\"A\":\":q\",\"B\":\":wq\",\"C\":\":q!\",\"D\":\":!q\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261959, 1587604117206880258, 0, '如果使用SQLite，Zabbix Web界面必须要跟Zabbix Server满足什么条件？', '{\"A\":\"运行在同一台物理机器上\",\"B\":\"不能在同一台物理机器上\",\"C\":\"需要在同一局域网\",\"D\":\"无需在同一局域网\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261960, 1587604117206880258, 0, '主从数据库复制整体来说分为几个步骤?', '{\"A\":\"1\",\"B\":\"2\",\"C\":\"3\",\"D\":\"4\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261961, 1587604117206880258, 0, '关于Keystone认证服务下列说法中错误的是？', '{\"A\":\"认证是确认允许一个用户访问的进程。\",\"B\":\"证书用于确认用户身份的数据。\",\"C\":\"令牌的有效期是无限的，可以随时被撤回。\",\"D\":\"使用服务的用户，可以是人、服务或系统使用OpenStack相关服务的一个组织。\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261962, 1587604117206880258, 0, 'Openstack系统架构不包含以下哪个组件？', '{\"A\":\"Hive\",\"B\":\"Neutron\",\"C\":\"Glance\",\"D\":\"Heat\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261963, 1587604117206880258, 0, 'OpenStack中的计算模块是以下哪个模块？', '{\"A\":\"Nova\",\"B\":\"Glance\",\"C\":\"Swift\",\"D\":\"Cinder\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261964, 1587604117206880258, 0, '某客户为快速开展业务，需要一个开箱即用的业务系统，要求统一服务、流程、模型和体验，那么应该选择哪一类型的云计算服务？', '{\"A\":\"基础设施即服务（IaaS）\",\"B\":\"平台即服务（PaaS）\",\"C\":\"软件即服务（SaaS）\",\"D\":\"云即服务（CaaS）\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261965, 1587604117206880258, 0, '下列哪个不是上云业务的需求特征？', '{\"A\":\"广泛的网络访问\",\"B\":\"按需使用服务\",\"C\":\"超大的资源池\",\"D\":\"拥有更多的固定资产\"}', 'D', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261966, 1587604117206880258, 0, ' 以下关于跨地域网络设计的描述中，正确的选项是？', '{\"A\":\"同一个子网可以跨地域部署\",\"B\":\"同一个子网不可以跨地域部署\",\"C\":\"将同一个子网部署到多地域可以提供容灾能力\",\"D\":\"将同一个子网部署到多地域可以提供网络性能\"}', 'B', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261967, 1587604117206880258, 0, '关于腾讯云的CDN加速功能，主要包括全面加速和安全防护两个方面，下列哪个选项不属于全面加速？', '{\"A\":\"静态内容加速\",\"B\":\"直播加速\",\"C\":\"下载分发加速\",\"D\":\"海外加速\"}', 'B', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118251261968, 1587604117206880258, 0, 'Yml是一种什么语言？', '{\"A\":\"标记\",\"B\":\"非标记\",\"C\":\"静态\",\"D\":\"动态\"}', 'B', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176514, 1587604117206880258, 0, '在K8S的核心组件中负责维护集群状态的组件是', '{\"A\":\"controller manage\",\"B\":\"scheduler\",\"C\":\"kubelet\",\"D\":\"etcd\"}', 'A', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176515, 1587604117206880258, 0, '关于Keystone认证服务下列说法中错误的是？', '{\"A\":\"认证是确认允许一个用户访问的进程。\",\"B\":\"证书用于确认用户身份的数据。\",\"C\":\"令牌的有效期是无限的，可以随时被撤回。\",\"D\":\"使用服务的用户，可以是人、服务或系统使用OpenStack相关服务的一个组织。\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176516, 1587604117206880258, 0, 'Ansible自动化运维工具是基于以下哪种语言开发？', '{\"A\":\"Java\",\"B\":\"C语言\",\"C\":\"Python\",\"D\":\"C++\"}', 'C', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176517, 1587604117206880258, 1, '下面关于原生NAT方案中叙述正确的是', '{\"A\":\"同一宿主机上不同容器在宿主机上的映射端口必须区分开以避免端口冲突；\",\"B\":\"容器迁移到不同宿主机时，很可能需要改变所映射的宿主机端口，控制比较麻烦\",\"C\":\"通过NAT通信使得容器网络数据包在骨干网上使用的不是自身的IP，给防火墙策略带来不便\",\"D\":\"端口映射带来的网络性能损失，笔者自己的环境下测试结果是，使用NAT方式的容器在进行跨宿主机通信是，吞吐率只能达到宿主机间吞吐率的1/2\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176518, 1587604117206880258, 1, '下面关于隧道方案中，叙述正确的是', '{\"A\":\"隧道方案是借助容器宿主机网络，构建出一个对于容器来说三层路由可达虚拟网络\",\"B\":\"隧道方案的好处是没有NAT方案的端口冲突问题、不消耗额外的骨干网络IP\",\"C\":\"隧道方案的实施、定制化、维护的成本比较低\",\"D\":\"如果容器平台中运行业务与其它平台上运行业务需要通信，则需要配置从容器外部访问容器的路由，否则容器的地址从容器平台外部不能直接路由访问\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176519, 1587604117206880258, 1, '在计算机局域网中，常用通信设备有', '{\"A\":\"集线器\",\"B\":\"交换机\",\"C\":\"调制解调器\",\"D\":\"路由器\"}', 'ABD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176520, 1587604117206880258, 1, '交换机的主要功能有哪些', '{\"A\":\"环路避免\",\"B\":\"路由转发\",\"C\":\"转发\\\\过滤\",\"D\":\"地址学习\"}', 'ACD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176521, 1587604117206880258, 1, '将文件file1复制为file2可以用下面哪些命令', '{\"A\":\"cp file1 file2\",\"B\":\"cat file1 &amp;gt;file2\",\"C\":\"cat &amp;lt; file1 &amp;gt;file2\",\"D\":\"dd if=file1 of=file2\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176522, 1587604117206880258, 1, '在将/目录下的www文件权限改为只有主用户有执行的权限的有', '{\"A\":\"chmod 100 /www\",\"B\":\"chmod 001 /www\",\"C\":\"chmod u+x ,g-x,o-x /www\",\"D\":\"chmod o-x,g-x,u-x /www\"}', 'AC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176523, 1587604117206880258, 1, '下列哪些是zookeeper的选举算法', '{\"A\":\"basic paxos\",\"B\":\"fast paxos\",\"C\":\"master paxos\",\"D\":\"slaver paxos\"}', 'AB', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176524, 1587604117206880258, 1, 'Zabbix是一款能够监控各种网络参数以及服务器____和____的软件。', '{\"A\":\"健康性\",\"B\":\"完整性\",\"C\":\"运行速度\",\"D\":\"漏洞修复\"}', 'AB', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176525, 1587604117206880258, 1, '在OpenStack平台中，下面哪些不是用于定义可以访问资源的集合', '{\"A\":\"User\",\"B\":\"Project\",\"C\":\"Role\",\"D\":\"Domain\"}', 'ACD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176526, 1587604117206880258, 1, '下列选项当中，哪些不是Neutron查询网络详情的命令', '{\"A\":\"neutron agent-list\",\"B\":\"neutron net-list\",\"C\":\"neutron agent-show\",\"D\":\"neutron net-show\"}', 'ACD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176527, 1587604117206880258, 1, '一个典型的HOT模板由下列哪些元素构成？', '{\"A\":\"模板版本\",\"B\":\"参数列表\",\"C\":\"资源列表\",\"D\":\"输出列表\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176528, 1587604117206880258, 1, '下列关于地域和可用区的描述中，正确的是？', '{\"A\":\"每个地域（region）都是一个独立的地理区域\",\"B\":\"每个地域都是完全独立的\",\"C\":\"每个可用区都是不独立的，同一地域下的可用区通过低时延的内网链路相连\",\"D\":\"每个可用区都是独立的，但同一地域下的可用区不提供互相通信能力\"}', 'AB', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176529, 1587604117206880258, 1, '以下哪些是黑石服务器的应用场景？', '{\"A\":\"游戏应用\",\"B\":\"直播应用\",\"C\":\"低频应用\",\"D\":\"政企应用\"}', 'ABD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176530, 1587604117206880258, 1, '使用云计算的好处有哪些？', '{\"A\":\"无需关注规划建设类工作，包括：机房设计、土建施工、机柜摆放、UPS供电、精密空调温湿度调整等\",\"B\":\"无需关注部署类工作，包括：服务器、存储、网络等物理设备的上架和安装、基础架构部署、业务系统部署等\",\"C\":\"无需关注运维类工作，包括：安全运维、可用性、可靠性管理等\",\"D\":\"任何工作都无需自己做\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176531, 1587604117206880258, 1, '在NIST（美国国家标准技术研究院）的“The NIST Definition of Cloud Computing”文档中，定义了云的哪几种模式？', '{\"A\":\"公有云\",\"B\":\"私有云\",\"C\":\"混合云\",\"D\":\"行业云\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176532, 1587604117206880258, 1, 'Kubernetes可以实现容器集群的____等功能', '{\"A\":\"自动化部署\",\"B\":\"自动扩缩容\",\"C\":\"维护\",\"D\":\"状态动态协调及负载均衡\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176533, 1587604117206880258, 1, '下面关于Docker Registry的说法，错误的是？', '{\"A\":\"一个集中的存储、分发镜像的服务\",\"B\":\"一个Docker Registry中可以包含多个仓库，每个仓库可以包含多个标签（Tag）；每个标签对应多个镜像\",\"C\":\"仓库名经常以两段式路径形式出现\",\"D\":\"Docker Registry服务可以分为三种\"}', 'BD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176534, 1587604117206880258, 1, '下面关于OpenShift核心流程的说法，正确的是？', '{\"A\":\"OpenShift项目，最核心的流程就是将应用从静态的源代码变成动态的应用服务的过程\",\"B\":\"应用构建分为部署应用、触发构建、实例化构建、生成镜像、更新Image Stream几个步骤\",\"C\":\"应用部署分为触发镜像部署、实例化镜像部署、生成Replication Cotroller、部署容器几个步骤\",\"D\":\"请求处理分为用户访问、请求处理并返回两个步骤\"}', 'ABCD', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176535, 1587604117206880258, 1, ' OpenStack项目作为一个IaaS平台，提供了哪几种使用方式_____。', '{\"A\":\"通过Web界面\",\"B\":\"通过命令行\",\"C\":\"通过API\",\"D\":\"通过实时编译\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176536, 1587604117206880258, 1, 'Requests库中提供了如下哪些常用的类_____。', '{\"A\":\"requests.Request\",\"B\":\"requests.Response\",\"C\":\"request.Session\",\"D\":\"class\"}', 'ABC', 10, NULL, NULL, 0);
INSERT INTO `test_questions` VALUES (1587604118314176537, 1587604117206880258, 2, '网络管理 通过一条命令在S1交换机上创建vlan100、vlan101，配置vlan100网关为：172.16.100.254/24。配置vlan101网关为：172.16.101.254/24。配置g0/0/1端口为trunk模式，放行vlan100。配置g0/0/2端口为access模式，所属vlan101。将上述操作命令及返回结果以文本形式提交到答题框。', 'null', '\n[SW1]vlan batch 101 102\n[SW1]interface Vlanif 100\n[SW1-Vlanif100]ip address 172.16.100.254 24\n[SW1]interface Vlanif 101\n[SW1-Vlanif101]ip address 172.16.101.254 24\n[SW1]interface GigabitEthernet 0/0/1\n[SW1-GigabitEthernet0/0/1]port link-type trunk\n[SW1-GigabitEthernet0/0/1]port trunk allow-pass vlan 100\n[SW1-GigabitEthernet0/0/1]quit\n[SW1]interface GigabitEthernet 0/0/2\n[SW1-GigabitEthernet0/0/2]port link-type access\n[SW1-GigabitEthernet0/0/2]port default vlan 101\n[SW1-GigabitEthernet0/0/2]quit', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176538, 1587604117206880258, 2, '防火墙管理  配置防火墙g0/0/2为trust域，配置g0/0/1为untrust域，配置g0/0/2地址为10.10.5.1/24，配置g0/0/1端口地址为192.168.10.254/24，配置默认路由下一跳为192.168.10.1，配置从trust域到untrust域策略，匹配放行内部地址为172.16.0.0/16网段，配置从trust域到untrust域nat策略，匹配内部地址为172.16.0.0/16网段，使用g0/0/1端口地址。将上述操作命令及返回结果以文本形式提交到答题框。', 'null', '\n[SRG]firewall zone trust\n[SRG-zone-trust]add interface GigabitEthernet 0/0/2\n[SRG-zone-trust]quit\n[SRG]firewall zone untrust\n[SRG-zone-untrust]add interface GigabitEthernet 0/0/1\n[SRG-zone-untrust]quit\n[SRG]interface GigabitEthernet 0/0/2\n[SRG-GigabitEthernet0/0/2]ip address 10.10.5.1 24\n[SRG-GigabitEthernet0/0/2]quit\n[SRG]interface GigabitEthernet 0/0/1\n[SRG-GigabitEthernet0/0/1]ip address 192.168.10.254 24\n[SRG-GigabitEthernet0/0/1]quit\n[SRG]ip route-static 0.0.0.0 0 192.168.10.1\n[SRG]policy interzone trust untrust outbound\n[SRG-policy-interzone-trust-untrust-outbound]policy 0\n[SRG-policy-interzone-trust-untrust-outbound-0]action permit\n[SRG-policy-interzone-trust-untrust-outbound-0]policy source 172.16.0.0 0.0.255.255\n[SRG-policy-interzone-trust-untrust-outbound-0]quit\n[SRG-policy-interzone-trust-untrust-outbound]quit\n[SRG]nat-policy interzone trust untrust outbound\n[SRG-nat-policy-interzone-trust-untrust-outbound]policy 1\n[SRG-nat-policy-interzone-trust-untrust-outbound-1]action source-nat\n[SRG-nat-policy-interzone-trust-untrust-outbound-1]policy source 172.16.0.0 0.0.255.255\n[SRG-nat-policy-interzone-trust-untrust-outbound-1]easy-ip GigabitEthernet 0/0/1\n[SRG-nat-policy-interzone-trust-untrust-outbound-1]quit', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176539, 1587604117206880258, 2, 'YUM源管理 假设当前有一个centos7.2-1511.iso的镜像文件，使用这个文件配置yum源，要求将这个镜像文件挂载在/opt/centos目录。还存在一个ftp源，IP地址为192.168.100.200，ftp配置文件中配置为anon_root=/opt，/opt目录中存在一个iaas目录（该目录下存在一个repodata目录）请问如何配置自己的local.repo文件，使得可以使用这两个地方的软件包，安装软件。请将local.repo文件的内容以文本形式提交到答题框。', 'null', '\n[centos]\nname=centos\nbaseurl=file:///opt/centos\ngpgcheck=0\nenabled=1\n[iaas]\nname=iaas\nbaseurl=ftp://192.168.100.200/iaas\ngpgcheck=0\nenabled=1', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176540, 1587604117206880258, 2, 'Raid管理 使用提供的虚拟机和软件包，完成Raid磁盘阵列的创建。当前虚拟机存储在一个大小为20G的磁盘vdb，利用磁盘分区新建4个磁盘分区，每个大小为5 GB。用3个5 GB的分区来模拟一个名为md5，级别为raid 5，外加一个热备盘的磁盘阵列。创建完成后将mdadm -D /dev/md5的返回结果以文本形式提交到答题框。', 'null', '\n[root@localhost ~]# mdadm -D /dev/md5\n/dev/md5:\nVersion : 1.2\nCreation Time : Sat Oct  5 13:17:41 2019\nRaid Level : raid5\nArray Size : 41908224 (39.97 GiB 42.91 GB)\nUsed Dev Size : 20954112 (19.98 GiB 21.46 GB)\nRaid Devices : 3\nTotal Devices : 4\nPersistence : Superblock is persistent\nUpdate Time : Sat Oct  5 13:19:27 2019\nState : clean\nActive Devices : 3\nWorking Devices : 4\nFailed Devices : 0\nSpare Devices : 1\nLayout : left-symmetric\nChunk Size : 512K\nConsistency Policy : unknown\nName : localhost.localdomain:5  (local to host localhost.localdomain)\nUUID : f51467bd:1199242b:bcb73c7c:160d523a\nEvents : 18\nNumber   Major   Minor   RaidDevice State\n0  8  16   0 active sync   /dev/sdb\n1  8  32   1 active sync   /dev/sdc\n4  8  48   2 active sync   /dev/sdd\n3  8  64   - spare   /dev/sde', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176541, 1587604117206880258, 2, '应用商城系统  使用提供的软件包和提供的虚拟机，完成单节点应用系统部署。部署完成后，进行登录，（订单中填写的收货地址填写自己学校的地址，收货人填写自己的实际联系方式）最后使用curl命令去获取商城首页的返回信息，将curl http://你自己的商城IP/#/home获取到的结果以文本形式提交到答题框。', 'null', '\n[root@server ~]# curl http://172.30.11.27/#/home\n&lt;!DOCTYPE html&gt;&lt;html&gt;&lt;head&gt;&lt;meta charset=utf-8&gt;&lt;title&gt;1+x-示例项目&lt;/title&gt;&lt;meta name=keywords content=\"\"&gt;&lt;meta name=description content=\"\"&gt;&lt;meta http-equiv=X-UA-Compatible content=\"IE=Edge\"&gt;&lt;meta name=wap-font-scale content=no&gt;&lt;link rel=\"shortcut icon \" type=images/x-icon href=/static/images/favicon.ico&gt;&lt;link href=/static/css/app.8d4edd335a61c46bf5b6a63444cd855a.css rel=stylesheet&gt;&lt;/head&gt;&lt;body&gt;&lt;div id=app&gt;&lt;/div&gt;&lt;script type=text/javascript src=/static/js/manifest.2d17a82764acff8145be.js&gt;&lt;/script&gt;&lt;script type=text/javascript src=/static/js/vendor.4f07d3a235c8a7cd4efe.js&gt;&lt;/script&gt;&lt;script type=text/javascript src=/static/js/app.81180cbb92541cdf912f.js&gt;&lt;/script&gt;&lt;/body&gt;&lt;/html&gt;&lt;style&gt;body{\nmin-width:1250px;', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176542, 1587604117206880258, 2, '数据库运维  使用上一题安装的数据库，进行数据库备份操作，要求使用mysqldump命令将gpmall数据库导出进行备份，备份名为gpmall_bak.sql，并存放在/opt目录下（使用绝对路径），将上述所有操作命令和返回结果以文本形式提交到答题框。', 'null', '[root@mysql ~]\n# mysqldump -uroot -p123456 gpmall &gt; /opt/gpmall_bak.sql\n[root@mysql opt ]# ls\ngpmall_bak.sql', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176543, 1587604117206880258, 2, '主从数据库管理 使用提供的两台虚拟机，在虚拟机上安装mariadb数据库，并配置为主从数据库，实现两个数据库的主从同步。配置完毕后，请在从节点上的数据库中执行 “show slave status \\G” 命令查询从节点复制状态，将查询到的结果以文本形式提交到答题框。', 'null', '\nMariaDB [(none)]&gt; start slave;\nMariaDB [(none)]&gt; show slave status\\G\n*************************** 1. row ***************************\nSlave_IO_State: Waiting for master to send event\nMaster_Host: mysql1\nMaster_User: user\nMaster_Port: 3306\nConnect_Retry: 60\nMaster_Log_File: mysql-bin.000003\nRead_Master_Log_Pos: 245\nRelay_Log_File: mariadb-relay-bin.000005\nRelay_Log_Pos: 529\nRelay_Master_Log_File: mysql-bin.000003\nSlave_IO_Running: Yes\nSlave_SQL_Running: Yes\nReplicate_Do_DB:\nReplicate_Ignore_DB:\nReplicate_Do_Table:\nReplicate_Ignore_Table:\nReplicate_Wild_Do_Table:\nReplicate_Wild_Ignore_Table:\nLast_Errno: 0\nLast_Error:\nSkip_Counter: 0\nExec_Master_Log_Pos: 245\nRelay_Log_Space: 1256\nUntil_Condition: None\nUntil_Log_File:\nUntil_Log_Pos: 0\nMaster_SSL_Allowed: No\nMaster_SSL_CA_File:\nMaster_SSL_CA_Path:\nMaster_SSL_Cert:\nMaster_SSL_Cipher:\nMaster_SSL_Key:\nSeconds_Behind_Master: 0\nMaster_SSL_Verify_Server_Cert: No\nLast_IO_Errno: 0\nLast_IO_Error:\nLast_SQL_Errno: 0\nLast_SQL_Error:\nReplicate_Ignore_Server_Ids:\nMaster_Server_Id: 30\n1 row in set (0.00 sec)', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176544, 1587604117206880258, 2, '  读写分离数据库管理  使用提供的虚拟机与软件包，基于上一题构建的主从数据库，进一步完成Mycat读写分离数据库的配置安装。需要用的配置文件schema.xml文件如下所示（server.xml文件不再给出）：', 'null', '<!--?xml version=\"1.0\"?-->\n\n<mycat:schema xmlns:mycat=\"http://io.mycat/\">\n<schema name=\"USERDB\" checksqlschema=\"true\" sqlmaxlimit=\"100\" datanode=\"dn1\"></schema>\n<datanode name=\"dn1\" datahost=\"localhost1\" database=\"test\">\n<datahost name=\"localhost1\" maxcon=\"1000\" mincon=\"10\" balance=\"3\" dbtype=\"mysql\" dbdriver=\"native\" writetype=\"0\" switchtype=\"1\" slavethreshold=\"100\">\n<heartbeat>select user()</heartbeat>\n<writehost host=\"hostM1\" url=\"172.16.51.18:3306\" user=\"root\" password=\"123456\">\n<readhost host=\"hostS1\" url=\"172.16.51.30:3306\" user=\"root\" password=\"123456\">\n</readhost></writehost>\n</datahost>\n</datanode></mycat:schema>', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176545, 1587604117206880258, 2, '配置读写分离数据库完毕后，使用netstat -ntpl命令查询端口启动情况。最后将netstat -ntpl命令的返回结果以文本形式提交到答题框。', 'null', '', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176546, 1587604117206880258, 2, 'Keystone服务运维  使用提供的“all-in-one”虚拟机，使用openstack命令，创建一个名称为“alice”账户，密码为“mypassword123”，邮箱为“alice@example.com”。并且创建一个名为“acme”项目。创建一个角色“compute-user”。给用户“alice”分配“acme”项目下的“compute-user”角色。将以上操作命令及结果以文本形式填入答题框。', 'null', '\n[root@xiandian ~]# source /etc/keystone/admin-openrc.sh\"[root@xiandian ~]# openstack user create --password mypassword123 --email alice@example.com --domain domain alice\"+-----------+----------------------------------+\"| Field| Value |\"+-----------+----------------------------------+\"| domain_id | 3ac89594c8e944a9b5bb567fca4e75aa |\"| email| alice@example.com|\"| enabled   | True  |\"| id   | 17122f34cbf94aba835195bd94758753 |\"| name | alice |\"+-----------+----------------------------------+\"[root@xiandian ~]# openstack project create --domain domain acme\"+-------------+----------------------------------+\"| Field  | Value |\"+-------------+----------------------------------+\"| description | |\"| domain_id   | 3ac89594c8e944a9b5bb567fca4e75aa |\"| enabled| True  |\"| id| b1304aa3b53a4203821c1eef5fcc05fc |\"| is_domain   | False |\"| name   | acme  |\"| parent_id   | 3ac89594c8e944a9b5bb567fca4e75aa |\"+-------------+----------------------------------+\"[root@xiandian ~]# openstack role create compute-user\"+-----------+----------------------------------+\"| Field| Value |\"+-----------+----------------------------------+\"| domain_id | None  |\"| id   | 87b10d35ed044038b7bf0960ca2f37c0 |\"| name | compute-user|\"+-----------+----------------------------------+\"[root@xiandian ~]# openstack role add --user alice  --project acme  compute-user', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176547, 1587604117206880258, 2, ' Glance服务运维  <使用提供的“all-in-one”虚拟机，使用Glance命令，创建一个名称为“cirros”镜像，镜像文件使用提供的为“cirros-0.3.4-x86_64-disk.img”。通过glance 命令查看镜像“cirros”的详细信息。使用glance 命令更新镜像信息min-disk（min-disk默认单位为G）为1G。将以上操作命令及结果以文本形式填入答题框。', 'null', '[root@xiandian images]# glance image-create --name \"cirros\" --disk-format qcow2 --container-format bare --progress &lt; cirros-0.3.4-x86_64-disk.img\n[=============================&gt;] 100%\n+------------------+--------------------------------------+\n| Property    | Value|\n+------------------+--------------------------------------+\n| checksum    | 64d7c1cd2b6f60c92c14662941cb7913|\n| container_format | bare|\n| created_at  | 2019-09-28T04:57:59Z |\n| disk_format | qcow2|\n| id    | db715025-a795-4519-9947-c5acbe2d5788 |\n| min_disk    | 0   |\n| min_ram| 0   |\n| name  | cirros    |\n| owner | 0ab2dbde4f754b699e22461426cd0774|\n| protected   | False|\n| size  | 13167616  |\n| status| active    |\n| tags  | []  |\n| updated_at  | 2019-09-28T04:58:00Z |\n| virtual_size| None|\n| visibility  | private   |\n+------------------+--------------------------------------+\n# glance image-show db715025-a795-4519-9947-c5acbe2d5788\n+------------------+--------------------------------------+\n| Property    | Value|\n+------------------+--------------------------------------+\n| checksum    | 64d7c1cd2b6f60c92c14662941cb7913|\n| container_format | bare|\n| created_at  | 2019-09-28T04:57:59Z |\n| disk_format | qcow2|\n| id    | db715025-a795-4519-9947-c5acbe2d5788 |\n| min_disk    | 0   |\n| min_ram| 0   |\n| name  | cirros    |\n| owner | 0ab2dbde4f754b699e22461426cd0774|\n| protected   | False|\n| size  | 13167616  |\n| status| active    |\n| tags  | []  |\n| updated_at  | 2019-09-28T04:58:00Z |\n| virtual_size| None|\n| visibility  | private   |\n+------------------+--------------------------------------+\n# glance image-update --min-disk=1 db715025-a795-4519-9947-c5acbe2d5788\n+------------------+--------------------------------------+\n| Property    | Value|\n+------------------+--------------------------------------+\n| checksum    | 64d7c1cd2b6f60c92c14662941cb7913|\n| container_format | bare|\n| created_at  | 2019-09-28T04:57:59Z |\n| disk_format | qcow2|\n| id    | db715025-a795-4519-9947-c5acbe2d5788 |\n| min_disk    | 1   |\n| min_ram| 0   |\n| name  | cirros    |\n| owner | 0ab2dbde4f754b699e22461426cd0774|\n| protected   | False|\n| size  | 13167616  |\n| status| active    |\n| tags  | []  |\n| updated_at  | 2019-09-28T05:22:09Z |\n| virtual_size| None|\n| visibility  | private   |\n+------------------+--------------------------------------+', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176548, 1587604117206880258, 2, ' Nova服务运维(40分)  <使用提供的“all-in-one”虚拟机，使用Nova命令，创建一个名为test的安全组，描述为\'test the nova command about the rules\'。并且使用命令创建一个名为test，ID为6，内存为2048 MB，磁盘为20 GB，vcpu数量为2的云主机类型，查看test云主机类型的详细信息。将以上操作命令及结果以文本形式填入答题框。', 'null', '# nova secgroup-create test \'test the nova command about the rules\'\n+--------------------------------------+------+---------------------------------------+\n| Id  | Name | Description|\n+--------------------------------------+------+---------------------------------------+\n| d1ce4ef1-26c8-4b3d-958b-bc778bf283f3 | test | test the nova command about the rules |\n+--------------------------------------+------+---------------------------------------+\n# nova flavor-create test 6 2048 20 2\n+----+------+-----------+------+-----------+------+-------+-------------+-----------+\n| ID | Name | Memory_MB | Disk | Ephemeral | Swap | VCPUs | RXTX_Factor | Is_Public |\n+----+------+-----------+------+-----------+------+-------+-------------+-----------+\n| 6  | test | 2048 | 20   | 0    | | 2| 1.0    | True |\n+----+------+-----------+------+-----------+------+-------+-------------+-----------+\n# nova flavor-show test\n+----------------------------+-------+\n| Property   | Value |\n+----------------------------+-------+\n| OS-FLV-DISABLED:disabled   | False |\n| OS-FLV-EXT-DATA:ephemeral  | 0|\n| disk | 20    |\n| extra_specs| {}    |\n| id   | 6|\n| name | test  |\n| os-flavor-access:is_public | True  |\n| ram  | 2048  |\n| rxtx_factor| 1.0   |\n| swap |  |\n| vcpus| 2|\n+----------------------------+-------+', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176549, 1587604117206880258, 2, 'Docker安装  使用提供的虚拟机和软件包，自行配置YUM源，安装docker-ce服务。安装完毕后执行docker info命令的返回结果以文本形式提交到答题框。', 'null', '\nContainers: 33\nRunning: 16\nPaused: 0\nStopped: 17\nImages: 22\nServer Version: 18.09.6\nStorage Driver: devicemapper\nPool Name: docker-253:0-113162281-pool\nPool Blocksize: 65.54kB\nBase Device Size: 10.74GB\nBacking Filesystem: xfs\nUdev Sync Supported: true\nData file: /dev/loop0\nMetadata file: /dev/loop1\nData loop file: /var/lib/docker/devicemapper/devicemapper/data\nMetadata loop file: /var/lib/docker/devicemapper/devicemapper/metadata\nData Space Used: 3.573GB\nData Space Total: 107.4GB\nData Space Available: 18.72GB\nMetadata Space Used: 22.59MB\nMetadata Space Total: 2.147GB\nMetadata Space Available: 2.125GB\nThin Pool Minimum Free Space: 10.74GB\nDeferred Removal Enabled: true\nDeferred Deletion Enabled: true\nDeferred Deleted Device Count: 0\nLibrary Version: 1.02.158-RHEL7 (2019-05-13)\nLogging Driver: json-file\nCgroup Driver: cgroupfs\nPlugins:\nVolume: local\nNetwork: bridge host macvlan null overlay\nLog: awslogs fluentd gcplogs gelf journald json-file local logentries splunk syslog\nSwarm: inactive\nRuntimes: runc\nDefault Runtime: runc\nInit Binary: docker-init\ncontainerd version: b34a5c8af56e510852c35414db4c1f4fa6172339\nrunc version: 3e425f80a8c931f88e6d94a8c831b9d5aa481657\ninit version: fec3683\nSecurity Options:\nseccomp\nProfile: default\nKernel Version: 3.10.0-1062.7.1.el7.x86_64\nOperating System: CentOS Linux 7 (Core)\nOSType: linux\nArchitecture: x86_64\nCPUs: 2\nTotal Memory: 1.913GiB\nName: master\nID: U4ME:YWV6:WZEK:7R7W:5OLN:MO4A:NVNH:AEPR:L7GE:UD4S:UZOY:GZXQ\nDocker Root Dir: /var/lib/docker\nDebug Mode (client): false\nDebug Mode (server): false\nRegistry: https://index.docker.io/v1/\nLabels:\nExperimental: false\nInsecure Registries:\n192.168.70.10:5000\n127.0.0.0/8\nLive Restore Enabled: false\nProduct License: Community Engine\nWARNING: the devicemapper storage-driver is deprecated, and will be removed in a future release.\nWARNING: devicemapper: usage of loopback devices is strongly discouraged for production use.\nUse `--storage-opt dm.thinpooldev` to specify a custom block storage device.', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176550, 1587604117206880258, 2, '部署Swarm集群  使用提供的虚拟机，自行配置好网络，安装好docker-ce。部署Swarm集群，并安装Portainer图形化管理工具，部署完成后，使用浏览器登录ip:9000界面，进入Swarm控制台。将curl swarm ip:9000返回的结果以文本形式提交到答题框。', 'null', '[root@master ~]# curl 192.168.100.10:9000\n&lt;!DOCTYPE html&gt;&lt;html lang=\"en\" ng-app=\"portainer\"&gt;\n&lt;head&gt;\n&lt;meta charset=\"utf-8\"&gt;\n&lt;title&gt;Portainer&lt;/title&gt;\n&lt;meta name=\"description\" content=\"\"&gt;\n&lt;meta name=\"author\" content=\"Portainer.io\"&gt;\n&lt;div class=\"row\" style=\"text-align: center\"&gt;\nLoading Portainer...\n&lt;i class=\"fa fa-cog fa-spin\" style=\"margin-left: 5px\"&gt;&lt;/i&gt;\n&lt;/div&gt;\n&lt;!-- !panel --&gt;\n&lt;/div&gt;', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176551, 1587604117206880258, 2, 'Kubernetes平台搭建  使用提供的虚拟机和软件包，搭建Kubernetes平台，平台的两个节点分别为master和node节点，在将node节点加入到集群后，登录master节点，使用kubectl get nodes查询各节点状态。将查询节点状态的返回结果以文本形式提交到答题框。', 'null', '\n kubectl get nodes\nNAMESTATUS   ROLES    AGEVERSION\nmaster   Ready    master   117m    v1.14.1\nnodeReady    &lt;none&gt;   6m30s   v1.14.1', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1587604118314176552, 1587604117206880258, 2, '送分题', 'null', '送分了', 40, 100, 100, 0);
INSERT INTO `test_questions` VALUES (1588763601170075650, 1, 0, '测试题1', '{}', 'B', 20, 0, 0, 1);
INSERT INTO `test_questions` VALUES (1588765478532255746, 1, 0, '测试题1', '{}', 'B', 20, 0, 0, 1);
INSERT INTO `test_questions` VALUES (1588766834643025922, 1, 0, '测试题1', '{}', 'B', 20, 0, 0, 1);
INSERT INTO `test_questions` VALUES (1588766947494969346, 1, 0, '测试题1', '{}', 'B', 20, 0, 0, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `identity` int(4) NOT NULL DEFAULT 2 COMMENT '0 admin 1 教师 2 学生',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `user_state` int(4) NOT NULL DEFAULT 0 COMMENT '状态  0 启用 1 禁用',
  `head_portrait` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE COMMENT '手机应该唯一',
  UNIQUE INDEX `username`(`username`) USING BTREE COMMENT '用户名应该唯一'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0, '15877497660', 'admin', 0, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (1, '15891461996', 'tom', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (2, '15791405855', 'zhansan', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (5, '15693013677', 'weiguo', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (6, '15389775492', 'lisi', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (7, '15512724119', 'wanwu', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (8, '17786029852', 'huliu', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (9, '15692884011', 'luoqi', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (10, '15542431334', 'tanba', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (20, '17829292729', 'jainliu', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (28, '15287471779', 'aszd', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (29, '15216532195', 'lhw', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (31, '17679019607', 'xxw', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (35, '17890531448', 'sqc', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (46, '15542761229', 'yws', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (63, '17133219706', 'dasd', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (64, '17882453304', 'vsdf', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (71, '17754270601', 'df', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (73, '15232330115', 'ddferf', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (83, '17875231466', 'ferfe', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (94, '15177429069', 'fdferqw', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (98, '17388879517', 'dfgsdfc', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (192, '17231080745', 'vf', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (221, '15132983752', 'dt', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (397, '17714966358', 'hsv', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (601, '15266770675', 'asdcww', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (682, '15343531662', 'bh', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (785, '15188283155', 'qa', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (791, '13678642947', 'qs', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (829, '15343240696', 'qf', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (870, '17619787047', 'qg', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (4103, '14765155629', 'ql', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (5220, '17267323485', 'q12', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (6126, '17188173777', 'q123', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (6727, '15309891901', 'a45', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (7494, '17626595324', 'a52', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (7753, '17111685791', 'a96', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (8888, '17174170230', 'a74', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (9841, '17605521894', 'alo', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (14037, '17554087266', 'a851', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (30221, '17107357279', 'd45', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (39816, '17759334824', 'w52', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (41823, '17775626853', 'g52', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (45671, '13602657812', 'g852', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (54700, '15341628643', 'g85102', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (75887, '17627160831', 'g9962', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (89884, '15193279008', 'g45623', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (451434, '15616434686', 'e525202', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (533000, '13547410764', 'e88521', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (622286, '18513273978', 'gh45210', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (690872, '13162091845', 'fd455', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (770783, '15376478209', 'sd8522', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (829846, '15305415587', 'ghtr441', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (992954, '17135859176', '456dsf1231f84485485', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (1303047, '17770576302', 'ds546f5dsf', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (3414040, '17581485040', '4f1d15s6g', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (3580992, '15185298380', '452f211f', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (3634946, '15279733126', '4f1s2fer21gs', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (3672363, '13340255962', '4g1fds2sd', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (4192256, '15012107421', '784erf15f2sd03', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (4637114, '17195614781', 'fe452d61s03', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (4910464, '18334261050', 'g85e2sd', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (8752246, '17873651673', '7hg4f1d', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (9106880, '15085992194', '8erf5ds2f1d', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (9265222, '17626809520', 'f8d5s2', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (9741989, '14525366922', 'f5d2s5', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (9750964, '17387723504', '852dsfd', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (22662849, '17180612857', '74f1dssasd', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (31109690, '15677160779', 'f4eds411f0', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (35971109, '15022113339', '89e56d', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (42960132, '15827561315', '7q4a1', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (47470524, '17559927893', '74ew1s85', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (50026477, '15714030047', '74ewd1ss', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (74074880, '15985362690', '74ewd1s', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (82578702, '14713670603', '7ef45ds12', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (86147008, '18517485531', '54f2ds', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (89787616, '18467467661', '7tgr4fd1', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (93163640, '15619026290', '7f41ds0x', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (240051753, '17539483478', '74f10c', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (388499899, '14780823416', 'x5c2v0', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (479095665, '18882410065', 's4d10', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (510678694, '14711087460', 's5d10', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (735296534, '17632706817', 'asdfg01', 2, '5690dddfa28ae085d23518a035707282', 0, 'aa.png');
INSERT INTO `user` VALUES (800258967, '13291822594', 'ds5210', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (1898951627, '15030636461', 'sfds45100', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (3235364446, '15696162785', 'fds44f5', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (5411665003, '15298839900', 'sd2s1', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (7508205189, '15845723102', 'gfd84511', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (7791743228, '17156181990', 'fd7441', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (8033366478, '17201114204', 'gdf85', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (8252667120, '15978475427', 'grg78r41fg', 2, '670b14728ad9902aecba32e22fa4f6bd', 0, 'aa.png');
INSERT INTO `user` VALUES (1585544271687155714, '15874785210', 'root', 1, '82273a6ba2126d3af24ce2d0cb0af515', 0, 'aa.png');
INSERT INTO `user` VALUES (1585813386104492034, '15874785211', 'root1', 1, '82273a6ba2126d3af24ce2d0cb0af515', 0, 'aa.png');

-- ----------------------------
-- Table structure for user_examination_paper
-- ----------------------------
DROP TABLE IF EXISTS `user_examination_paper`;
CREATE TABLE `user_examination_paper`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `examintion_paper_id` bigint(20) NOT NULL COMMENT '试卷id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `examination_time` time(0) NOT NULL COMMENT '考试用时时长',
  `start_time` datetime(0) NOT NULL COMMENT '考试开始时间',
  `end_time` datetime(0) NOT NULL COMMENT '考试结束时间',
  `examination_start` int(4) NOT NULL COMMENT '是否开始考试 0 开始 1 未开始 2 结束',
  `create_id` bigint(20) NOT NULL COMMENT '发布人的id',
  `update_id` bigint(20) NOT NULL COMMENT '修改人的id',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `create_time` datetime(0) NOT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `examintion_paper_id`(`examintion_paper_id`, `user_id`) USING BTREE COMMENT '一个人只需要添加一套试卷'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_examination_paper
-- ----------------------------
INSERT INTO `user_examination_paper` VALUES (1588377490409127938, 1, 2, '00:00:00', '2022-11-04 18:00:00', '2022-11-04 22:00:00', 2, 1585544271687155714, 1585544271687155714, '2022-11-04 11:47:59', '2022-11-04 11:47:59');
INSERT INTO `user_examination_paper` VALUES (1588377490434293761, 1, 3, '00:00:00', '2022-11-04 18:00:00', '2022-11-04 22:00:00', 1, 1585544271687155714, 1585544271687155714, '2022-11-04 11:47:59', '2022-11-04 11:47:59');
INSERT INTO `user_examination_paper` VALUES (1588377490434293762, 1, 5, '00:00:00', '2022-11-04 18:00:00', '2022-11-04 22:00:00', 1, 1585544271687155714, 1585544271687155714, '2022-11-04 11:47:59', '2022-11-04 11:47:59');
INSERT INTO `user_examination_paper` VALUES (1588377490434293763, 1, 6, '00:00:00', '2022-11-04 18:00:00', '2022-11-04 22:00:00', 1, 1585544271687155714, 1585544271687155714, '2022-11-04 11:47:59', '2022-11-04 11:47:59');
INSERT INTO `user_examination_paper` VALUES (1588377490434293764, 1, 7, '00:00:00', '2022-11-04 18:00:00', '2022-11-04 22:00:00', 1, 1585544271687155714, 1585544271687155714, '2022-11-04 11:47:59', '2022-11-04 11:47:59');
INSERT INTO `user_examination_paper` VALUES (1588377490434293765, 1, 8, '00:00:00', '2022-11-04 18:00:00', '2022-11-04 22:00:00', 1, 1585544271687155714, 1585544271687155714, '2022-11-04 11:47:59', '2022-11-04 11:47:59');
INSERT INTO `user_examination_paper` VALUES (1588377490434293766, 1, 10, '00:00:00', '2022-11-04 18:00:00', '2022-11-04 22:00:00', 1, 1585544271687155714, 1585544271687155714, '2022-11-04 11:47:59', '2022-11-04 11:47:59');
INSERT INTO `user_examination_paper` VALUES (1588377709758644225, 1587604117206880258, 1, '00:00:00', '2022-11-04 20:00:00', '2022-11-05 00:00:00', 1, 0, 0, '2022-11-04 11:48:51', '2022-11-04 11:48:51');
INSERT INTO `user_examination_paper` VALUES (1588420747000283138, 1587604117206880258, 2, '00:00:00', '2022-11-04 20:00:00', '2022-11-05 00:00:00', 0, 0, 0, '2022-11-04 14:39:52', '2022-11-04 14:39:52');
INSERT INTO `user_examination_paper` VALUES (1588430748343431169, 1587604117206880258, 785, '00:00:00', '2022-11-04 20:00:00', '2022-11-05 00:00:00', 1, 0, 0, '2022-11-04 15:19:37', '2022-11-04 15:19:37');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` int(4) NULL DEFAULT NULL COMMENT '0 女  1 男',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `id_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `school` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属学校',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_number`(`id_number`) USING BTREE COMMENT '身份证应该唯一',
  UNIQUE INDEX `email`(`email`) USING BTREE COMMENT '邮箱应该唯一'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_power
-- ----------------------------
DROP TABLE IF EXISTS `user_power`;
CREATE TABLE `user_power`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `add_examination` int(4) NOT NULL DEFAULT 1 COMMENT '添加试卷的权限  0 有权限 1 没有权限',
  `add_affiche` int(4) NOT NULL DEFAULT 1 COMMENT '发布公告的权限  0 有权限 1 没有权限 ',
  `del_affiche` int(4) NOT NULL DEFAULT 1 COMMENT '删除公告的权限 0 有权限 1 没有权限',
  `publish_examination` int(4) NOT NULL DEFAULT 1 COMMENT '修改试卷的权限 0 有权限 1 没有权限',
  `grade_papers` int(4) NOT NULL DEFAULT 1 COMMENT '判卷的权限（可以二次判卷）0 有权限 1 没有权限',
  `admin` int(4) NOT NULL DEFAULT 1 COMMENT '管理员权限 0 有权限 1 没有权限',
  `teachers` int(4) NOT NULL DEFAULT 1 COMMENT '教师权限 0 有权限 1 没有权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_power
-- ----------------------------
INSERT INTO `user_power` VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `user_power` VALUES (1, 1, 1, 0, 1, 1, 1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
