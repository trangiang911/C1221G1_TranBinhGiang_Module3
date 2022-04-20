use case_study_furama;
-- task2--
select ho_ten
from nhan_vien
where nhan_vien.ho_ten regexp '^[HTK]'
  and length(ho_ten) <= 16;

-- task3-

use case_study_furama;
select khach_hang.*
from khach_hang
where ((datediff(now(), khach_hang.ngay_sinh) / 365) between 18 and 50)
  and (khach_hang.dia_chi like '% Đà Nẵng%' or khach_hang.dia_chi like '% Quảng Trị%');

-- task4 --
use case_study_furama;
select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as so_lan_thue
from khach_hang
         join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where khach_hang.ma_loai_khach = 1
group by khach_hang.ma_khach_hang
order by so_lan_thue asc;

-- task5--
use case_study_furama;
select khach_hang.ma_khach_hang,
       khach_hang.ho_ten,
       loai_khach.ten_loai_khach,
       hop_dong.ma_hop_dong,
       dich_vu.ten_dich_vu,
       hop_dong.ngay_lam_hop_dong,
       hop_dong.ngay_ket_thuc,
       sum(dich_vu.chi_phi_thue + coalesce(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia, 0)) as tong_tien
from khach_hang
         left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
         left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
         left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
         left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
         left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong, khach_hang.ma_khach_hang;

-- task6--
use case_study_furama;
select distinct dich_vu.ma_dich_vu,
                dich_vu.ten_dich_vu,
                dich_vu.dien_tich,
                dich_vu.chi_phi_thue,
                loai_dich_vu.ten_loai_dich_vu
from dich_vu
         left join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
         left join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where hop_dong.ngay_lam_hop_dong not between '2021-01-01' and '2021-03-30'
  and hop_dong.ma_dich_vu not in
      (select hop_dong.ma_dich_vu from hop_dong where hop_dong.ngay_lam_hop_dong between '2021-01-01' and '2021-03-30');

-- task8--
-- c1--
use case_study_furama;
select distinct khach_hang.ho_ten
from khach_hang;
-- c2--
use case_study_furama;
select khach_hang.ho_ten
from khach_hang
union
select khach_hang.ho_ten
from khach_hang;
-- c3--
use case_study_furama;
select khach_hang.ho_ten
from khach_hang
group by khach_hang.ho_ten;
-- task9--
use case_study_furama;
select (month(ngay_lam_hop_dong)) as thang, count(ma_khach_hang) as so_luong_khach_hang
from hop_dong
group by thang
order by thang asc;

-- task10--
select hop_dong.ma_hop_dong,
       ngay_lam_hop_dong,
       ngay_ket_thuc,
       tien_dat_coc,
       sum(coalesce(hop_dong_chi_tiet.so_luong, 0)) as so_luong_dich_vu_di_kem
from hop_dong
         left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by hop_dong.ma_hop_dong;

-- task11--
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem
from hop_dong_chi_tiet
         join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
         join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
         join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
         join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where khach_hang.ma_loai_khach = 1
  and dia_chi like '%Vinh%';

-- task12--
select hop_dong.ma_hop_dong,
       nhan_vien.ho_ten,
       khach_hang.ho_ten,
       khach_hang.so_dien_thoai,
       ten_dich_vu,
       sum(coalesce(hop_dong_chi_tiet.so_luong, 0)) as so_luong_dich_vu_di_kem,
       tien_dat_coc
from hop_dong
         left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
         left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
         left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
         left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where hop_dong.ngay_lam_hop_dong between '2020-10-01' and '2020-12-31'
  and hop_dong.ngay_lam_hop_dong not between '2021-01-01' and '2020-06-30'
group by hop_dong.ma_hop_dong;

-- task 13--
select dich_vu_di_kem.ma_dich_vu_di_kem,
       dich_vu_di_kem.ten_dich_vu_di_kem,
       sum(coalesce(hop_dong_chi_tiet.so_luong, 0)) as so_luong_dich_vu_di_kem
from dich_vu_di_kem
         join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem = (select sum(coalesce(so_luong, 0)) as x
                                  from hop_dong_chi_tiet
                                  group by hop_dong_chi_tiet.ma_hop_dong_chi_tiet
                                  order by x desc
                                  limit 1);

-- task 14--
select hop_dong.ma_hop_dong,
       loai_dich_vu.ten_loai_dich_vu,
       dich_vu_di_kem.ten_dich_vu_di_kem,
       count(dich_vu_di_kem.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong
         join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
         join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
         join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
         join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_su_dung = 1;
# order by ma_hop_dong asc ;

-- task 15--
use case_study_furama;
select nv.ma_nhan_vien,
       nv.ho_ten,
       nv.so_dien_thoai,
       nv.dia_chi,
       count(*) as so_lan
from nhan_vien nv
         left join hop_dong on nv.ma_nhan_vien = hop_dong.ma_nhan_vien
group by nv.ma_nhan_vien
having so_lan >= 3;

-- task16--
use case_study_furama;
set sql_safe_updates = 0;
set foreign_key_checks = 0;
delete
from nhan_vien
where nhan_vien.ma_nhan_vien not in (select ma_nhan_vien
                                     from (select distinct nhan_vien.ma_nhan_vien
                                           from nhan_vien
                                                    join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
                                           where year(hop_dong.ngay_lam_hop_dong) between '2019' and '2021') as x);
set sql_safe_updates = 1;
set foreign_key_checks = 1;
-- task17--
update khach_hang
set khach_hang.ma_loai_khach=1
where khach_hang.ma_khach_hang in (select ma_khach_hang
                                   from (select distinct khach_hang.ma_khach_hang,
                                                         sum(dich_vu.chi_phi_thue +
                                                             coalesce(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia, 0)) as tong_tien
                                         from dich_vu
                                                  join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
                                                  join hop_dong_chi_tiet
                                                       on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
                                                  join dich_vu_di_kem
                                                       on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
                                                  join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
                                         where year(ngay_lam_hop_dong) = '2021'
                                           and khach_hang.ma_loai_khach = 2
                                         group by hop_dong.ma_hop_dong
                                         having tong_tien > 10000000) as y);
-- task18--
set sql_safe_updates = 0;
SET FOREIGN_KEY_CHECKS = 0;
delete
from khach_hang
where khach_hang.ma_khach_hang in (select ma_khach_hang
                                   from (select distinct khach_hang.ma_khach_hang
                                         from khach_hang
                                                  join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
                                         where year(ngay_lam_hop_dong) < '2021') as table_se_xoa);
SET FOREIGN_KEY_CHECKS = 1;
set sql_safe_updates = 1;
-- task19--
update dich_vu_di_kem
set gia=gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem in (select ma_dich_vu_di_kem
                                           from (select distinct dich_vu_di_kem.ma_dich_vu_di_kem,
                                                                 sum(coalesce(hop_dong_chi_tiet.so_luong, 0)) as so_lan_su_dung
                                                 from dich_vu_di_kem
                                                          join hop_dong_chi_tiet
                                                               on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
                                                          join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
                                                 where year(ngay_lam_hop_dong) = '2020'
                                                 group by dich_vu_di_kem.ma_dich_vu_di_kem
                                                 having so_lan_su_dung > 10) as z);

-- task 20--
select khach_hang.ma_khach_hang as id,
       khach_hang.ho_ten,
       khach_hang.email,
       khach_hang.so_dien_thoai,
       khach_hang.ngay_sinh,
       khach_hang.dia_chi
from khach_hang
union all
select nhan_vien.ma_nhan_vien as id,
       nhan_vien.ho_ten,
       nhan_vien.email,
       nhan_vien.so_dien_thoai,
       nhan_vien.ngay_sinh,
       nhan_vien.dia_chi
from nhan_vien;

-- task21--
create or replace view v_nhan_vien as
select *
from nhan_vien
where nhan_vien.dia_chi like '%Hải Châu%'
  and nhan_vien.ma_nhan_vien in (select ma_nhan_vien
                                 from hop_dong
                                 where hop_dong.ngay_lam_hop_dong = '2019-12-12');

-- task22--
set sql_safe_updates = 0;
update v_nhan_vien
set dia_chi = 'Liên Chiểu'
where true;
set sql_safe_updates = 1;

-- task23--
delimiter //
create procedure sp_xoa_khach_hang(in ma_khach_hang_del int)
begin
    set sql_safe_updates = 0;
    set foreign_key_checks = 0;
    delete from khach_hang where ma_khach_hang = ma_khach_hang_del;
    set foreign_key_checks = 1;
    set sql_safe_updates = 1;
end;
delimiter //
-- task24--
delimiter //
create procedure add_them_hop_dong(add_ngay_lam_hd date, add_ngay_ket_thuc date, add_tien_dat_coc double,
                                   add_ma_nhan_vien int, add_ma_khach_hang int, add_ma_dich_vu int)
begin
    if datediff(add_ngay_lam_hd, add_ngay_ket_thuc) < 0
    then
        signal sqlstate '91111'
            set message_text = 'ngày làm hd phải bé hơn ngày kết thúc';
    end if
    //
    if add_ma_nhan_vien not in (select ma_nhan_vien from nhan_vien)
    then
        signal sqlstate '91111'
            set message_text = 'Mã nhân viên ko tồn tại';
    end if
    //
    if add_ma_khach_hang not in (select ma_khach_hang from khach_hang)
    then
        signal sqlstate '91111'
            set message_text = 'Mã khách hàng k tồn tại';
    end if
    //
    if add_ma_dich_vu not in (select ma_dich_vu from dich_vu)
    then
        signal sqlstate '91111'
            set message_text = 'Mã dịch vụ k tồn tại';
    end if
    //
    insert into hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
    values (add_ngay_lam_hd, add_ngay_ket_thuc, add_tien_dat_coc, add_ma_nhan_vien, add_ma_khach_hang, add_ma_dich_vu);
end;
delimiter //
call add_them_hop_dong();

-- task25--
DELIMITER //
CREATE TRIGGER tr_xoa_hop_dong AFTER DELETE
    ON hop_dong
    FOR EACH ROW
BEGIN
    SET @x = (SELECT count(*) AS FROM hop_dong);
END;
DELIMITER //
set foreign_key_checks =0;
SET @x = 0;
DELETE FROM hop_dong where hop_dong.ma_hop_dong = 12;
SELECT @x AS 'Total amount deleted' ;
set foreign_key_checks =0;

-- task26--
DELIMITER //
CREATE TRIGGER tr_cap_nhat_hop_dong
    BEFORE UPDATE
    ON hop_dong
    FOR EACH ROW
BEGIN
    IF datediff(NEW.ngay_ket_thuc, NEW.ngay_lam_hop_dong) < 2 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT ='Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
    END IF;
END //
DELIMITER ;
UPDATE hop_dong set ngay_ket_thuc = '2021-09-08' WHERE ma_hop_dong = 7;

-- task27--
delimiter //
create function func_dem_dich_vu()
    returns int
reads sql data deterministic
begin
    select count(ma_dich_vu)
    into @count
    from (select dich_vu.ma_dich_vu, count(hop_dong.ma_dich_vu) as so_lan_sd
          from hop_dong
                   join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
          group by ma_dich_vu,dich_vu.chi_phi_thue
        having (so_lan_sd*dich_vu.chi_phi_thue)>2000000) as aa;
    return @count;
end //
delimiter //

select func_dem_dich_vu() as 'Tổng số lượng dịch vụ có tổng tiền trên 2000000';
delimiter //
drop function if exists func_tinh_thoi_gian_hop_dong //
create function func_tinh_thoi_gian_hop_dong(ma_khach_hang int ) returns int
    deterministic
begin
    set @thoi_gian_dai_nhat = (select max(datediff(hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc)) from hop_dong
                               where hop_dong.ma_hop_dong = ma_khach_hang);
    return @thoi_gian_dai_nhat;
end;
select func_tinh_thoi_gian_hop_dong(4) as 'thời gian dài nhất';

-- task28--
delimiter //
drop procedure if exists sp_xoa_dich_vu_va_hd_room //
create procedure sp_xoa_dich_vu_va_hd_room()
begin
    declare dich_vu_1 int default 0;
    declare hoan_thanh int default 0;
    declare con_tro cursor for
        select dich_vu.ma_dich_vu from dich_vu join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
                                               join loai_dich_vu on dich_vu.ma_dich_vu = loai_dich_vu.ma_loai_dich_vu
        where loai_dich_vu.ten_loai_dich_vu = 'room' and year(hop_dong.ngay_lam_hop_dong) between '2015' and '2025' ;
    declare continue handler for not found set hoan_thanh = 1;
    open con_tro;
    get_list: loop
        fetch from con_tro into dich_vu;
        if hoan_thanh = 1 then
            leave get_list;
        end if;
        delete from hop_dong where hop_dong.ma_dich_vu = dich_vu_1 ;
        delete from dich_vu where dich_vu.ma_dich_vu = dich_vu_1;
    end loop get_list;
    close con_tro;
end //
set foreign_key_checks =0;
call sp_xoa_dich_vu_va_hd_room();
set foreign_key_checks =1;