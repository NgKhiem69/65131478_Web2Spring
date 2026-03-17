package thiGK.ntu65131478;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import thiGK.ntu65131478.model.Topic;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    public static List<Topic> topics = new ArrayList<>();

    public TopicController() {
        topics.add(new Topic(1, "Web bán hàng", "Website bán hàng", 101, "Đồ án"));
        topics.add(new Topic(2, "Quản lý sinh viên", "QL sinh viên", 102, "Đề tài"));
        topics.add(new Topic(3, "Website tin tức", "Trang tin", 103, "Project"));
    }

    // 🔹 GET ALL
    @GetMapping("/all")
    public List<Topic> getAllTopics() {
        return topics;
    }

    // 🔹 ADD
    @PostMapping("/add")
    public Topic addTopic(@RequestBody Topic t) {
        topics.add(t);
        return t;
    }

    // 🔹 EDIT
    @PutMapping("/edit/{id}")
    public Topic editTopic(@PathVariable("id") int id, @RequestBody Topic newT) {
        for (Topic t : topics) {
            if (t.getId() == id) {
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
    public String deleteTopic(@PathVariable("id") int id) {
        boolean isRemoved = topics.removeIf(t -> t.getId() == id);
        if (isRemoved) {
            return "Đã xóa Topic ID: " + id;
        } else {
            return "Không tìm thấy Topic ID: " + id;
        }
    }
}