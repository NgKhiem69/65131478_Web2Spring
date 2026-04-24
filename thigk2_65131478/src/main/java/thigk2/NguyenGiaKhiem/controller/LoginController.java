package thigk2.NguyenGiaKhiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import thigk2.NguyenGiaKhiem.service.TinService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private TinService tinService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (tinService.login(username, password) != null) {
            session.setAttribute("user", username);
            return "redirect:/tin";
        }
        return "login";
    }
}