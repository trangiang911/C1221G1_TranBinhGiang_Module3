package repository.impl;

import model.employee.Division;
import model.employee.Education;
import repository.BaseRepository;
import repository.IEducationRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationRepository implements IEducationRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Education> subFindDivision() {
        List<Education> educationList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from trinh_do");
            ResultSet resultSet=preparedStatement.executeQuery();
            Education education;
            while (resultSet.next()){
                education=new Education();
                education.setMaTringDo(resultSet.getInt("ma_trinh_do"));
                education.setTenTrinhDo(resultSet.getString("ten_trinh_do"));
                educationList.add(education);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        return educationList;    }
    }
}
