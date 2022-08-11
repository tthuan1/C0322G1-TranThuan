package com.example.service.impl;

import com.example.model.TinTuc;
import com.example.repository.ITinTucRepository;
import com.example.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TinTucService implements ITinTucService {
    @Autowired
    private ITinTucRepository tinTucRepository;

    @Override
    public Page<TinTuc> findAll(String name, Pageable pageable) {
        return tinTucRepository.findAllTinTuc("%"+name+"%",pageable);
    }

    @Override
    public void save(TinTuc tinTuc) {
        tinTucRepository.save(tinTuc);
    }

    @Override
    public void remove(int maTinTuc) {
        tinTucRepository.remove(maTinTuc);
    }

    @Override
    public TinTuc findById(int maTinTuc) {
        return tinTucRepository.findById(maTinTuc).get();
    }

}
