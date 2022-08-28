package com.example.service;

import com.example.model.MedicalRecord;
import com.example.repository.IMedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService implements IMedicalRecordService{
    @Autowired
    private IMedicalRecordRepository medicalRecordRepository;
//    @Override
    public Page<MedicalRecord> findAll(Pageable pageable) {
        return medicalRecordRepository.findAll(pageable);
    }


    @Override
    public void save(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
    }
    @Override
    public void remove(int id) {
        medicalRecordRepository.deleteById(id);
    }

    @Override
    public List<MedicalRecord> findAll() {
        return medicalRecordRepository.findAll();
    }
    @Override
    public MedicalRecord findById(int id) {
        return medicalRecordRepository.findById(id).get();
    }

    @Override
    public void edit(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
    }

}
