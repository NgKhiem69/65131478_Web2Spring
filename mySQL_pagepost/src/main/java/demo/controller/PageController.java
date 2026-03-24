package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import demo.model.Page;
import demo.repository.PageRepository;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private PageRepository pageRepository;


    @GetMapping("/all")
    public String listPages(Model model) {
        model.addAttribute("pages", pageRepository.findAll());
        return "pagelist"; 
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("page", new Page());
        return "pageadd"; 
    }

    @GetMapping("/view/{id}")
    public String viewPage(@PathVariable("id") Long id, Model model) {
        Page page = pageRepository.findById(id).orElse(null);
        model.addAttribute("page", page);
        return "pageview"; 
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