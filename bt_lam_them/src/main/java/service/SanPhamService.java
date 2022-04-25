package service;

import model.SanPham;

import java.util.List;
import java.util.Map;

public interface SanPhamService {
    List<SanPham> findAll();

    Map<String, String> save(SanPham sanPham);

    SanPham findById(Integer id);

    boolean remove(Integer id);
}
