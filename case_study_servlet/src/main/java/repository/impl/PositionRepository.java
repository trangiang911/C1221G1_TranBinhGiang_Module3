package repository.impl;

import model.employee.Position;
import model.service_model.RentType;
import repository.BaseRepository;
import repository.IPosititonRepossitory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPosititonRepossitory {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Position> subFindPosition() {
        List<Position> positionList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from vi_tri");
            ResultSet resultSet=preparedStatement.executeQuery();
            Position position;
            while (resultSet.next()){
                position=new Position();
                position.setMaViTri(resultSet.getInt("ma_vi_tri"));
                position.setTenViTri(resultSet.getString("ten_vi_tri"));
                positionList.add(position);
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
        return positionList;
    }
}
