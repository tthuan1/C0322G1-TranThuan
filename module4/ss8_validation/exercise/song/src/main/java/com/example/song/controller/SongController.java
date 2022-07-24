package com.example.song.controller;

import com.example.song.dto.SongDto;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String showAll(Pageable pageable, Model model){
        Page<Song> songList = songService.findAll(pageable);
        model.addAttribute("songList",songList);
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute(new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("messSave","Save or Update Successfully!");
        return "redirect:/";
    }
}
