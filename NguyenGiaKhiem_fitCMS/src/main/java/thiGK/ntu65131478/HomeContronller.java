package thiGK.ntu65131478;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContronller {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("ten", "Khiêm tới chơi nè bro");

        
        model.addAttribute("topics", TopicController.topics);

        return "index";
    }
}