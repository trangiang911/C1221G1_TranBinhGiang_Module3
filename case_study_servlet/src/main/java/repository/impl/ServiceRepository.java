package repository.impl;

import model.customer.Customer;
import model.service_model.Service;
import repository.BaseRepository;
import repository.IServiceRepository;
import service.IServiceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Service> findAll() {
        List<Service> serviceList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from dich_vu ");
            ResultSet resultSet=preparedStatement.executeQuery();
            Service service;
            while (resultSet.next()){
                service=new Service();
                service.setMaDichVu(resultSet.getInt("ma_dich_vu"));
                service.setTenDichVu(resultSet.getString("ten_dich_vu"));
                service.setDienTich(resultSet.getInt("dien_tich"));
                service.setChiPhiThue(resultSet.getDouble("chi_phi_thue"));
                service.setSoNguoiToiDa(resultSet.getInt("so_nguoi_toi_da"));
                service.setKieuThue(resultSet.getInt("ma_kieu_thue"));
                service.setMaLoaiDichVu(resultSet.getInt("ma_loai_dich_vu"));
                service.setMatieuChuanPhong(resultSet.getString("tieu_chuan_phong"));
                service.setMoTa(resultSet.getString("mo_ta_tien_nghi_khac"));
                service.setDienTichHoBoi(resultSet.getDouble("dien_tich_ho_boi"));
                service.setSoTang(resultSet.getInt("so_tang"));
                serviceList.add(service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return serviceList;    }

    @Override
    public void save(Service service) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB()
                    .prepareStatement("insert into dich_vu(ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue, ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang) values (?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, service.getTenDichVu());
            preparedStatement.setInt(2, service.getDienTich());
            preparedStatement.setDouble(3, service.getChiPhiThue());
            preparedStatement.setInt(4, service.getSoNguoiToiDa());
            preparedStatement.setInt(5, service.getKieuThue());
            preparedStatement.setInt(6, service.getMaLoaiDichVu());
            preparedStatement.setString(7, service.getMatieuChuanPhong());
            preparedStatement.setString(8, service.getMoTa());
            preparedStatement.setDouble(9, service.getDienTichHoBoi());
            preparedStatement.setInt(10, service.getSoTang());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Service findById(Integer id) {
        return null;
    }
}
