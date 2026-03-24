package repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import thiGK.ntu65131478.model.Topic;
import thiGK.ntu65131478.model.Student;

@Service
public class MockData {

    public static List<Topic> topics = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();

    public MockData() {

        if (topics.isEmpty()) {
            topics.add(new Topic(1, "Web bán hàng", "Website bán hàng", 101, "Đồ án"));
            topics.add(new Topic(2, "Quản lý sinh viên", "QL sinh viên", 102, "Đề tài"));
            topics.add(new Topic(3, "Website tin tức", "Trang tin", 103, "Project"));
        }

        if (students.isEmpty()) {
            students.add(new Student(1, "Nguyen Van A", 1));
            students.add(new Student(2, "Tran Thi B", 1));
            students.add(new Student(3, "Le Van C", 2));
        }
    }
}