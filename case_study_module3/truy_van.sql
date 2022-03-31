use case_study_furama;
-- task2--
select ho_ten from nhan_vien where nhan_vien.ho_ten regexp '^[HTK]' and length(ho_ten)<=16;

-- task3--
select khach_hang.* from khach_hang where ((datediff(now(),khach_hang.ngay_sinh)/365)between 18 and 50) 
and (khach_hang.dia_chi like '% Đà Nẵng%' or khach_hang.dia_chi like '% Quảng Trị%');

-- task4 --
select khach_hang.ho_ten,count(hop_dong.ma_khach_hang) as so_lan_thue
from khach_hang
left join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach=loai_khach.ma_loai_khach where khach_hang.ma_loai_khach=1
group by khach_hang.ma_khach_hang
order by so_lan_thue asc;

-- task8--
select distinct khach_hang.ho_ten from khach_hang; 
select khach_hang.ho_ten from khach_hang where khach_hang.ho_ten=khach_hang.ho_ten;