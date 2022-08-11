package com.example.repository;

import com.example.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDanhMucRepository extends JpaRepository<DanhMuc,Integer> {
}
