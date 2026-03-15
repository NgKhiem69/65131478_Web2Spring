package demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAPIController {

    @GetMapping("/")
    public String home() {
        return "Spring Boot running!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }
}