package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
    private Set<MedicalRecord> medicalRecord;

    public Patient() {
    }

    public Patient(Integer id, String name, Set<MedicalRecord> medicalRecord) {
        this.id = id;
        this.name = name;
        this.medicalRecord = medicalRecord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MedicalRecord> getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(Set<MedicalRecord> medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}
