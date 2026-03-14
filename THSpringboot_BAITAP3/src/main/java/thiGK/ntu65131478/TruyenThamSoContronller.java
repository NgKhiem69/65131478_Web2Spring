package thiGK.ntu65131478;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TruyenThamSoContronller {
	@GetMapping("/vidu3")
	public String showForm() {
		return "inForm";
	}
	
	@PostMapping("/input")
	public String handleForm(
			@RequestParam("mssv") String mssv,
            @RequestParam("hoten") String hoten,
            @RequestParam("namsinh") String namsinh,
            @RequestParam("gioitinh") String gioitinh,
            Model model) {
		
		model.addAttribute("mssv", mssv);
        model.addAttribute("hoten", hoten);
        model.addAttribute("namsinh", namsinh);
        model.addAttribute("gioitinh", gioitinh);
        
        return "outForm";
	}
}
