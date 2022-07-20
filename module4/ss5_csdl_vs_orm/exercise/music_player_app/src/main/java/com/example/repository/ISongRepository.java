package com.example.repository;

import com.example.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void edit(Song song);

    void delete(Song song);
}
