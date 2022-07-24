package com.example.repository;

import com.example.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
    @Query(value = "select * from class_room ", nativeQuery = true)
    List<ClassRoom> findAllClassRoom();


}
