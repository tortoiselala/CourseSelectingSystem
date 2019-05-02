

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
    login_date timestamp not null comment '登录日期',

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
    login_date timestamp not null comment '登录日期',
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
    check(current_number <= maxNumber)
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

load data local infile 'studentDetail1.txt' into table student fields terminated by ',';
load data local infile 'studentDetail2.txt' into table student fields terminated by ',';
load data local infile 'studentDetail3.txt' into table student fields terminated by ',';
load data local infile 'studentDetail4.txt' into table student fields terminated by ',';
load data local infile 'studentDetail5.txt' into table student fields terminated by ',';

insert into teacher
values ('M000000001', '一一一', '10000', '11111111', '1'),
       ('M000000002', '二二二', '10000', '11111111', '1'),
       ('M000000003', '三三三', '10000', '11111111', '1'),
       ('M000000004', '四四四', '10000', '11111111', '1'),
       ('M000000005', '五五五', '10000', '11111111', '1'),
       ('M000000006', '六六六', '10000', '11111111', '1'),
       ('M000000007', '八八八', '10000', '11111111', '1');

load data local infile 'course1.txt'
into table course
fields terminated by ','
(@col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10, @col11, @col12)
set name=@col2, teacher_id=@col3, credit_point=@col4, credit_hours=@col5,
max_number=@col6, current_number=@col7, start_time=@col8,
end_time=@col9, days=@col10, weeks=@col11, class_time=@col12;

load data local infile 'course2.txt'
into table course
fields terminated by ','
(@col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10, @col11, @col12)
set name=@col2, teacher_id=@col3, credit_point=@col4, credit_hours=@col5,
max_number=@col6, current_number=@col7, start_time=@col8,
end_time=@col9, days=@col10, weeks=@col11, class_time=@col12;

load data local infile 'course3.txt'
into table course
fields terminated by ','
(@col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10, @col11, @col12)
set name=@col2, teacher_id=@col3, credit_point=@col4, credit_hours=@col5,
max_number=@col6, current_number=@col7, start_time=@col8,
end_time=@col9, days=@col10, weeks=@col11, class_time=@col12;

load data local infile 'course4.txt'
into table course
fields terminated by ','
(@col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10, @col11, @col12)
set name=@col2, teacher_id=@col3, credit_point=@col4, credit_hours=@col5,
max_number=@col6, current_number=@col7, start_time=@col8,
end_time=@col9, days=@col10, weeks=@col11, class_time=@col12;