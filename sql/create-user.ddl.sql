CREATE TABLE `USER`(
	ID BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '数据库自增列',
	USER_ID VARCHAR(32) NOT NULL COMMENT '逻辑主键',
	NAME VARCHAR(16) NOT NULL COMMENT '姓名',
	USERNAME VARCHAR(32) NOT NULL COMMENT '用户名',
	PASSWORD VARCHAR(32) NOT NULL COMMENT '密码',
	PHONE VARCHAR(16) NOT NULL COMMENT '手机号',
	NICKNAME VARCHAR(64) DEFAULT NULL COMMENT '昵称',
	REGISTER_TIME DATETIME DEFAULT NULL COMMENT '注册时间',
	HEAD_IMG VARCHAR(256) DEFAULT NULL COMMENT '头像',
	PRIMARY KEY (ID),
	UNIQUE KEY ‘PASSID (PASSID)
) ENGINE = INNODB AUTO_INCREMENT=1; 


CREATE TABLE `USER_GROUP`(
	ID BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '数据库自增列',
	USER_GROUP_ID VARCHAR(32) NOT NULL COMMENT '用户分组ID',
	USER_ID VARCHAR(32) NOT NULL COMMENT '用户ID,PASSID',
	GROUP_NAME VARCHAR(32) NOT NULL COMMENT '分组名称',
	FRIEND_COUNT INT(11) NOT NULL COMMENT '好友数量',
	PRIMARY KEY (ID),
	UNIQUE KEY ‘ug_id (USER_GROUP_ID)
) ENGINE = INNODB AUTO_INCREMENT=1; 

CREATE TABLE `USER_GROUP_FRIEND`(
	ID BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '数据库自增列',
	USER_GROUP_FRIEND_ID VARCHAR(32) NOT NULL COMMENT '好友所属分组ID',
	USER_GROUP_ID VARCHAR(32) NOT NULL COMMENT '用户分组ID',
	FRIEND_ID VARCHAR(32) NOT NULL COMMENT '好友ID',
	USER_ID VARCHAR(32) NOT NULL COMMENT '用户ID',
	PRIMARY KEY (ID),
	UNIQUE KEY ‘ugf_id (USER_GROUP_FRIEND_ID)
) ENGINE = INNODB AUTO_INCREMENT=1; 