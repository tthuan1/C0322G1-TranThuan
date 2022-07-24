package com.example.song.service;

import com.example.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    void save(Song song);
}
