package services.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import services.IProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> getListProduct() {
        List<Product> productList = iProductRepository.getList();
        return productList;
    }

    @Override
    public Map<String, String> save(Product product) {
        Map<String, String> map = new HashMap<>();
        if (product.getName().equals("")) {
            map.put("name", "Tên ko để trống");
        } else if (!product.getName().matches("^[a-zA-Z ]+$")) {
            map.put("name", "Tên ko hợp lệ");
        }
        if (map.isEmpty()) {
            iProductRepository.save(product);
        }
        return map;
    }

    @Override
    public Map<String, String> edit(Product product) {
        Map<String, String> map = new HashMap<>();
        if (product.getName().equals("")) {
            map.put("name", "Tên ko để trống");
        } else if (!product.getName().matches("^[a-zA-Z ]+$")) {
            map.put("name", "Tên ko hợp lệ");
        }
        if (map.isEmpty()) {
            iProductRepository.edit(product);
        }
        return map;
    }


}
