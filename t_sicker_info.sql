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

Date: 2018-06-26 08:06:26
*/


-- ----------------------------
-- Table structure for [dbo].[t_sicker_info]
-- ----------------------------
DROP TABLE [dbo].[t_sicker_info]
GO
CREATE TABLE [dbo].[t_sicker_info] (
[id] int NOT NULL ,
[name] varchar(10) NOT NULL ,
[age] int NULL ,
[home_address] varchar(50) NULL ,
[sick] varchar(30) NULL ,
[phone] varchar(11) NULL ,
[work_address] varchar(50) NULL ,
[scope] varchar(100) NULL 
)


GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_sicker_info', 
'COLUMN', N'id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'病人编号'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'病人编号'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_sicker_info', 
'COLUMN', N'name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'病人姓名'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'病人姓名'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_sicker_info', 
'COLUMN', N'age')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'病人年龄'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'age'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'病人年龄'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'age'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_sicker_info', 
'COLUMN', N'home_address')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'家庭地址'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'home_address'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'家庭地址'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'home_address'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_sicker_info', 
'COLUMN', N'sick')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'疾病类型'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'sick'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'疾病类型'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'sick'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_sicker_info', 
'COLUMN', N'phone')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'联系电话'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'phone'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'联系电话'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'phone'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_sicker_info', 
'COLUMN', N'work_address')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'工作地址'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'work_address'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'工作地址'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'work_address'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_sicker_info', 
'COLUMN', N'scope')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'活动范围'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'scope'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'活动范围'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_sicker_info'
, @level2type = 'COLUMN', @level2name = N'scope'
GO

-- ----------------------------
-- Records of t_sicker_info
-- ----------------------------
INSERT INTO [dbo].[t_sicker_info] ([id], [name], [age], [home_address], [sick], [phone], [work_address], [scope]) VALUES (N'1', N'pineapple', N'18', N'xx路18号6栋1单元1号', N'流行性感冒', N'13512360120', N'软件园', N'城关区');
GO

-- ----------------------------
-- Indexes structure for table t_sicker_info
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[t_sicker_info]
-- ----------------------------
ALTER TABLE [dbo].[t_sicker_info] ADD PRIMARY KEY ([id])
GO
