create database bai_tap_2;
use bai_tap_2;
create table customer(
c_id int primary key auto_increment,
c_name varchar(50) null,
c_age int not null 
);
create table `order`(
o_id int primary key auto_increment,
c_id int,
o_date date,
o_total_price double null,
foreign key (c_id) references customer(c_id)
);
create table product(
p_id int primary key auto_increment,
p_name varchar(25) null,
p_price double null
);
create table order_detail(
o_id int,
p_id int,
od_qty int null,
primary key (o_id,p_id),
foreign key (o_id) references `order`(o_id),
foreign key (p_id) references product(p_id)
);