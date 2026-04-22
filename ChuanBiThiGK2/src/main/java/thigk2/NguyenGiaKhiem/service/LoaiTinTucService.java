package thigk2.NguyenGiaKhiem.service;

import thigk2.NguyenGiaKhiem.model.LoaiTinTuc;
import thigk2.NguyenGiaKhiem.reponsitory.LoaiTinTucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiTinTucService {

    @Autowired
    private LoaiTinTucRepository loaiTinTucRepository;

    // Lấy danh sách tất cả loại tin
    public List<LoaiTinTuc> getAllLoai() {
        return loaiTinTucRepository.findAll();
    }

    // Lưu thêm mới hoặc cập nhật
    public void save(LoaiTinTuc loaiTinTuc) {
        loaiTinTucRepository.save(loaiTinTuc);
    }

    // Lấy loại tin theo ID
    public LoaiTinTuc getById(Integer id) {
        return loaiTinTucRepository.findById(id).orElse(null);
    }

    // Xóa loại tin theo ID
    public void delete(Integer id) {
        loaiTinTucRepository.deleteById(id);
    }
}