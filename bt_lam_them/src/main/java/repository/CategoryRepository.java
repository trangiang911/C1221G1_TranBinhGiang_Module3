package repository;

import model.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository {
    List<Category> subFindPosition();
}
