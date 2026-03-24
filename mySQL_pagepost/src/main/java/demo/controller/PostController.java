package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import demo.model.Post;
import demo.repository.PostRepository;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/all")
    public String listPosts(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "postlist"; 
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("post", new Post());
        return "postadd"; 
    }

    @GetMapping("/view/{id}")
    public String viewPost(@PathVariable("id") Long id, Model model) {
        Post post = postRepository.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "postview"; 
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post) {
        postRepository.save(post);
        return "redirect:/post/all";
    }

   
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        postRepository.deleteById(id);
        return "redirect:/post/all";
    }
}