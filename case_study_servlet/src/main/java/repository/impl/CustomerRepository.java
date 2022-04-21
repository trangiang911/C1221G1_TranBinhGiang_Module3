package repository.impl;

import model.customer.Customer;
import model.customer.TypeCustomer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from khach_hang");
            ResultSet resultSet=preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()){
                customer=new Customer();
                customer.setMaKhachHang(resultSet.getInt("ma_khach_hang"));
                customer.setMaLoaiKhach(resultSet.getInt("ma_loai_khach"));
                customer.setHoTen(resultSet.getString("ho_ten"));
                customer.setNgaySinh(resultSet.getString("ngay_sinh"));
                customer.setGioiTinh(resultSet.getInt("gioi_tinh"));
                customer.setSoCMND(resultSet.getString("so_cmnd"));
                customer.setSoDienThoai(resultSet.getString("so_dien_thoai"));
                customer.setEmail(resultSet.getString("email"));
                customer.setDiaChi(resultSet.getString("dia_chi"));
                customerList.add(customer);
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
        return customerList;
    }

    @Override
    public List<TypeCustomer> subFindAll() {
        List<TypeCustomer> typeCustomerList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from loai_khach");
            ResultSet resultSet=preparedStatement.executeQuery();
            TypeCustomer typeCustomer;
            while (resultSet.next()){
                typeCustomer=new TypeCustomer();
                typeCustomer.setMaLoaiKhachHang(resultSet.getInt("ma_loai_khach"));
                typeCustomer.setLoaiKhachHang(resultSet.getString("ten_loai_khach"));
                typeCustomerList.add(typeCustomer);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return typeCustomerList;
    }

    @Override
    public void save(Customer customer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB()
                    .prepareStatement("insert into khach_hang(`ma_loai_khach`, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi) values (?,?,?,?,?,?,?,?);");
            preparedStatement.setInt(1, customer.getMaLoaiKhach());
            preparedStatement.setString(2, customer.getHoTen());
            preparedStatement.setString(3, customer.getNgaySinh());
            preparedStatement.setInt(4, customer.getGioiTinh());
            preparedStatement.setString(5, customer.getSoCMND());
            preparedStatement.setString(6, customer.getSoDienThoai());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getDiaChi());
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
    public Customer findById(Integer id) {
        Customer customer  = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from khach_hang where ma_khach_hang=?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Integer type;
            String name;
            String date;
            Integer gioi_tinh;
            String cmnd;
            String sdt;
            String email;
            String dia_chi;
            while (resultSet.next()) {
                type =Integer.parseInt(resultSet.getString("ma_loai_khach"));
                name = resultSet.getString("ho_ten");
                date = resultSet.getString("ngay_sinh");
                gioi_tinh = Integer.parseInt(resultSet.getString("gioi_tinh"));
                cmnd=resultSet.getString("so_cmnd");
                sdt=resultSet.getString("so_dien_thoai");
                email=resultSet.getString("email");
                dia_chi=resultSet.getString("dia_chi");
                customer = new Customer(id,type,name,date,gioi_tinh,cmnd,sdt,email,dia_chi);
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
        return customer;
    }

    @Override
    public boolean update(Customer customer) {
        boolean rowUpdate=false;
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("update khach_hang " +
                    "set ma_loai_khach=?,ho_ten=?,ngay_sinh=?,gioi_tinh=?,so_cmnd=?,so_dien_thoai=?,email=?,dia_chi=? where ma_khach_hang=?");
            preparedStatement.setInt(1,customer.getMaLoaiKhach());
            preparedStatement.setString(2,customer.getHoTen());
            preparedStatement.setString(3,customer.getNgaySinh());
            preparedStatement.setInt(4,customer.getGioiTinh());
            preparedStatement.setString(5,customer.getSoCMND());
            preparedStatement.setString(6,customer.getSoDienThoai());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getDiaChi());
            preparedStatement.setInt(9,customer.getMaKhachHang());
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

    @Override
    public boolean remove(Integer id) {
        boolean rowDel=false;
        try {
            CallableStatement callableStatement = baseRepository.getConnectionJavaToDB().prepareCall
                    ("{call sp_xoa_khach_hang(?)}");
            callableStatement.setInt(1,id);
            rowDel = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDel;
    }

    @Override
    public List<Customer> search(String name, String diaChi, String type) {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("SELECT * FROM khach_hang where ho_ten like ? and dia_chi like ? and ma_loai_khach like ?;");
            preparedStatement.setString(1,"%"+name+"%");
            preparedStatement.setString(2,"%"+diaChi+"%");
            preparedStatement.setString(3,"%"+type+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()){
                Integer id = resultSet.getInt("ma_khach_hang");
                Integer idType = resultSet.getInt("ma_loai_khach");
                String name1 = resultSet.getString("ho_ten");
                String dateOfBirth = resultSet.getString("ngay_sinh");
                Integer gender = resultSet.getInt("gioi_tinh");
                String id_card = resultSet.getString("so_cmnd");
                String phone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                customerList.add(new Customer(id, idType, name1, dateOfBirth, gender, id_card, phone, email, address));
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
        return customerList;
    }
}
