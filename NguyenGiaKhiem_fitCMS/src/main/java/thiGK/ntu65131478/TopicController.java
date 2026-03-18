package thiGK.ntu65131478;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import thiGK.ntu65131478.model.Topic;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    public static List<Topic> topics = new ArrayList<>();

    static {
        topics.add(new Topic(1, "Web bán hàng", "Website bán hàng", 101, "Đồ án"));
        topics.add(new Topic(2, "Quản lý sinh viên", "QL sinh viên", 102, "Đề tài"));
        topics.add(new Topic(3, "Website tin tức", "Trang tin", 103, "Project"));
    }

    // 🔹 GET ALL
    @GetMapping("/all")
    public List<Topic> getAllTopics(){
        return topics;
    }

    // 🔹 GET BY ID
    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable int id){
        for(Topic t : topics){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    // 🔹 ADD
    @PostMapping("/add")
    public Topic addTopic(@RequestBody Topic newT){
        topics.add(newT);
        return newT;
    }

    // 🔹 EDIT
    @PutMapping("/edit/{id}")
    public Topic editTopic(@PathVariable int id, @RequestBody Topic newT){

        for(Topic t : topics){
            if(t.getId() == id){
                t.setTopicName(newT.getTopicName());
                t.setTopicDescription(newT.getTopicDescription());
                t.setSupervisorId(newT.getSupervisorId());
                t.setTopicType(newT.getTopicType());
                return t;
            }
        }

        return null;
    }

    // 🔹 DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteTopic(@PathVariable int id){

        boolean removed = topics.removeIf(t -> t.getId() == id);

        if(removed){
            return "Deleted Topic ID: " + id;
        }

        return "Topic not found";
    }
}