package thiGK.ntu65131478;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import thiGK.ntu65131478.model.Student;

@RestController
@RequestMapping("/api/student")
public class studentController {

    public static List<Student> students = new ArrayList<>();

    public studentController() {
        students.add(new Student(1, "Nguyen Van A", 1));
        students.add(new Student(2, "Tran Thi B", 1));
        students.add(new Student(3, "Le Van C", 2));
    }

    // 🔹 GET ALL
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return students;
    }

    // 🔹 ADD
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student s) {
        students.add(s);
        return s;
    }

    // 🔹 EDIT
    @PutMapping("/edit/{id}")
    public Student editStudent(@PathVariable("id") int id, @RequestBody Student newS) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newS.getName());
                s.setGroupId(newS.getGroupId());
                return s;
            }
        }
        return null;
    }

    // 🔹 DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        boolean isRemoved = students.removeIf(s -> s.getId() == id);
        if (isRemoved) {
            return "Đã xóa Student ID: " + id;
        } else {
            return "Không tìm thấy Student ID: " + id;
        }
    }
}