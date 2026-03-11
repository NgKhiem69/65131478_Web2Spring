package thiGK.ntu65131478;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import thiGK.ntu65131478.model.Topic;

@Controller
@RequestMapping("/topic")
public class TopicController {

    ArrayList<Topic> dsTopic = new ArrayList<>();

    public TopicController() {

        dsTopic.add(new Topic(1,"Web bán hàng","Website bán hàng",101,"Đồ án"));
        dsTopic.add(new Topic(2,"Quản lý sinh viên","QL sinh viên",102,"Đề tài"));
        dsTopic.add(new Topic(3,"Website tin tức","Trang tin",103,"Project"));

    }

    // Topic List
    @GetMapping("/all")
    public String topicList(Model model){
        model.addAttribute("topics", dsTopic);
        return "index";
    }

    // Topic View
    @GetMapping("/view/{id}")
    public String viewTopic(@PathVariable int id, Model model){

        for(Topic t : dsTopic){
            if(t.getId()==id){
                model.addAttribute("topic", t);
            }
        }

        return "topic-view";
    }

    // Topic Add Form
    @GetMapping("/new")
    public String newTopic(Model model){
        model.addAttribute("topic", new Topic());
        return "topic-new";
    }

    // Save Topic
    @PostMapping("/save")
    public String saveTopic(@ModelAttribute Topic t){

        dsTopic.add(t);

        return "redirect:/topic/all";
    }

    // Delete Topic
    @GetMapping("/delete/{id}")
    public String deleteTopic(@PathVariable int id){

        dsTopic.removeIf(t -> t.getId()==id);

        return "redirect:/topic/all";
    }

}