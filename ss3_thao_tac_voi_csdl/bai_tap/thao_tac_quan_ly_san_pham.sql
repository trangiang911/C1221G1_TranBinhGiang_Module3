use bai_tap_2;
insert into customer (c_name,c_age) values
('Minh quân',10),('Ngọc Oang',20),('Hong Ha',50);
insert into `order` (c_id,o_date,o_total_price) values
(1,'2006-03-21',null),(2,'2006-03-23',null),(1,'2006-03-16',null);
insert into product (p_name,p_price) values
('May giat',3),('tu lanh',5),('dieu hoa',7),('quat',1),('bep dien',2);
insert into order_detail (o_id,p_id,od_qty) values
(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);
select o_id,o_date,o_total_price from `order`;
select c_name,p_name from customer join `order` on customer.c_id=`order`.c_id join order_detail on `order`.o_id=order_detail.o_id join product on order_detail.p_id=product.p_id;
select c_name from customer left join `order` on customer.c_id=`order`.c_id where `order`.c_id is null;	
select `order`.o_id,o_date,sum(p_price*od_qty) as total 
from `order` inner join order_detail on `order`.o_id=order_detail.o_id
inner join product on order_detail.p_id=product.p_id
group by `order`.o_id;