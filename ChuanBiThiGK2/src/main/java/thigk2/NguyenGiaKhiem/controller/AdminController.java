package thigk2.NguyenGiaKhiem.controller;

import thigk2.NguyenGiaKhiem.model.TinTuc;
import thigk2.NguyenGiaKhiem.service.LoaiTinTucService;
import thigk2.NguyenGiaKhiem.service.TinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/tintuc")
public class AdminController {

    @Autowired
    private TinTucService tinTucService;
    
    @Autowired
    private LoaiTinTucService loaiTinTucService;

    // Read - Hiển thị danh sách
    @GetMapping
    public String listTinTuc(Model model) {
        model.addAttribute("listTinTuc", tinTucService.getAllTinTuc());
        return "admin/tintuc-list"; // Trả về file src/main/resources/templates/admin/tintuc-list.html
    }

    // Create - Hiển thị form thêm
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("tintuc", new TinTuc());
        model.addAttribute("listLoai", loaiTinTucService.getAllLoai());
        return "admin/tintuc-form"; 
    }

    // Save (Dùng cho cả Create và Update)
    @PostMapping("/save")
    public String saveTinTuc(@ModelAttribute("tintuc") TinTuc tinTuc) {
        tinTucService.save(tinTuc);
        return "redirect:/admin/tintuc";
    }

    // Update - Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("tintuc", tinTucService.getById(id));
        model.addAttribute("listLoai", loaiTinTucService.getAllLoai());
        return "admin/tintuc-form";
    }

    // Delete - Xóa tin tức
    @GetMapping("/delete/{id}")
    public String deleteTinTuc(@PathVariable("id") Integer id) {
        tinTucService.delete(id);
        return "redirect:/admin/tintuc";
    }
}