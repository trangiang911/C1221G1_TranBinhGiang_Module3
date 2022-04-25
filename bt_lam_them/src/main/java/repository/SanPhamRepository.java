package repository;

import model.SanPham;

import java.util.List;

public interface SanPhamRepository extends CrudRepository {
    List<SanPham> findAll();

    void save(SanPham sanPham);

    SanPham findById(Integer id);

    boolean remove(Integer id);
}
