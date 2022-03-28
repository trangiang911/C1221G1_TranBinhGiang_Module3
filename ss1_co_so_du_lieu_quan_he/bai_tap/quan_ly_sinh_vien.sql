create database `student-management`;
create table `student-management`.`student`(
`id` int not null,
`name` varchar(45) null,
`age` int null,
`country` varchar(45) null,
primary key (`id`)); 
create table `student-management`.`class`(
`id` int  primary key not null,
`nameclass` varchar(45) null,
`amount` int null
);
create table `student-management`.`teacher`(
`id` int primary key not null,
`name` varchar(45) null,
`age` int null,
`country` varchar(45) null );
insert  into `student-management`.`class`
(id,`nameclass`,amount)
values
(10,"C1221G1",27),
(26,"C0322G1",20),
(34,"C121G1",30),
(47,"C022G1",50);

alter table class
add teacher_cn varchar(50);
alter table class
drop teacher_cn;