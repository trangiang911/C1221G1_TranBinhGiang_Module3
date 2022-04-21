package repository.impl;

import model.employee.Employee;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List findAll() {
        List<Employee> employeeList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from nhan_vien");
            ResultSet resultSet=preparedStatement.executeQuery();
            Employee employee;
            while (resultSet.next()){
                employee=new Employee();
                employee.setMaNhanVien(resultSet.getInt("ma_nhan_vien"));
                employee.setHoTen(resultSet.getString("ho_ten"));
                employee.setNgaySinh(resultSet.getString("ngay_sinh"));
                employee.setCmnd(resultSet.getString("so_cmnd"));
                employee.setLuong(resultSet.getString("luong"));
                employee.setSdt(resultSet.getString("so_dien_thoai"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDiaChi(resultSet.getString("dia_chi"));
                employee.setMaViTri(resultSet.getInt("ma_vi_tri"));
                employee.setMaTrinhDo(resultSet.getInt("ma_trinh_do"));
                employee.setMaBoPhan(resultSet.getInt("ma_bo_phan"));
                employeeList.add(employee);
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
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB()
                    .prepareStatement("insert into nhan_vien( ho_ten, ngay_sinh, so_cmnd,luong, so_dien_thoai, email, dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) values (?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, employee.getHoTen());
            preparedStatement.setString(2, employee.getNgaySinh());
            preparedStatement.setString(3, employee.getCmnd());
            preparedStatement.setDouble(4, Double.parseDouble(employee.getLuong()));
            preparedStatement.setString(5, employee.getSdt());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getDiaChi());
            preparedStatement.setInt(8, employee.getMaViTri());
            preparedStatement.setInt(9, employee.getMaTrinhDo());
            preparedStatement.setInt(10, employee.getMaBoPhan());
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
    public Employee findById(Integer id) {
        Employee employee  = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from nhan_vien where ma_nhan_vien=?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String name;
            String date;
            String cmnd;
            String luong;
            String sdt;
            String email;
            String diaChi;
            Integer viTri;
            Integer trinhDo;
            Integer boPhan;
            while (resultSet.next()) {
                name = resultSet.getString("ho_ten");
                date = resultSet.getString("ngay_sinh");
                cmnd=resultSet.getString("so_cmnd");
                luong=Double.toString(resultSet.getDouble("luong"));
                sdt=resultSet.getString("so_dien_thoai");
                email=resultSet.getString("email");
                diaChi=resultSet.getString("dia_chi");
                viTri=resultSet.getInt("ma_vi_tri");
                trinhDo=resultSet.getInt("ma_trinh_do");
                boPhan=resultSet.getInt("ma_bo_phan");
                employee = new Employee(id,name,date,cmnd,luong,sdt,email,diaChi,viTri,trinhDo,boPhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public boolean update(Employee employee) {
        boolean rowUpdate=false;
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("update nhan_vien " +
                    "set ho_ten=?,ngay_sinh=?,so_cmnd=?,luong=?,so_dien_thoai=?,email=?,dia_chi=?,ma_vi_tri=?,ma_trinh_do=?,ma_bo_phan=? where ma_nhan_vien=?");
            preparedStatement.setString(1,employee.getHoTen());
            preparedStatement.setString(2,employee.getNgaySinh());
            preparedStatement.setString(3,employee.getCmnd());
            preparedStatement.setDouble(4,Double.parseDouble(employee.getLuong()));
            preparedStatement.setString(5,employee.getSdt());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getDiaChi());
            preparedStatement.setInt(8,employee.getMaViTri());
            preparedStatement.setInt(9,employee.getMaTrinhDo());
            preparedStatement.setInt(10,employee.getMaBoPhan());
            preparedStatement.setInt(11,employee.getMaNhanVien());
            rowUpdate=preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowUpdate;
    }
}
