package thigk2.NguyenGiaKhiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thigk2.NguyenGiaKhiem.entity.*;
import thigk2.NguyenGiaKhiem.service.TinService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TinRestController {
    @Autowired
    private TinService tinService;

    @GetMapping("/theloai")
    public List<TheLoaiTin> getTheLoai() {
        return tinService.getAllTheLoai();
    }

    @GetMapping("/tin/theloai/{id}")
    public List<Tin> getTinByTheLoai(@PathVariable Long id) {
        return tinService.getTinByTheLoai(id);
    }
}