package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public ModelAndView showBlog(@PageableDefault(value = 2,sort = "year",direction = Sort.Direction.DESC )Pageable pageable) {
        Page<Blog> blogList=blogService.findAll(pageable);
        return new ModelAndView("index", "blogList", blogList);
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",categoryService.findAllCategory());
        return "create";
    }

    @PostMapping("/create")
    public String showCreate(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList",categoryService.findAllCategory());
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Blog blog) {
        blogService.edit(blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "view";
    }


}
