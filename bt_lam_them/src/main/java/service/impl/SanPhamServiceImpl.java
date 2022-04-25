package service.impl;

import model.SanPham;
import repository.SanPhamRepository;
import repository.impl.SanPhamRepositoryImpl;
import service.SanPhamService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SanPhamServiceImpl implements SanPhamService {
    SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();

    @Override
    public List<SanPham> findAll() {
        List<SanPham> sanPhamList = sanPhamRepository.findAll();
        return sanPhamList;
    }

    @Override
    public Map<String, String> save(SanPham sanPham) {
        Map<String, String> map = new HashMap<>();
        if (sanPham.getName().equals("")) {
            map.put("name", "Tên ko đc để trống");
        }
        if(map.isEmpty()){
        sanPhamRepository.save(sanPham);
        }
        return map;
    }

    @Override
    public SanPham findById(Integer id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public boolean remove(Integer id) {
        return sanPhamRepository.remove(id);
    }
}
