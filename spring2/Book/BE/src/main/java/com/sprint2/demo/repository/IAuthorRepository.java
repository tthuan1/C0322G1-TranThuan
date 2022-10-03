package com.sprint2.demo.repository;

import com.sprint2.demo.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Integer> {
}
