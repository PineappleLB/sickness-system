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
[department_id] int NOT NULL ,
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
