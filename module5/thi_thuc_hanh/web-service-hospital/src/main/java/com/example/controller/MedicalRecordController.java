package com.example.controller;


import com.example.model.MedicalRecord;
import com.example.model.Patient;
import com.example.service.IMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalRecord")
@CrossOrigin(origins = "*")
public class MedicalRecordController {

    @Autowired
    private IMedicalRecordService medicalRecordService;

    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getMedicalRecordList() {
        List<MedicalRecord> medicalRecordList = medicalRecordService.findAll();
        if (medicalRecordList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalRecordList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getId(@PathVariable int id) {
        MedicalRecord medicalRecord = medicalRecordService.findById(id);
        if (medicalRecord == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicalRecord> addBlog(@RequestBody MedicalRecord blog) {
        System.out.print(blog);
        medicalRecordService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<MedicalRecord> deleteBlog(@PathVariable int id) {
        System.err.print(id);
        medicalRecordService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicalRecord> edit(@RequestBody MedicalRecord medicalRecord) {
        System.err.println(medicalRecord.getPatient());
        medicalRecordService.edit(medicalRecord);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
