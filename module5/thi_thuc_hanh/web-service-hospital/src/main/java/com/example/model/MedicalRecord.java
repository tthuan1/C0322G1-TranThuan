package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hospitalizedDay;
    private String hospitalDischargeDate;
    private String reason;
    private String treatments;
    private String doctor;
    @ManyToOne
    @JoinColumn(name = "patient",referencedColumnName = "id")
    private Patient patient;

    public MedicalRecord() {
    }

    public MedicalRecord(Integer id, String hospitalizedDay, String hospitalDischargeDate, String reason, String treatments, String doctor, Patient patient) {
        this.id = id;
        this.hospitalizedDay = hospitalizedDay;
        this.hospitalDischargeDate = hospitalDischargeDate;
        this.reason = reason;
        this.treatments = treatments;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospitalizedDay() {
        return hospitalizedDay;
    }

    public void setHospitalizedDay(String hospitalizedDay) {
        this.hospitalizedDay = hospitalizedDay;
    }

    public String getHospitalDischargeDate() {
        return hospitalDischargeDate;
    }

    public void setHospitalDischargeDate(String hospitalDischargeDate) {
        this.hospitalDischargeDate = hospitalDischargeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
