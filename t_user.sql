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

 Date: 26/06/2018 21:02:20
*/


-- ----------------------------
-- Table structure for t_user
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_user]') AND type IN ('U'))
	DROP TABLE [dbo].[t_user]
GO

CREATE TABLE [dbo].[t_user] (
  [username] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [id] int  IDENTITY(1,1) NOT NULL,
  [password] varchar(36) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [sex] varchar(5) COLLATE Chinese_PRC_CI_AS  NULL,
  [age] int DEFAULT ((0)) NOT NULL,
  [email] varchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [phone] varchar(11) COLLATE Chinese_PRC_CI_AS  NULL,
  [home_address] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [work_address] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[t_user] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户名',
'SCHEMA', N'dbo',
'TABLE', N't_user',
'COLUMN', N'username'
GO

EXEC sp_addextendedproperty
'MS_Description', N'userid',
'SCHEMA', N'dbo',
'TABLE', N't_user',
'COLUMN', N'id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'密码',
'SCHEMA', N'dbo',
'TABLE', N't_user',
'COLUMN', N'password'
GO

EXEC sp_addextendedproperty
'MS_Description', N'年龄',
'SCHEMA', N'dbo',
'TABLE', N't_user',
'COLUMN', N'sex'
GO

EXEC sp_addextendedproperty
'MS_Description', N'邮箱',
'SCHEMA', N'dbo',
'TABLE', N't_user',
'COLUMN', N'email'
GO

EXEC sp_addextendedproperty
'MS_Description', N'手机号',
'SCHEMA', N'dbo',
'TABLE', N't_user',
'COLUMN', N'phone'
GO

EXEC sp_addextendedproperty
'MS_Description', N'家庭住址',
'SCHEMA', N'dbo',
'TABLE', N't_user',
'COLUMN', N'home_address'
GO

EXEC sp_addextendedproperty
'MS_Description', N'工作地址',
'SCHEMA', N'dbo',
'TABLE', N't_user',
'COLUMN', N'work_address'
GO


-- ----------------------------
-- Records of t_user
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_user] ON
GO

INSERT INTO [dbo].[t_user] ([username], [id], [password], [sex], [age], [email], [phone], [home_address], [work_address]) VALUES (N'pinea', N'2', N'123456', N'男', N'18', NULL, NULL, NULL, NULL)
GO

INSERT INTO [dbo].[t_user] ([username], [id], [password], [sex], [age], [email], [phone], [home_address], [work_address]) VALUES (N'pineapple', N'3', N'111111', N'女', N'19', NULL, NULL, NULL, NULL)
GO

INSERT INTO [dbo].[t_user] ([username], [id], [password], [sex], [age], [email], [phone], [home_address], [work_address]) VALUES (N'pineapple', N'4', N'18', N'男', N'18', N'13523333655@mail.com', N'1388888888', N'xxxlu', N'xxxlu')
GO

SET IDENTITY_INSERT [dbo].[t_user] OFF
GO


-- ----------------------------
-- Primary Key structure for table t_user
-- ----------------------------
ALTER TABLE [dbo].[t_user] ADD CONSTRAINT [PK__t_user__3213E83FB9AC052D] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

