# 商品表
create table goods(
id int primary key auto_increment,
title varchar(100) not null ,
info text,
price decimal(10,2),
save int not null,
begin_time timestamp not null ,
end_time timestamp not null
);

#订单表
create table orders(
    id int primary key auto_increment,
    oid varchar(30) not null unique ,
    gid int not null,
    uid int not null ,
    gnumber tinyint not null default 1,
    all_price decimal(10,2) not null,
    create_time timestamp default now(),
    status tinyint default 0
);

#模拟数据
insert into goods values(
                         null,"IQOO7 5G版 12GB+256GB 潜蓝","最便宜骁龙888，全感操控震撼全场",4198.00,1000,'2021-1-20 20:00:00',
                         '2021-1-21 0:00:00'
                        );

# 用户表数据
insert into user values (null,'张三','123456');

# 用户登录日志
create table user_log(
    id int primary key auto_increment,
    userid mediumint not null default 0,
    username varchar(20) not null ,
    ip int(10) not null ,
    time datetime default null
);

# 更改用户表
alter table user
    add code varchar(10) not null comment '随机验证码';

# 管理员表
create table admin(
    id int primary key auto_increment,
    username varchar(20) not null,
    password varchar(32) not null,
    lastloginip int not null default 0,
    lastlogintime timestamp default now(),
    status tinyint(1) not null default 1 comment '是否有效（1 有效 0 无效'
);

#修改登录日志表
alter table user_log
    change time lastlogintime timestamp default now(),
    change column ip lastloginip int(10) not null ;



-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(24) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
   code varchar(5) not null default ' ',
  `role` varchar(255) NOT NULL,
  `state` tinyint(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456','123@qq.com','', '超级管理员', '1');
INSERT INTO `user` VALUES ('2', 'naughty', '888888','456@qq.com','', '普通管理员', '0');
INSERT INTO `user` VALUES ('3', 'flysky01', '987654','qwe@qq.com', '','普通用户', '1');
INSERT INTO `user` VALUES ('4', 'anglybirds', '321654','aaaa@163.com','', '普通用户', '0');


# mainmenu表
DROP TABLE IF EXISTS `mainmenu`;
CREATE TABLE `mainmenu` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mainmenu
-- ----------------------------
INSERT INTO `mainmenu` VALUES ('100', '权限管理', '/admin');
INSERT INTO `mainmenu` VALUES ('200', '购买页面', '/use');

-- ----------------------------
-- Table structure for submenu
-- ----------------------------
DROP TABLE IF EXISTS `submenu`;
CREATE TABLE `submenu` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `mid` int(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  CONSTRAINT `submenu_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `mainmenu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of submenu
-- ----------------------------
INSERT INTO `submenu` VALUES ('101', '用户列表', '/user', '100');
INSERT INTO `submenu` VALUES ('102', '修改权限', '/rights', '100');
INSERT INTO `submenu` VALUES ('103', '订单模块', '/orders', '100');
INSERT INTO `submenu` VALUES ('104', '商品模块', '/goods', '100');

select mm.*,sm.id as sid,sm.title as stitle,sm.path as spath from mainmenu mm,submenu sm where mm.id = sm.mid;

update submenu set mid = 100 where id =103;