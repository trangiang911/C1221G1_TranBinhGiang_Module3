package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> productMap;
    static {
        productMap=new HashMap<>();
        productMap.put(1,new Product(1,"sửa",5000.0,"sửa","vinamilk"));
        productMap.put(2,new Product(2,"sửa",5000.0,"sửa","vinamilk"));
        productMap.put(3,new Product(3,"sửa",5000.0,"sửa","vinamilk"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(Integer id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList=new ArrayList<>();
        for (Map.Entry<Integer,Product> entry: productMap.entrySet()) {
            if(entry.getValue().getName().contains(name)){
                productList.add(entry.getValue());
            }
        }
        return productList;
    }
}
