create database bai_tap_1;
create table phieu_xuat(
so_px int primary key auto_increment not null,
ngay_sx date
);
create table vat_tu(
ma_vt int primary key auto_increment,
ten_vt varchar(50)
);
create table chi_tiet_px(
so_px int,
ma_vt int,
dg_xuat double null,
sl_xuat int null,
primary key(so_px,ma_vt),
FOREIGN KEY (so_px) REFERENCES phieu_xuat(so_px), 
FOREIGN KEY (ma_vt) REFERENCES vat_tu(ma_vt)
);
create table phieu_nhap(
so_pn int primary key auto_increment,
ngay_nhap date 
);
create table chi_tiet_pn(
ma_vt int,
so_pn int,
dg_nhap double null,
sl_nhap int,
primary key(ma_vt,so_pn),
foreign key(ma_vt) references vat_tu(ma_vt),
foreign key(so_pn) references phieu_nhap(so_pn)
);
create table don_dh(
so_dh int primary key auto_increment,
ngay_dh date
);
create table chi_tiet_don_hang(
so_dh int,
ma_vt int,
primary key(so_dh,ma_vt)
);
create table nha_cc(
ma_ncc int primary key auto_increment,
ten_ncc varchar(50) null,
dia_chi varchar(100) null
);
alter table don_dh add ma_ncc int;
alter table don_dh add foreign key(ma_ncc) references nha_cc(ma_ncc); 
create table sdt(
sdt varchar(10) primary key
);
alter table nha_cc add sdt varchar(10);
alter table nha_cc add foreign key(sdt) references sdt(sdt); 
alter table chi_tiet_don_hang add foreign key(so_dh) references don_dh(so_dh); 
alter table chi_tiet_don_hang add foreign key(ma_vt) references vat_tu(ma_vt); 
alter table chi_tiet_don_hang add primary key(so_dh,ma_vt);
alter table nha_cc drop sdt;
alter table sdt add ma_ncc int;
alter table sdt add foreign key (ma_ncc) references nha_cc(ma_ncc);