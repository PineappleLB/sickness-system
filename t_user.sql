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

Date: 2018-06-26 08:06:32
*/


-- ----------------------------
-- Table structure for [dbo].[t_user]
-- ----------------------------
DROP TABLE [dbo].[t_user]
GO
CREATE TABLE [dbo].[t_user] (
[username] varchar(20) NOT NULL ,
[id] int NOT NULL IDENTITY(1,1) ,
[password] varchar(36) NOT NULL ,
[sex] varchar(5) NULL ,
[age] int NOT NULL DEFAULT ((0)) ,
[email] varchar(20) NULL ,
[phone] varchar(11) NULL ,
[home_address] varchar(50) NULL ,
[work_address] varchar(50) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[t_user]', RESEED, 2)
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_user', 
'COLUMN', N'username')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'用户名'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'username'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'用户名'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'username'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_user', 
'COLUMN', N'id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'userid'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'userid'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_user', 
'COLUMN', N'password')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'密码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'password'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'密码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'password'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_user', 
'COLUMN', N'sex')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'年龄'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'sex'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'年龄'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'sex'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_user', 
'COLUMN', N'email')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'邮箱'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'email'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'邮箱'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'email'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_user', 
'COLUMN', N'phone')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'手机号'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'phone'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'手机号'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'phone'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_user', 
'COLUMN', N'home_address')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'家庭住址'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'home_address'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'家庭住址'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'home_address'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N't_user', 
'COLUMN', N'work_address')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'工作地址'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'work_address'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'工作地址'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N't_user'
, @level2type = 'COLUMN', @level2name = N'work_address'
GO

-- ----------------------------
-- Records of t_user
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_user] ON
GO
INSERT INTO [dbo].[t_user] ([username], [id], [password], [sex], [age], [email], [phone], [home_address], [work_address]) VALUES (N'pinea', N'2', N'123456', N'男', N'18', null, null, null, null);
GO
SET IDENTITY_INSERT [dbo].[t_user] OFF
GO

-- ----------------------------
-- Indexes structure for table t_user
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[t_user]
-- ----------------------------
ALTER TABLE [dbo].[t_user] ADD PRIMARY KEY ([id])
GO
