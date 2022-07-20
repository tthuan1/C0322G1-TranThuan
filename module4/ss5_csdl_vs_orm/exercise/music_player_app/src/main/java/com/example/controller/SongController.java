package com.example.controller;

import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("/home")
    public String display(Model model){
        List<Song> songList=songService.findAll();
        model.addAttribute("songList",songList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Song song) {
        songService.save(song);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Song song= songService.findById(id);
        model.addAttribute("song", song);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Song song) {
        songService.edit(song);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        Song song= songService.findById(id);
        model.addAttribute("song", song);
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Song song) {
        songService.delete(song);
        return "redirect:/home";
    }

    @GetMapping("/delete1/{id}")
    public String delete1(@PathVariable int id) {
        songService.delete(songService.findById(id));
        return "redirect:/home";
    }
}
