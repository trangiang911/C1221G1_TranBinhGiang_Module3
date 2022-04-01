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

-- task 15--
use case_study_furama;
select nv.ma_nhan_vien,nv.ho_ten,nv.so_dien_thoai,nv.dia_chi,
count(*) as so_lan
from nhan_vien nv
left join hop_dong on nv.ma_nhan_vien = hop_dong.ma_nhan_vien
group by nv.ma_nhan_vien
 having so_lan>=3;

