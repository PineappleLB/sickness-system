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

 Date: 26/06/2018 21:02:04
*/


-- ----------------------------
-- Table structure for t_department_info
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_department_info]') AND type IN ('U'))
	DROP TABLE [dbo].[t_department_info]
GO

CREATE TABLE [dbo].[t_department_info] (
  [department_id] int  IDENTITY(1,1) NOT NULL,
  [department_name] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [department_type] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [department_address] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [phone] varchar(11) COLLATE Chinese_PRC_CI_AS  NULL,
  [email] varchar(30) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[t_department_info] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of t_department_info
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_department_info] ON
GO

INSERT INTO [dbo].[t_department_info] ([department_id], [department_name], [department_type], [department_address], [phone], [email]) VALUES (N'1', N'yyy部', N'私立', N'yyy路', N'16877777777', N'177777@gmail.com')
GO

SET IDENTITY_INSERT [dbo].[t_department_info] OFF
GO


-- ----------------------------
-- Primary Key structure for table t_department_info
-- ----------------------------
ALTER TABLE [dbo].[t_department_info] ADD CONSTRAINT [PK__t_depart__C22324225322986D] PRIMARY KEY CLUSTERED ([department_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

