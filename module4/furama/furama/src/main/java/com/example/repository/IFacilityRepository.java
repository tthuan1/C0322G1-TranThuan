package com.example.repository;

import com.example.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Modifying
    @Query(value = "delete from facility where (id = :id)",nativeQuery = true)
    void remove(@Param("id") int id);
}
