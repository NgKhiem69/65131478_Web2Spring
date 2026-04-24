package thigk2.NguyenGiaKhiem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.NguyenGiaKhiem.entity.*;
import thigk2.NguyenGiaKhiem.repository.*;
import java.util.List;

@Service
public class TinService {
    @Autowired
    private TinRepository tinRepo;
    @Autowired
    private TheLoaiTinRepository theLoaiRepo;
    @Autowired
    private NguoiDungRepository userRepo;

    public List<TheLoaiTin> getAllTheLoai() {
        return theLoaiRepo.findAll();
    }

    public List<Tin> getAllTin() {
        return tinRepo.findAll();
    }

    public List<Tin> getTinByTheLoai(Long id) {
        return tinRepo.findByTheLoaiTin_Id(id);
    }

    public Tin getTinById(Long id) {
        return tinRepo.findById(id).orElse(null);
    }

    public NguoiDung login(String user, String pass) {
        return userRepo.findByUsernameAndPassword(user, pass);
    }
}