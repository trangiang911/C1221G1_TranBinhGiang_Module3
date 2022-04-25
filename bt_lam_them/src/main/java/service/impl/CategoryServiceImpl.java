package service.impl;

import model.Category;
import repository.CategoryRepository;
import repository.impl.CategoryRepositoryImpl;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository=new CategoryRepositoryImpl();
    @Override
    public List<Category> subFindAll() {
        List<Category> categoryList=categoryRepository.subFindPosition();
        return categoryList;
    }
}
