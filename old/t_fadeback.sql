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

 Date: 27/06/2018 12:57:14
*/


-- ----------------------------
-- Table structure for t_fadeback
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_fadeback]') AND type IN ('U'))
	DROP TABLE [dbo].[t_fadeback]
GO

CREATE TABLE [dbo].[t_fadeback] (
  [name] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [fadeback] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [id] int  IDENTITY(1,1) NOT NULL
)
GO

ALTER TABLE [dbo].[t_fadeback] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of t_fadeback
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_fadeback] ON
GO

INSERT INTO [dbo].[t_fadeback] ([name], [fadeback], [id]) VALUES (N'admin', N'啊啊啊啊啊aaaa', N'1')
GO

SET IDENTITY_INSERT [dbo].[t_fadeback] OFF
GO

