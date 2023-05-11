CREATE TABLE `auth_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键;主键',
  `dept_code` varchar(20) NOT NULL COMMENT '部门编码',
  `job_number` varchar(255) NOT NULL COMMENT '工号',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `summary` varchar(255) DEFAULT NULL COMMENT '描述',
  `account_state` smallint NOT NULL COMMENT '账户状态（0关闭，1开启）',
  `created_by` bigint NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_jobNumber` (`job_number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

CREATE TABLE `dept` (
  `dept` varchar(10) DEFAULT NULL,
  `dept_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;