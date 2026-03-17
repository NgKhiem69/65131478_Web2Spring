package thiGK.ntu65131478;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContronller {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("ten", "khiêm"); // tên hiển thị
        return "index"; // trả về index.html
    }
}