package thigk2.NguyenGiaKhiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thigk2.NguyenGiaKhiem.service.TinService;

@Controller
public class TinController {
    @Autowired
    private TinService tinService;

    @GetMapping("/tin")
    public String index(Model model) {
        model.addAttribute("listTin", tinService.getAllTin());
        model.addAttribute("listTheLoai", tinService.getAllTheLoai());
        return "index";
    }

    @GetMapping("/tin/theloai")
    public String filterByTheLoai(@RequestParam("id") Long id, Model model) {
        model.addAttribute("listTin", tinService.getTinByTheLoai(id));
        model.addAttribute("listTheLoai", tinService.getAllTheLoai());
        return "index";
    }

    @GetMapping("/tin/chitiet/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("tin", tinService.getTinById(id));
        return "detail";
    }
}