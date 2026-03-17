package thiGK.ntu65131478;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import thiGK.ntu65131478.model.Topic;

@Controller
@RequestMapping("/topic")
public class TopicController {

    public static ArrayList<Topic> topics = new ArrayList<>();

    public TopicController() {
        if(topics.isEmpty()){
            topics.add(new Topic(1, "Web bán hàng", "Website bán hàng", 101, "Đồ án"));
            topics.add(new Topic(2, "Quản lý sinh viên", "QL sinh viên", 102, "Đề tài"));
            topics.add(new Topic(3, "Website tin tức", "Trang tin", 103, "Project"));
        }
    }

    // 🔹 LIST
    @GetMapping("/all")
    public String topicList(Model model){
        model.addAttribute("topics", topics);
        return "topic-list"; // ⚠️ phải đúng tên file HTML
    }

    // 🔹 VIEW
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model){
        for(Topic t : topics){
            if(t.getId()==id){
                model.addAttribute("topic", t);
            }
        }
        return "topic-view";
    }

    // 🔹 NEW
    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("topic", new Topic());
        return "topic-new";
    }

    // 🔹 EDIT
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        for(Topic t : topics){
            if(t.getId()==id){
                model.addAttribute("topic", t);
            }
        }
        return "topic-edit";
    }

    // 🔹 SAVE (ADD + EDIT)
    @PostMapping("/save")
    public String save(@ModelAttribute Topic newT){

        boolean found = false;

        for(Topic t : topics){
            if(t.getId() == newT.getId()){
                t.setTopicName(newT.getTopicName());
                t.setTopicDescription(newT.getTopicDescription());
                t.setSupervisorId(newT.getSupervisorId());
                t.setTopicType(newT.getTopicType());
                found = true;
            }
        }

        if(!found){
            topics.add(newT);
        }

        return "redirect:/topic/all";
    }

    // 🔹 DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        topics.removeIf(t -> t.getId()==id);
        return "redirect:/topic/all";
    }
}