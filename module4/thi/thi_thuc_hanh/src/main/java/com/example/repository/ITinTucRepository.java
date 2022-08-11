package com.example.repository;

import com.example.model.Customer;
import com.example.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ITinTucRepository extends JpaRepository<TinTuc,Integer> {
    @Query(value = "select * from tin_tuc where tieu_de like :name",nativeQuery = true)
    Page<TinTuc> findAllTinTuc(@Param("name")String name, Pageable pageable);
    @Modifying
    @Query(value = "delete from tin_tuc where (ma_tin_tuc = :maTinTuc)",nativeQuery = true)
    void remove(@Param("maTinTuc")int maTinTuc);
}
