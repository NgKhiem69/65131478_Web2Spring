package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import model.Post;
import repository.PostRepository;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/all")
    public String listPosts(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "post/list"; 
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/add"; 
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post) {
        postRepository.save(post);
        return "redirect:/post/all";
    }

    @GetMapping("/view/{id}")
    public String viewPost(@PathVariable("id") Long id, Model model) {
        Post post = postRepository.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "post/view";
    }
   
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        postRepository.deleteById(id);
        return "redirect:/post/all";
    }
}