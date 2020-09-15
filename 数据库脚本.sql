use mysql;
#创建数据库
create database if not exists seckill;
#使用数据库
use seckill;
#取消外键约束
set foreign_key_checks = 0;
#创建用户表
drop table if exists user;
create table if not exists user (
	id int primary key auto_increment comment '用户id',
	username varchar(20) unique not null comment '用户名',
	password varchar(128) not null  comment '用户加密后密码'
) engine = innodb charset = utf8;
#创建课程信息表
drop table if exists course;
create table if not exists course (
	course_no int primary key auto_increment comment '课程号',
	course_type int not null default 0 comment '课程分类',
	course_name varchar(50) not null comment '课程名称',
	teacher_name varchar(10) not null comment '讲师名字',
	course_description varchar(255) comment '课程描述',
	start_time datetime not null default current_timestamp comment '选课开始时间',
	end_time datetime not null comment '选课结束时间',
	course_price decimal(10, 2) not null default '0.00',
	stock_quantity int not null comment '库存',
	course_pic varchar(255) comment '课程图片url'
) engine = innodb charset = utf8;
#插入课程信息
insert into course values(default,1, 'Java快速入门与进阶','文宏峻','Java快速入门与进阶', '2020-09-16 16:46:00','2020-10-09 14:02:00','166',59,'1.jpg');
insert into course values(default,1, 'c语言入门','黄永新','c语言入门', '2020-09-13 08:32:00','2020-09-24 20:27:00','77',20,'2.jpg');
insert into course values(default,1, 'Python基础','常嘉容','Python基础', '2020-09-11 00:35:00','2020-10-01 14:52:00','93',80,'3.jpg');
insert into course values(default,1, 'Mysql入门','沈良工','Mysql入门', '2020-09-14 22:57:00','2020-09-21 01:17:00','89',90,'4.jpg');
insert into course values(default,1, 'SpringBoot教程','梁志勇','SpringBoot教程', '2020-09-10 16:31:00','2020-10-10 10:47:00','62',49,'5.jpg');
insert into course values(default,1, 'Spring教程','李俊力','Spring教程', '2020-09-14 04:19:00','2020-09-24 06:12:00','65',27,'6.jpg');
insert into course values(default,1, 'SpringMVC从入门到实战','孟光辉','SpringMVC从入门到实战', '2020-09-17 07:39:00','2020-10-03 12:33:00','69',115,'7.jpg');
insert into course values(default,1, 'MyBatis教程','于英发','MyBatis教程', '2020-09-10 00:33:00','2020-10-01 05:50:00','64',114,'8.jpg');
insert into course values(default,1, 'Redis从入门到精通','李浩波','Redis从入门到精通', '2020-09-13 15:21:00','2020-09-17 09:32:00','34',33,'9.jpg');
insert into course values(default,1, 'SpringCloud微服务+Docker部署','李阳飙','SpringCloud微服务+Docker部署', '2020-09-13 01:22:00','2020-09-21 00:31:00','37',22,'10.jpg');
insert into course values(default,2, 'Procreate零基础软件入门','田雁丝','Procreate零基础软件入门', '2020-09-07 21:06:00','2020-09-27 18:19:00','30',49,'11.jpg');
insert into course values(default,2, 'InDesign排版设计入门到精通','丁悦媛','InDesign排版设计入门到精通', '2020-09-11 08:22:00','2020-09-23 14:04:00','106',71,'12.jpg');
insert into course values(default,2, 'PS教程超级合辑','毛雨寒','PS教程超级合辑', '2020-09-08 16:35:00','2020-10-01 09:14:00','168',117,'13.jpg');
insert into course values(default,2, '平面设计创意365天','钟晔晔','平面设计创意365天', '2020-09-09 15:09:00','2020-10-09 07:23:00','82',72,'14.jpg');
insert into course values(default,3, '乐理入门篇','康晓慧','乐理入门篇', '2020-09-11 10:59:00','2020-09-29 07:26:00','101',99,'15.jpg');
insert into course values(default,3, '零基础钢琴初级入门','史松雪','零基础钢琴初级入门', '2020-09-10 13:20:00','2020-10-05 18:00:00','60',29,'16.jpg');
insert into course values(default,3, '混音全揭秘 基础篇','石弘新','混音全揭秘 基础篇', '2020-09-10 01:20:00','2020-09-27 18:58:00','52',30,'17.jpg');
insert into course values(default,3, '零基础学吉他','许哲茂','零基础学吉他', '2020-09-11 11:23:00','2020-09-23 18:33:00','71',104,'18.jpg');
insert into course values(default,4, '篆书入门','贺玉成','篆书入门', '2020-09-11 16:22:00','2020-10-11 14:58:00','32',95,'19.jpg');
insert into course values(default,4, '毛笔楷书入门','邵子濯','毛笔楷书入门', '2020-09-13 01:46:00','2020-09-18 00:07:00','163',59,'20.jpg');
insert into course values(default,4, '毛笔草书入门','郑天逸','毛笔草书入门', '2020-09-11 11:32:00','2020-09-15 07:03:00','158',58,'21.jpg');
insert into course values(default,4, '三分钟学会一个毛笔字','戴光亮','三分钟学会一个毛笔字', '2020-09-11 12:48:00','2020-09-21 06:52:00','113',120,'22.jpg');
insert into course values(default,5, '表格之道','刘星剑','表格之道', '2020-09-14 23:36:00','2020-09-25 11:19:00','103',50,'23.jpg');
insert into course values(default,5, '揭秘Excel真相','蒋飞鸾','揭秘Excel真相', '2020-09-15 19:06:00','2020-09-20 12:09:00','92',109,'24.jpg');
insert into course values(default,5, 'Word2019教程-入门到精通','林英朗','Word2019教程-入门到精通', '2020-09-09 04:07:00','2020-09-12 03:37:00','163',43,'25.jpg');
insert into course values(default,5, 'Word基础教程案例','方钰彤','Word基础教程案例', '2020-09-10 10:14:00','2020-09-16 04:18:00','64',82,'26.jpg');

#创建课程类型表
drop table if exists course_type;
create table if not exists course_type (
	course_type int primary key auto_increment comment '课程类型id',
	type_name varchar(20) not null comment '课程类型名'
) engine = innodb charset = utf8;
insert into course_type values(1,'IT·互联网');
insert into course_type values(2,'平面设计');
insert into course_type values(3,'音乐');
insert into course_type values(4,'书法 ');
insert into course_type values(5,'办公软件');
#创建订单表
drop table if exists orders;
create table if not exists orders (
	order_id int unique auto_increment comment '订单号',
	course_no int not null comment '课程号',
	username varchar(20) not null,
	course_name varchar(50) not null comment '课程名称',
	course_price decimal(10, 2) not null,
	payment varchar(255)comment '支付方式',
	pay_status int not null default 0 comment '支付状态',
	pay_date datetime comment '支付时间',
	create_date datetime not null comment '订单创建时间',
	course_pic varchar(255) comment '课程图片url',
	primary key(course_no,username)
) engine = innodb charset = utf8;