package thiGK.ntu65131478;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import repository.MockData;

@Controller
public class HomeContronller {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("ten", "khiem");

        // ⚠️ QUAN TRỌNG
        model.addAttribute("topics", MockData.topics);
        model.addAttribute("students", MockData.students);

        model.addAttribute("page", "topic");

        return "index";
    }
}