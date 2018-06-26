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

Date: 2018-06-26 08:06:15
*/


-- ----------------------------
-- Table structure for [dbo].[t_admin]
-- ----------------------------
DROP TABLE [dbo].[t_admin]
GO
CREATE TABLE [dbo].[t_admin] (
[id] int NOT NULL ,
[name] varchar(20) NOT NULL ,
[password] varchar(36) NOT NULL ,
[power] int NULL DEFAULT ((0)) 
)


GO

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO [dbo].[t_admin] ([id], [name], [password], [power]) VALUES (N'1', N'admin', N'123456', N'1');
GO
INSERT INTO [dbo].[t_admin] ([id], [name], [password], [power]) VALUES (N'2', N'pineapple', N'123456', N'1');
GO

-- ----------------------------
-- Indexes structure for table t_admin
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[t_admin]
-- ----------------------------
ALTER TABLE [dbo].[t_admin] ADD PRIMARY KEY ([id])
GO
