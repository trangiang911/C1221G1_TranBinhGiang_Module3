package services;

import model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Integer id, Product product);

    void remove(Integer id);

    List<Product> search(String name);
}
