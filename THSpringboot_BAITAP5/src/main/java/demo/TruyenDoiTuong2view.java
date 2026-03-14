package demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import models.SanPham;


@Controller
public class TruyenDoiTuong2view {
	@GetMapping("/vd5")
	public String hienThiSanPham(ModelMap model) {
		SanPham sp = new SanPham("SP001", "Laptop Dell XPS 15", 25000000);

		model.addAttribute("sanPham", sp);

		return "index";
	}
}

