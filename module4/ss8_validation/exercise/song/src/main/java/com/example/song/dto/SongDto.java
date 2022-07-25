package com.example.song.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SongDto implements Validator {
    private Integer id;
    @NotEmpty
    @NotNull
    @Pattern(regexp = "^[a-z]$",message = "lỗi nhập sai")
    private String name;
    @Pattern(regexp = "^(\\w\\s?){0,299}\\w$",message = "lỗi nhập sai")

    private String artist;
    @Pattern(regexp = "^(\\w,?\\s?){0,999}\\w$",message = "lỗi nhập sai")

    private String genre;

    public SongDto() {
    }

    public SongDto(Integer id, String name, String artist, String genre) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
