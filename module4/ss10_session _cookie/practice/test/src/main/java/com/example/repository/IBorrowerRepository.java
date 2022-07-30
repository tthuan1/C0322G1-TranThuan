package com.example.repository;

import com.example.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IBorrowerRepository extends JpaRepository<Borrower, Integer> {
    @Modifying
    @Query(value = "INSERT INTO borrower (id_book, code) VALUES (:id,:code)", nativeQuery = true)
    void saveBorrower(@Param("code") int code, @Param("id") Integer id);

    @Query(value = "select * from borrower where code = :code", nativeQuery = true)
    List<Borrower> findByCode(@Param("code") Integer code);
    @Modifying
    @Query(value = "DELETE FROM borrower WHERE (`code` = :code)", nativeQuery = true)
    void repay(@Param("code") Integer code);

//    DELETE FROM borrower WHERE (`id` = :id)

}
