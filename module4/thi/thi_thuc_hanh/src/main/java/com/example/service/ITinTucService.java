package com.example.service;

import com.example.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITinTucService {
    Page<TinTuc> findAll(String search, Pageable pageable);

    void save(TinTuc tinTuc);

    void remove(int maTinTuc);

    TinTuc findById(int maTinTuc);
}
