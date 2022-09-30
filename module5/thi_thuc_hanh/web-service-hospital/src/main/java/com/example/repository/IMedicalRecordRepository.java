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
public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    @Modifying
    @Query(value = "delete FROM MedicalRecord WHERE (`id` = :id);", nativeQuery = true)
    void deleteByIdMedicalRecord(@Param("id") int id);
    @Modifying
    @Query(value = "INSERT INTO `hospital`.`medical_record` (`doctor`, `hospital_discharge_date`, `hospitalized_day`, `reason`, `treatments`, `patient`) VALUES (:doctor, :hospitalDischargeDate, :hospitalizedDay, :reason, :treatments, :patient);", nativeQuery = true)
    void saveMedicalRecord(@Param("doctor") String doctor, @Param("hospitalDischargeDate") String hospitalDischargeDate,
                           @Param("hospitalizedDay") String hospitalizedDay, @Param("reason") String reason, @Param("treatments") String treatments, @Param("patient") Patient patient);

    @Query(value = "SELECT * FROM hospital.medical_record;", nativeQuery = true)
    List<MedicalRecord> findAllMedicalRecord();
    @Query(value = "SELECT * FROM hospital.medical_record where `id` = :id ", nativeQuery = true)
    MedicalRecord findByIdMedicalRecord(@Param("id") int id);
}
