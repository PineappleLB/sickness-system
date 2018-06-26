/*
 Navicat SQL Server Data Transfer

 Source Server         : localhost
 Source Server Type    : SQL Server
 Source Server Version : 12002000
 Source Host           : localhost:1433
 Source Catalog        : sicknessSystem
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 12002000
 File Encoding         : 65001

 Date: 26/06/2018 21:02:13
*/


-- ----------------------------
-- Table structure for t_sicker_info
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_sicker_info]') AND type IN ('U'))
	DROP TABLE [dbo].[t_sicker_info]
GO

CREATE TABLE [dbo].[t_sicker_info] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [name] varchar(10) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [age] int  NULL,
  [home_address] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [sick] varchar(30) COLLATE Chinese_PRC_CI_AS  NULL,
  [phone] varchar(11) COLLATE Chinese_PRC_CI_AS  NULL,
  [work_address] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [scope] varchar(100) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[t_sicker_info] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'病人编号',
'SCHEMA', N'dbo',
'TABLE', N't_sicker_info',
'COLUMN', N'id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'病人姓名',
'SCHEMA', N'dbo',
'TABLE', N't_sicker_info',
'COLUMN', N'name'
GO

EXEC sp_addextendedproperty
'MS_Description', N'病人年龄',
'SCHEMA', N'dbo',
'TABLE', N't_sicker_info',
'COLUMN', N'age'
GO

EXEC sp_addextendedproperty
'MS_Description', N'家庭地址',
'SCHEMA', N'dbo',
'TABLE', N't_sicker_info',
'COLUMN', N'home_address'
GO

EXEC sp_addextendedproperty
'MS_Description', N'疾病类型',
'SCHEMA', N'dbo',
'TABLE', N't_sicker_info',
'COLUMN', N'sick'
GO

EXEC sp_addextendedproperty
'MS_Description', N'联系电话',
'SCHEMA', N'dbo',
'TABLE', N't_sicker_info',
'COLUMN', N'phone'
GO

EXEC sp_addextendedproperty
'MS_Description', N'工作地址',
'SCHEMA', N'dbo',
'TABLE', N't_sicker_info',
'COLUMN', N'work_address'
GO

EXEC sp_addextendedproperty
'MS_Description', N'活动范围',
'SCHEMA', N'dbo',
'TABLE', N't_sicker_info',
'COLUMN', N'scope'
GO


-- ----------------------------
-- Records of t_sicker_info
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_sicker_info] ON
GO

INSERT INTO [dbo].[t_sicker_info] ([id], [name], [age], [home_address], [sick], [phone], [work_address], [scope]) VALUES (N'2', N'pineapple', N'18', N'xxx路', N'gm', N'13523333655', N'xxxxx路', N'cgq')
GO

INSERT INTO [dbo].[t_sicker_info] ([id], [name], [age], [home_address], [sick], [phone], [work_address], [scope]) VALUES (N'3', N'Luo Bo', N'19', N'xxxxxx', N'mz', N'15982466924', N'xxxxxxx', N'cgq')
GO

SET IDENTITY_INSERT [dbo].[t_sicker_info] OFF
GO

