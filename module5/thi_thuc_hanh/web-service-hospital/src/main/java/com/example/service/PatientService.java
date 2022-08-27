package com.example.service;

import com.example.model.Patient;
import com.example.repository.IPatientReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService{
    @Autowired
    private IPatientReopsitory patientReopsitory;

    @Override
    public List<Patient> findAll() {
        return patientReopsitory.findAll();
    }
}
