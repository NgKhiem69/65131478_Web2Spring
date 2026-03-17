package thiGK.ntu65131478;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import thiGK.ntu65131478.model.Student;

@Controller
@RequestMapping("/student")
public class studentController {

    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Nguyen Van A", 1));
        students.add(new Student(2, "Tran Thi B", 1));
        students.add(new Student(3, "Le Van C", 2));
    }

    // 🔹 LIST
    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", students);
        return "student-list";
    }

    // 🔹 VIEW
    @GetMapping("/view/{id}")
    public String viewStudent(@PathVariable int id, Model model) {
        for (Student s : students) {
            if (s.getId() == id) {
                model.addAttribute("student", s);
                break;
            }
        }
        return "student-view";
    }

    // 🔹 NEW (FORM)
    @GetMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student-new";
    }

    // 🔹 EDIT (FORM)
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable int id, Model model) {
        for (Student s : students) {
            if (s.getId() == id) {
                model.addAttribute("student", s);
                break;
            }
        }
        return "student-edit";
    }

    // 🔹 SAVE (ADD + UPDATE)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student s) {

        // nếu trùng id → update
        students.removeIf(st -> st.getId() == s.getId());

        students.add(s);

        return "redirect:/student/all";
    }

    // 🔹 DELETE
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        students.removeIf(s -> s.getId() == id);
        return "redirect:/student/all";
    }
}