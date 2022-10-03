package com.sprint2.demo.controller;

import com.sprint2.demo.models.Author;
import com.sprint2.demo.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/author")
@RestController
public class AuthorController {
    @Autowired
    private IAuthorService iAuthorService;

    @GetMapping(value = "")
    public ResponseEntity<List<Author>> getAuthor() {
        List<Author> authors = this.iAuthorService.findAllAuthor();
        if (authors == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
