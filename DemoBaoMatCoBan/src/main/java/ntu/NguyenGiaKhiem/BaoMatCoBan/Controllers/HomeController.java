package ntu.NguyenGiaKhiem.BaoMatCoBan.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "HomePage";
	}
	@GetMapping("/admincp/")
	public String indexAd() {
		return "indexAdmin";
	}
	
	@GetMapping("/products/")
	public String indexUs() {
		return "indexUser";
	}
}
