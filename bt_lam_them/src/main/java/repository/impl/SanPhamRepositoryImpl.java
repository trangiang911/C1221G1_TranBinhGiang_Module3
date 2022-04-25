package repository.impl;

import model.SanPham;
import repository.BaseRepository;
import repository.SanPhamRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepositoryImpl implements SanPhamRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<SanPham> findAll() {
        List<SanPham> sanPhamList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from bang_san_pham");
            ResultSet resultSet=preparedStatement.executeQuery();
            SanPham sanPham;
            while (resultSet.next()){
                sanPham=new SanPham();
                sanPham.setId(resultSet.getInt("id"));
                sanPham.setName(resultSet.getString("name"));
                sanPham.setPrice(resultSet.getString("price"));
                sanPham.setQuantity(resultSet.getString("quantity"));
                sanPham.setColor(resultSet.getString("color"));
                sanPham.setId_cate(resultSet.getInt("id_cate"));
                sanPhamList.add(sanPham);
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
        return sanPhamList;
    }

    @Override
    public void save(SanPham sanPham) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB()
                    .prepareStatement("insert into bang_san_pham(`name`,price,quantity,color,id_cate) values (?,?,?,?,?);");
            preparedStatement.setString(1, sanPham.getName());
            preparedStatement.setDouble(2, Double.parseDouble(sanPham.getPrice()));
            preparedStatement.setString(3, sanPham.getQuantity());
            preparedStatement.setString(4, sanPham.getColor());
            preparedStatement.setInt(5, sanPham.getId_cate());
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
    public SanPham findById(Integer id) {
        SanPham sanPham  = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from bang_san_pham where id=?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String name;
            String price;
            String quantity;
            String color;
            Integer id_cate;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                price = resultSet.getString("price");
                quantity = resultSet.getString("quantity");
                color=resultSet.getString("color");
                id_cate=resultSet.getInt("id_cate");
                sanPham = new SanPham(id,name,price,quantity,color,id_cate);
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
        return sanPham;
    }

    @Override
    public boolean remove(Integer id) {
        boolean rowDel=false;
        try {
            CallableStatement callableStatement = baseRepository.getConnectionJavaToDB().prepareCall
                    ("{call sp_xoa_san_pham(?)}");
            callableStatement.setInt(1,id);
            rowDel = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDel;
    }
}
