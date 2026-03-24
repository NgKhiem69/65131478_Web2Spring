package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import model.Page;
import repository.PageRepository;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private PageRepository pageRepository;


    @GetMapping("/all")
    public String listPages(Model model) {
        model.addAttribute("pages", pageRepository.findAll());
        return "page/list"; 
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("page", new Page());
        return "page/add"; 
    }

    @PostMapping("/save")
    public String savePage(@ModelAttribute("page") Page page) {
        pageRepository.save(page);
        return "redirect:/page/all";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") Long id) {
        pageRepository.deleteById(id);
        return "redirect:/page/all";
    }
}