package com.example.controller;

import com.example.model.Patient;
import com.example.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getPatientList() {
        List<Patient> patientList = patientService.findAll();
        if (patientList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }
}
