package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class helloSpringbootController {
	@GetMapping("/") // Nếu người dùng request tới địa chỉ "/"
    public String index() {
        return "index"; // Trả về file index.html
    }
}
