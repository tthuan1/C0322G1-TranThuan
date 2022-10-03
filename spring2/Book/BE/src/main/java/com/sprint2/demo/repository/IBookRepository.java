package com.sprint2.demo.repository;

import com.sprint2.demo.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAllByNameContainingAndStatus(String name, Boolean status,Pageable pageable);

    @Query(value = "SELECT * FROM book WHERE (author_id = :authorId OR category_id = :categoryId) AND book.id != :bookId LIMIT 10",
            nativeQuery = true)
    List<Book> findTop10RelativeBookByAuthorOrCategory(Integer authorId, Integer categoryId, Integer bookId);

    @Transactional
    @Modifying
    @Query(value="UPDATE book set status = false where id = :bookId ", nativeQuery=true)
    void deleteBookById(Integer bookId);
}
