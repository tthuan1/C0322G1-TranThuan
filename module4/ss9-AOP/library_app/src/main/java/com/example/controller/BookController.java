package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping(value = {"book","/"})
    public String showBook(Model model, @PageableDefault(value = 2) Pageable pageable){
        Page<Book> bookList=bookService.findAll(pageable);
        model.addAttribute("bookList",bookList);
        return "list";
    }
}
