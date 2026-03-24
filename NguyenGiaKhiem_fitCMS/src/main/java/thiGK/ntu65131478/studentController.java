package thiGK.ntu65131478;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import thiGK.ntu65131478.model.Student;
import repository.MockData;

@Controller
@RequestMapping("/student")
public class studentController {

    // 🔹 LIST
    @GetMapping("/all")
    public String listStudents(ModelMap model) {
        model.addAttribute("students", MockData.students);
        return "student-list";
    }

    // 🔹 DELETE
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        MockData.students.removeIf(s -> s.getId() == id);
        return "redirect:/student/all";
    }

    // 🔹 NEW FORM
    @GetMapping("/new")
    public String showNewStudentForm() {
        return "student-new";
    }

    // 🔹 ADD
    @PostMapping("/new")
    public String addNewStudent(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("groupId") int groupId
    ) {

        Student s = new Student(id, name, groupId);
        MockData.students.add(s);

        return "redirect:/student/all";
    }

    // 🔹 VIEW
    @GetMapping("/view/{id}")
    public String viewStudent(@PathVariable("id") int id, ModelMap model) {

        Student student = MockData.students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("student", student);

        return "student-view";
    }

    // 🔹 EDIT FORM
    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable("id") int id, ModelMap model) {

        Student student = MockData.students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("student", student);

        return "student-edit";
    }

    // 🔹 UPDATE
    @PostMapping("/edit")
    public String editStudent(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("groupId") int groupId
    ) {

        for (Student s : MockData.students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setGroupId(groupId);
                break;
            }
        }

        return "redirect:/student/all";
    }
}