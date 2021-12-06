CREATE TABLE `manger_user` (
                               `user_id` varchar(255) NOT NULL COMMENT '用户ID',
                               `user_name` varchar(255) DEFAULT NULL COMMENT '用户昵称',
                               `user_phone` varchar(255) DEFAULT NULL COMMENT '电话',
                               `user_password` varchar(255) DEFAULT NULL COMMENT '密码（加密）',
                               `salt` varchar(10) DEFAULT NULL,
                               `user_start` varchar(255) DEFAULT NULL COMMENT '状态',
                               `user_head` varchar(255) DEFAULT NULL COMMENT '头像',
                               `create_time` datetime DEFAULT NULL COMMENT '注册时间',
                               `update_time` datetime DEFAULT NULL COMMENT '上次登录时间',
                               `temp` varchar(255) DEFAULT NULL COMMENT '预留字段',
                               PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;