-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE db_course_selection

USE db_course_selection;

create table student
(
	id char(10) not null comment '学号',
	name char(10) not null comment '姓名',
	grade char(4) not null comment '年级',
	password CHAR(20) not null comment '密码',
	major_id char(5) not null comment '专业',
	school_id char(5) not null comment '学院',
	sex char not null comment '性别',

	primary key (id)
)
comment '学生信息表' engine=innodb default CHARSET = utf8;

-- 初始化数据
insert into student values
                           ('U201614515', '吴阳民', 2016, '1546191727', '01010', '10000', '1'),
                           ('U201614516', '一一一', 2016, '1546191727', '01010', '10000', '1');

create table teacher(
    id char(10) not null comment '工号',
    name char(10) not null comment '姓名',
    school_id char(10) not null comment '学院',
    password char(20) not null comment '密码',
    sex char(1) not null comment '性别',

    primary key (id)
) comment '教师信息表' engine=innodb default charset utf8;

insert into teacher values
    ('M201614515', '二二二', '10000', '2222222222', '1');

create table course(
    id bigint not null auto_increment comment '编号',
    name char(10) not null comment '课程名',
    teacher_id char(10) not null comment '开课教师',
    credit_point float not null comment '学分',
    credit_hours tinyint not null comment '学时',
    max_number tinyint not null comment '最大报名人数',
    current_number tinyint not null comment '已经报名人数',
    start_time date not null comment '开始日期',
    end_time date not null comment '结束日期',
    days tinyint not null comment '一周内哪一天开设',
    weeks int not null comment '20周内哪一周开设',
    class_time smallint not null comment '12节课',

    primary key (id,teacher_id, start_time, end_time),
    foreign key (teacher_id) references teacher(id)
)comment '课程信息表' engine = innodb default charset = utf8 auto_increment = 1000;

insert into course
    (name, teacher_id, credit_point, credit_hours, max_number, current_number, start_time, end_time, days, weeks, class_time)
    values
    ('计算机网络', 'M201614515', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4');


create table course_selection(
    student_id char(10) not null comment '学生id',
    course_id bigint not null comment '课程id',
    grade smallint default -1,

    primary key (student_id, course_id),
    foreign key (student_id) references student(student_id),
    foreign key (course_id) references course(id)
)comment '学生选课表', engine = innodb, default charset utf8;


create table time_schedule(
    id bigint not null auto_increment comment '开放区间编号',
    start_time date not null comment '开放区间起始',
    end_time date comment '开放区间结束',

    primary key (id)
)comment '选课开放时间表' engine innodb, default charset utf8, auto_increment = 1;

