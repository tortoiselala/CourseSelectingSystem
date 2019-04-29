

create database if not exists db_course_selection;

use db_course_selection;

create table student
(
    id        char(10) not null comment '学号',
    name      char(10) not null comment '姓名',
    grade     char(4)  not null comment '年级',
    password  CHAR(20) not null comment '密码',
    major_id  char(5)  not null comment '专业',
    school_id char(5)  not null comment '学院',
    sex       char     not null comment '性别',

    primary key (id),
    index (id)
)
    comment '学生信息表' engine = innodb
                    default CHARSET = utf8;

-- 初始化教师信息表
create table teacher
(
    id        char(10) not null comment '工号',
    name      char(10) not null comment '姓名',
    school_id char(10) not null comment '学院',
    password  char(20) not null comment '密码',
    sex       char(1)  not null comment '性别',

    primary key (id),
    index (id)
) comment '教师信息表' engine = innodb
                  default charset utf8;

-- 初始化课程信息表

create table course
(
    id             bigint    not null auto_increment comment '编号',
    name           char(10)  not null comment '课程名',
    teacher_id     char(10)  not null comment '开课教师',
    credit_point   float     not null comment '学分',
    credit_hours   tinyint   not null comment '学时',
    max_number     tinyint   not null comment '最大报名人数',
    current_number tinyint   not null comment '已经报名人数',
    start_time     date      not null comment '开始日期',
    end_time       date      not null comment '结束日期',
    days           tinyint   not null comment '一周内哪一天开设',
    weeks          int       not null comment '20周内哪一周开设',
    class_time     smallint  not null comment '12节课',
    allow_grade   smallint  not null comment '允许选课的年级',
    detail         char(100) not null comment '课程详情',

    primary key (id, teacher_id, start_time, end_time),
    foreign key (teacher_id) references teacher (id)
) comment '课程信息表' engine = innodb
                  default charset = utf8
                  auto_increment = 1000;


-- 初始化选课信息表
create table selected_course
(
    student_id char(10) not null comment '学生id',
    course_id  bigint   not null comment '课程id',
    score      smallint default -1,

    primary key (student_id, course_id),
    foreign key (student_id) references student (id),
    foreign key (course_id) references course (id)
) comment '学生选课表', engine = innodb,
                   default charset utf8;


-- 系统开放时间表
create table system_schedule
(
    id         bigint not null auto_increment comment '开放区间编号',
    start_time date   not null comment '开放区间起始',
    end_time   date comment '开放区间结束',

    primary key (id)
) comment '选课开放时间表' engine innodb,
                    default charset utf8,
                    auto_increment = 1;


-- 初始化数据
insert into student
values ('U000000001', '一一一', 2016, '1546191727', '01010', '10000', '1'),
       ('U000000002', '二二二', 2016, '1546191727', '01010', '10000', '1'),
       ('U000000003', '三三三', 2016, '1546191727', '01010', '10000', '1'),
       ('U000000004', '四四四', 2016, '1546191727', '01010', '10000', '1'),
       ('U000000005', '五五五', 2016, '1546191727', '01010', '10000', '1'),
       ('U000000006', '六六六', 2016, '1546191727', '01010', '10000', '1'),
       ('U000000007', '七七七', 2016, '1546191727', '01010', '10000', '1'),
       ('U000000008', '八八八', 2016, '1546191727', '01010', '10000', '1');

insert into teacher
values ('M000000001', '一一一', '10000', '11111111', '1'),
       ('M000000002', '二二二', '10000', '11111111', '1'),
       ('M000000003', '三三三', '10000', '11111111', '1'),
       ('M000000004', '四四四', '10000', '11111111', '1'),
       ('M000000005', '五五五', '10000', '11111111', '1'),
       ('M000000006', '六六六', '10000', '11111111', '1'),
       ('M000000007', '八八八', '10000', '11111111', '1');

insert into course
(name, teacher_id, credit_point, credit_hours, max_number, current_number, start_time, end_time, days, weeks,
 class_time)
values ('课程1', 'M000000001', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4'),
       ('课程2', 'M000000001', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4'),
       ('课程3', 'M000000002', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4'),
       ('课程4', 'M000000002', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4'),
       ('课程5', 'M000000003', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4'),
       ('课程6', 'M000000003', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4'),
       ('课程7', 'M000000004', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4'),
       ('课程7', 'M000000004', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4'),
       ('课程8', 'M000000005', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4'),
       ('课程10', 'M000000005', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4'),
       ('课程11', 'M000000006', 2.5, 20, 120, 0, '2018-01-01', '2019-01-01', '3', '215', '4');
