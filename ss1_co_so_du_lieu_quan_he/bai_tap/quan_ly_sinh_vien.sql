create database `student-management`;
create table `student-management`.`studen`(
`id` int not null,
`name` varchar(45) null,
`age` int null,
`country` varchar(45) null,
primary key (`id`)); 
create table `student-management`.`class`(
`id` int primary key not null,
`nameclass` varchar(45) null,
`amount` int null
);
create table `student-management`.`teacher`(
`id` int primary key not null,
`name` varchar(45) null,
`age` int null,
`country` varchar(45) null );