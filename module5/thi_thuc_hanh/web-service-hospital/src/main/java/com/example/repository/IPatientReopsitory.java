package com.example.repository;

import com.example.model.MedicalRecord;
import com.example.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientReopsitory extends JpaRepository<Patient, Integer> {
}
