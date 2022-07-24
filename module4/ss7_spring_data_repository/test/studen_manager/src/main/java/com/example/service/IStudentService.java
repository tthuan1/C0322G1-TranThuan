package com.example.service;

import com.example.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Page<Student> findAllStudent(Pageable pageable);

    void deleteStudent(int id);

    void updateStudent(Student student);

    Optional<Student> findById(int id);

    void save(Student student);
}
