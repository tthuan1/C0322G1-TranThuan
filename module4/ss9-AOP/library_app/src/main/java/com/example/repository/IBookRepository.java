package com.example.repository;

import com.example.model.Book;
import com.example.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Modifying
    @Query(value = "UPDATE book SET amount = :amont WHERE (`id` = :id);",nativeQuery = true)
    void update(@Param("id") Integer id,@Param("amont") int i);
@Query(value = "select * from book where id = :id",nativeQuery = true)
    Book findByIdBook(@Param("id") int id);

}
