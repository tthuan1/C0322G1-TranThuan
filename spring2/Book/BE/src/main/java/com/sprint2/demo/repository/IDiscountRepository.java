package com.sprint2.demo.repository;

import com.sprint2.demo.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiscountRepository extends JpaRepository<Discount, Integer> {
}
