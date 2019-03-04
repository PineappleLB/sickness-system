CREATE TABLE `t_admin`(
  `id` INT(5) NOT NULL AUTO_INCREMENT COMMENT '管理员表主键id',
  `name` VARCHAR(20) NOT NULL COMMENT '管理员登录账号',
  `password` VARCHAR(50) NOT NULL COMMENT '管理员密码',
  `solt` VARCHAR(50) NOT NULL COMMENT '密码加密随机盐',
  `enable` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '是否启用（1启用，0禁用）',
  `level` INT(1) DEFAULT 1 COMMENT '管理员级别（1普通管理员，2超级管理员）',
  PRIMARY KEY (`id`)
) COMMENT '管理员表' ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `t_department_info`(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '部门表id',
  `department_name` VARCHAR(50) NOT NULL COMMENT '部门名称',
  `department_type` VARCHAR(50) COMMENT '部门类型',
  `department_address` VARCHAR(200) COMMENT '部门地址',
  `contact` VARCHAR(11) COMMENT '联系方式',
  `email` VARCHAR(50) COMMENT '邮箱地址',
  PRIMARY KEY (`id`)
) COMMENT '部门表' ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `t_sick` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '疾病id',
  `sick_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '疾病名称',
  `sick_type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '疾病类型（1普通疾病，2传染疾病）',
  `description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '疾病描述',
  PRIMARY KEY (`id`)
) COMMENT '疾病表' ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `account` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户账号',
  `user_real_name` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户真实姓名',
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户密码',
  `solt` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码随机盐',
  `gender` tinyint(1) NOT NULL DEFAULT '1' COMMENT '用户性别（1男，2女）',
  `birthday` bigint(13) DEFAULT NULL COMMENT '生日',
  `contact` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `home_address` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '住家庭址',
  `work_address` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工作地址',
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电子邮箱',
  `area_id` int(11) DEFAULT NULL COMMENT '地区id',
  PRIMARY KEY (`id`)
) COMMENT '用户表' ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `t_doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '医生id',
  `doctor_name` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '医生姓名',
  `account` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '医生账号',
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `solt` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码随机盐',
  `contact` varchar(11) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系方式',
  `auth` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否认证',
  `gender` tinyint(4) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL COMMENT '所属部门id',
  `work_address` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工作地点',
  `title` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '职称',
  PRIMARY KEY (`id`)
) COMMENT '医生信息表' ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


