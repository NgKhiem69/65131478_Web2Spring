package thiGK.ntu65131478;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import thiGK.ntu65131478.model.Topic;
import thiGK.ntu65131478.model.Student;
import repository.MockData;

@RestController
@RequestMapping("/api")
public class APIController {

    // ===================== TOPIC =====================

    @GetMapping("/topic/all")
    public List<Topic> getAllTopics() {
        return MockData.topics;
    }

    @PostMapping("/topic/add")
    public Topic addTopic(@RequestBody Topic newTopic) {
        MockData.topics.add(newTopic);
        return newTopic;
    }

    @PutMapping("/topic/edit/{id}")
    public Topic editTopic(@PathVariable("id") int id, @RequestBody Topic updatedTopic) {

        for (Topic t : MockData.topics) {
            if (t.getId() == id) {
                t.setTopicName(updatedTopic.getTopicName());
                t.setTopicDescription(updatedTopic.getTopicDescription());
                t.setSupervisorId(updatedTopic.getSupervisorId());
                t.setTopicType(updatedTopic.getTopicType());
                return t;
            }
        }

        return null;
    }

    @DeleteMapping("/topic/delete/{id}")
    public String deleteTopic(@PathVariable("id") int id) {

        boolean isRemoved = MockData.topics.removeIf(t -> t.getId() == id);

        if (isRemoved) {
            return "Đã xóa Topic ID: " + id;
        } else {
            return "Không tìm thấy Topic ID: " + id;
        }
    }

    // ===================== STUDENT =====================

    @GetMapping("/student/all")
    public List<Student> getAllStudents() {
        return MockData.students;
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student newStudent) {
        MockData.students.add(newStudent);
        return newStudent;
    }

    @PutMapping("/student/edit/{id}")
    public Student editStudent(@PathVariable("id") int id, @RequestBody Student updatedStudent) {

        for (Student s : MockData.students) {
            if (s.getId() == id) {
                s.setName(updatedStudent.getName());
                s.setGroupId(updatedStudent.getGroupId());
                return s;
            }
        }

        return null;
    }

    @DeleteMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {

        boolean isRemoved = MockData.students.removeIf(s -> s.getId() == id);

        if (isRemoved) {
            return "Đã xóa Student ID: " + id;
        } else {
            return "Không tìm thấy Student ID: " + id;
        }
    }
}