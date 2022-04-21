package repository.impl;

import model.employee.Division;
import model.service_model.RentType;
import repository.BaseRepository;
import repository.IDivisionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Division> subFindDivision() {
        List<Division> divisionList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from bo_phan");
            ResultSet resultSet=preparedStatement.executeQuery();
            Division division;
            while (resultSet.next()){
                division=new Division();
                division.setMaBoPhan(resultSet.getInt("ma_bo_phan"));
                division.setTenBoPhan(resultSet.getString("ten_bo_phan"));
                divisionList.add(division);
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
        return divisionList;    }
}
