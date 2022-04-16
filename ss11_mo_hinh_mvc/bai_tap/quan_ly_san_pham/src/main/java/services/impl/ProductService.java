package services.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import services.IProductService;

import java.util.List;


public class ProductService implements IProductService {
private IProductRepository iProductRepository= new ProductRepository();
    @Override
    public List<Product> findAll() {
        List<Product> productList=iProductRepository.findAll();
        return productList;
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        iProductRepository.update(id,product);
    }

    @Override
    public void remove(Integer id) {
        iProductRepository.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList=iProductRepository.search(name);
        return productList;
    }
}
