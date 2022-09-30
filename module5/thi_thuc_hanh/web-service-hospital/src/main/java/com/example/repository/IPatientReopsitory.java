package com.example.repository;

import com.example.model.MedicalRecord;
import com.example.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPatientReopsitory extends JpaRepository<Patient, Integer> {
    @Query(value = "select * from Patient", nativeQuery = true)
    List<Patient> findAllPatient();

    @Modifying
    @Query(value = "UPDATE Patient SET `name` = :name WHERE (`id` = :id);", nativeQuery = true)
    void editPatient(@Param("id") Integer id, @Param("name") String name);

    @Query(value = "select * from  Patient where id = :id", nativeQuery = true)
    Patient findByIdPatient(@Param("id") int id);
}
