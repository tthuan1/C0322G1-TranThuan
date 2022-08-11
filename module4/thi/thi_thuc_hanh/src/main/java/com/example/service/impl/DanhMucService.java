package com.example.service.impl;

import com.example.model.DanhMuc;
import com.example.repository.IDanhMucRepository;
import com.example.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService implements IDanhMucService {
    @Autowired
    private IDanhMucRepository danhMucRepository;

    @Override
    public List<DanhMuc> findAll() {
        return danhMucRepository.findAll();
    }
}
