package thigk2.NguyenGiaKhiem.controller;

import thigk2.NguyenGiaKhiem.service.TinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private TinTucService tinTucService;

    @GetMapping("/")
    public String homePage(Model model) {
        // Lấy danh sách tin tức hiển thị ra trang chủ
        model.addAttribute("tinTucMoiNhat", tinTucService.getAllTinTuc());
        return "index"; // Trả về file src/main/resources/templates/index.html
    }
}