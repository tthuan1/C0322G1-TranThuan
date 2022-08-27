package com.example.controller;


import com.example.model.MedicalRecord;
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
@CrossOrigin("*")
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

//    public ResponseEntity<Page<MedicalRecord>> getMedicalRecordList(@PageableDefault(value = 100) Pageable pageable) {
//        Page<MedicalRecord> medicalRecordList = medicalRecordService.findAll(pageable);
//        if (medicalRecordList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(medicalRecordList, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<MedicalRecord> addBlog(@RequestBody MedicalRecord blog) {
        medicalRecordService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<MedicalRecord> deleteBlog(@PathVariable int id) {
        medicalRecordService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
