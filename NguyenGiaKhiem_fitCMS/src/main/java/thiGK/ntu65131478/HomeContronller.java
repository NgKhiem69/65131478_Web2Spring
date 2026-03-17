package thiGK.ntu65131478;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeContronller {

    @GetMapping("/")
    public String home(@RequestParam(value = "page", required = false, defaultValue = "topic") String page,
                       Model model) {

        model.addAttribute("ten", "khiem tới chơi nè bro");


        model.addAttribute("topics", TopicController.topics);
        model.addAttribute("students", studentController.students);


        model.addAttribute("page", page);

        return "index";
    }
}