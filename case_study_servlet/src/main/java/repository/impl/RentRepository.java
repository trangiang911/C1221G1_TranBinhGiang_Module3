package repository.impl;

import model.customer.TypeCustomer;
import model.service_model.RentType;
import repository.BaseRepository;
import repository.IRentRepository;
import service.IRentService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentRepository implements IRentRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<RentType> subFindRent() {
        List<RentType> rentTypes=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from kieu_thue");
            ResultSet resultSet=preparedStatement.executeQuery();
            RentType rentType;
            while (resultSet.next()){
                rentType=new RentType();
                rentType.setMaKieuThue(resultSet.getInt("ma_kieu_thue"));
                rentType.setTenKieuThue(resultSet.getString("ten_kieu_thue"));
                rentTypes.add(rentType);
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
        return rentTypes;
    }
}
