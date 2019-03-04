insert into t_sicker_info (name,age,home_address,sick,phone,work_address,scope)
values('pineapple','18','xxx路','流行性感冒','13523333655','xxxxx路','城关区')

delete t_sicker_info where id in(5,10,20)

select * from t_sicker_info where 1=1 and sick='gm' and scope='cgq'

select count(1) as count,sick,scope from t_sicker_info where 1=1 group by sick,scope

update t_department_info set department_name='yyy部',department_type='私立',department_address='yyy路',phone='16877777777',email='177777@gmail.com' where department_id=1;

select * from t_admin where name='admin';

select * from t_department_info;

select top 1 * from t_user where username='pinea' ;

insert into t_user (username,password,sex,age,email,phone,home_address,work_address)
values('pineapple','18','男','18','13523333655@mail.com','1388888888','xxxlu','xxxlu')

/*
Navicat SQL Server Data Transfer

Source Server         : local
Source Server Version : 120000
Source Host           : localhost:1433
Source Database       : sicknessSystem
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 120000
File Encoding         : 65001

Date: 2018-06-26 08:06:21
*/


-- ----------------------------
-- Table structure for [dbo].[t_department_info]
-- ----------------------------
DROP TABLE [dbo].[t_department_info]
GO
CREATE TABLE [dbo].[t_department_info] (
[department_id] int NOT NULL IDENTITY(1,1),
[department_name] varchar(20) NOT NULL ,
[department_type] varchar(20) NOT NULL ,
[department_address] varchar(50) NULL ,
[phone] varchar(11) NULL ,
[email] varchar(30) NULL 
)


GO

-- ----------------------------
-- Records of t_department_info
-- ----------------------------

-- ----------------------------
-- Indexes structure for table t_department_info
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[t_department_info]
-- ----------------------------
ALTER TABLE [dbo].[t_department_info] ADD PRIMARY KEY ([department_id])
GO
