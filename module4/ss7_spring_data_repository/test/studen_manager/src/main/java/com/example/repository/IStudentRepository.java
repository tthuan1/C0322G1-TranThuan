package com.example.repository;

import com.example.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Query(
            value = "SELECT * FROM student " +
                    "where delete_at is null or delete_at like 'null'"
            , nativeQuery = true)
    Page<Student> findAllStudent(Pageable pageable);

    @Modifying
    @Query(value = "UPDATE student SET delete_at = current_timestamp WHERE (`id` = :id);", nativeQuery = true)
    void deleteStudent(@Param("id") int id);


    @Modifying
    @Query(value = "UPDATE `student_manager`.`student` SET `age` = :age, `gender` = :gender, `name` = :name, `update_at` = current_timestamp WHERE (`id` = :id)", nativeQuery = true)
    void updateStudent(@Param("id") Integer id,@Param("name") String name,@Param("gender") Integer gender,@Param("age") String age);


}
