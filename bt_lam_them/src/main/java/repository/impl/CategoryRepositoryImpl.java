package repository.impl;

import model.Category;
import repository.BaseRepository;
import repository.CategoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Category> subFindPosition() {
        List<Category> categoryList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from category");
            ResultSet resultSet=preparedStatement.executeQuery();
            Category category;
            while (resultSet.next()){
                category=new Category();
                category.setId_cate(resultSet.getInt("id_cate"));
                category.setName(resultSet.getString("name"));
                categoryList.add(category);
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
        return categoryList;
    }
}
