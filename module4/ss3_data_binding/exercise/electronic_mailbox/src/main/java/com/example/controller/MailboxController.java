package com.example.controller;

import com.example.model.Mailbox;
import com.example.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailboxController {

    @Autowired
    private IMailboxService mailboxService;

    @GetMapping("/mailbox")
    public String showMailbox(Model model) {
        Mailbox mailbox = mailboxService.list();
        model.addAttribute("mailbox", mailbox);
        return "/mailbox/show";
    }

    @GetMapping("/setting")
    public String showSetting(Model model) {
        Mailbox mailbox = mailboxService.list();
        model.addAttribute("mailbox", mailbox);
        return "/mailbox/setting";
    }

    @PostMapping("/setting")
    public String setting(@ModelAttribute  Mailbox mailbox, Model model) {
        mailboxService.update(mailbox);
        model.addAttribute("message", "update successful !!");
        return "/mailbox/show";
    }
}
