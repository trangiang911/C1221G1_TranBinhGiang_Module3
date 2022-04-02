create database product_bai_tap;
use product_bai_tap;
create table products_1 (
    id int auto_increment primary key ,
    product_code varchar(25) null,
    product_name varchar(25) null,
    product_price double null,
    product_amount int null,
    product_description varchar(50) null,
    product_status bit
);

insert into products_1 (product_code,product_name,product_price,product_amount,product_description,product_status)
values
('sp1','sữa',5000,1,'sữa',1),
('sp2','kẹo',10000,5,'kẹo',0),
('sp3','Ke',15000,1,'Ke',1),
('sp4','Đá',20000,10,'Đá',1),
('sp5','Nước',25000,20,'Nước',0);

select * from products_1 where  product_code= 'sp5';
select * from products_1 where product_name='sữa' and product_price=5000;
explain select * from products_1 where  product_code= 'sp5';
explain select * from products_1 where product_name='sữa' and product_price=5000;
create unique index product_code_idx on products_1 (product_code);
create index product_code_com_idx on products_1(product_name,product_price);

create view product_bai_tap.product_1_view  as select product_code,product_name,product_price,product_status from products_1;
select * from product_1_view;
insert into product_1_view value ('sp6','Cần',500000,0);
drop view product_1_view;

delimiter //
create procedure  display_all()
begin
    select * from products_1;
end //
delimiter //;
call display_all();

delimiter //
create procedure add_product(in `code` varchar(25), `name` varchar(25),`price` double,`amount` int,`description` varchar(50),`status` bit)
begin
    insert into products_1(product_code,product_name,product_price,product_amount,product_description,product_status) value
    (code,name,price,amount,description,status);
end //
delimiter //;

call add_product('sp7','bia',12000,5,'bia',0);

delimiter //
create procedure edit_product(in `id_edit` int,`ma_sp` varchar(25),`name` varchar(25),`price` double,`amount` int,`description` varchar(50),`status` bit)
begin
    update
        products_1
            set product_code=`ma_sp`,product_name=`name`,product_price=`price`,product_amount=`amount`,product_description=`description`,product_status=`status`
    where id=`id_edit`;
end //
delimiter //
call edit_product(1,'sp8','rượu',6000,9,'rượu',1);

delimiter //
create procedure del_product(in `id_del` int)
begin
    delete from products_1 where id=id_del;
end //
delimiter //
call del_product(1);
