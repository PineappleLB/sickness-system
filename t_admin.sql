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

 Date: 26/06/2018 21:01:55
*/


-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_admin]') AND type IN ('U'))
	DROP TABLE [dbo].[t_admin]
GO

CREATE TABLE [dbo].[t_admin] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [name] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [password] varchar(36) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [power] int DEFAULT ((0)) NULL
)
GO

ALTER TABLE [dbo].[t_admin] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of t_admin
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_admin] ON
GO

INSERT INTO [dbo].[t_admin] ([id], [name], [password], [power]) VALUES (N'1', N'admin', N'123456', N'1')
GO

INSERT INTO [dbo].[t_admin] ([id], [name], [password], [power]) VALUES (N'2', N'admin2', N'123456', N'1')
GO

SET IDENTITY_INSERT [dbo].[t_admin] OFF
GO


-- ----------------------------
-- Primary Key structure for table t_admin
-- ----------------------------
ALTER TABLE [dbo].[t_admin] ADD CONSTRAINT [PK__t_admin__3213E83F763CC5E3] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

