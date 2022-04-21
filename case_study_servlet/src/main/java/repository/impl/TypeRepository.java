package repository.impl;

import model.customer.TypeCustomer;
import model.service_model.TypeService;
import repository.BaseRepository;
import repository.ITypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeRepository implements ITypeRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<TypeService> subFindType() {
        List<TypeService> typeServiceList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from loai_dich_vu");
            ResultSet resultSet=preparedStatement.executeQuery();
            TypeService typeService;
            while (resultSet.next()){
                typeService=new TypeService();
                typeService.setMaLoaiDichVu(resultSet.getInt("ma_loai_dich_vu"));
                typeService.setTenLoaiDichVu(resultSet.getString("ten_loai_dich_vu"));
                typeServiceList.add(typeService);
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
        return typeServiceList;
    }
}
