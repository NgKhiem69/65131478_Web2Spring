package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class SinhVienController {
	@GetMapping("/sinhvien")
	public String sinhVienInfo(Model model) {
        model.addAttribute("mssv", "65134116");
        model.addAttribute("hoten", "Nguyễn Huỳnh Tường");
        model.addAttribute("namsinh", "2005");
        model.addAttribute("gioitinh", "Nam");
        
        return "sinhVienView";
	}
}