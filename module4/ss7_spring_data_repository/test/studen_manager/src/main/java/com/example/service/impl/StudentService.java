package com.example.service.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository repository;


    @Override
    public Page<Student> findAllStudent(Pageable pageable) {
        return repository.findAllStudent(pageable);
    }

    @Override
    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        repository.updateStudent( student.getId(), student.getName(),student.getGender(),student.getAge());
    }

    @Override
    public Optional<Student> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }
}
