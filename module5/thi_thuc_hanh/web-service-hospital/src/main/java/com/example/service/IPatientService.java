package com.example.service;

import com.example.model.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> findAll();

    void edit(Patient patient);

    Patient findById(int id);
}
