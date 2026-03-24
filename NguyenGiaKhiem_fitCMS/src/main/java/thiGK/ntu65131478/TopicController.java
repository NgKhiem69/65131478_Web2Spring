package thiGK.ntu65131478;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import thiGK.ntu65131478.model.Topic;
import repository.MockData;

@Controller
@RequestMapping("/topic")
public class TopicController {

    // 🔹 LIST
    @GetMapping("/all")
    public String listTopics(ModelMap model) {
        model.addAttribute("topics", MockData.topics);
        return "topic-list";
    }

    // 🔹 DELETE
    @GetMapping("/delete/{id}")
    public String deleteTopic(@PathVariable("id") int id) {
        MockData.topics.removeIf(t -> t.getId() == id);
        return "redirect:/topic/all";
    }

    // 🔹 NEW FORM
    @GetMapping("/new")
    public String showNewForm() {
        return "topic-new";
    }

    // 🔹 ADD
    @PostMapping("/new")
    public String addTopic(
            @RequestParam("id") int id,
            @RequestParam("topicName") String topicName,
            @RequestParam("topicDescription") String topicDescription,
            @RequestParam("supervisorId") int supervisorId,
            @RequestParam("topicType") String topicType
    ) {

        Topic t = new Topic(id, topicName, topicDescription, supervisorId, topicType);
        MockData.topics.add(t);

        return "redirect:/topic/all";
    }

    // 🔹 VIEW
    @GetMapping("/view/{id}")
    public String viewTopic(@PathVariable("id") int id, ModelMap model) {

        Topic topic = MockData.topics.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("topic", topic);

        return "topic-view";
    }

    // 🔹 EDIT FORM
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, ModelMap model) {

        Topic topic = MockData.topics.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("topic", topic);

        return "topic-edit";
    }

    // 🔹 UPDATE
    @PostMapping("/edit")
    public String editTopic(
            @RequestParam("id") int id,
            @RequestParam("topicName") String topicName,
            @RequestParam("topicDescription") String topicDescription,
            @RequestParam("supervisorId") int supervisorId,
            @RequestParam("topicType") String topicType
    ) {

        for (Topic t : MockData.topics) {
            if (t.getId() == id) {
                t.setTopicName(topicName);
                t.setTopicDescription(topicDescription);
                t.setSupervisorId(supervisorId);
                t.setTopicType(topicType);
                break;
            }
        }

        return "redirect:/topic/all";
    }
}