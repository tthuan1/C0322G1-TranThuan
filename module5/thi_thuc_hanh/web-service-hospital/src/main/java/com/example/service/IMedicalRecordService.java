package com.example.service;

import com.example.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMedicalRecordService {
    

    void save(MedicalRecord blog);

    void remove(int id);

    List<MedicalRecord> findAll();
}
