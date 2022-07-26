package com.example.controller;

import com.example.model.Book;
import com.example.model.Borrower;
import com.example.service.IBookService;
import com.example.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowerService borrowerService;

    @GetMapping(value = {"book","/"})
    public String showBook(Model model, @PageableDefault(value = 10) Pageable pageable){
        Page<Book> bookList=bookService.findAll(pageable);
        model.addAttribute("bookList",bookList);
        return "list";
    }

    @GetMapping("/borrow/{id}")
    private String showBorrowBook(@PathVariable int id,Model model){
        Book book=bookService.findById(id);
        model.addAttribute("book",book);
        return "borrow";
    }

    @PostMapping("/borrow")
    private String borrowBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes){
        int code= (int) (Math.random() * 1000);
        borrowerService.saveBorrower(code,book.getId());
        bookService.borrow(book);
        redirectAttributes.addFlashAttribute("mess","Mượn sách "+book.getName()+" thành công mã mượn sách của bạn là: "+code);
        return "redirect:/";
    }

    @GetMapping("/repay/{id}")
    private String showRepay(@PathVariable int id,Model model){
        Book book=bookService.findById(id);
        model.addAttribute("borrower",new Borrower());
        model.addAttribute("book",book);
        return "repay";
    }
    @PostMapping("/repay")
    private String repay(@RequestParam("code") Integer code,@ModelAttribute Book book,RedirectAttributes redirectAttributes){
        List<Borrower> borrowerList=borrowerService.findByCode(code);
        if (borrowerList.isEmpty()){
            redirectAttributes.addFlashAttribute("mess","mã không đúng!");
        }else {
            bookService.repay(book);
            borrowerService.repay(code);
            redirectAttributes.addFlashAttribute("mess","Trả sách thành công!");
        }
        return "redirect:/";
    }
}
