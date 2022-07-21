package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView showContent(){
        return new ModelAndView("index", "blogList", blogService.findAll());
    }
    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String showCreate(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id,Model model){
        Blog blog=blogService.findById(id);
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Blog blog){
        blogService.edit(blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id,Model model){
        Blog blog=blogService.findById(id);
        model.addAttribute("blog", blog);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@ModelAttribute Blog blog){
        blogService.delete(blog.getId());
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id,Model model){
        Blog blog=blogService.findById(id);
        model.addAttribute("blog", blog);
        return "view";
    }


}
