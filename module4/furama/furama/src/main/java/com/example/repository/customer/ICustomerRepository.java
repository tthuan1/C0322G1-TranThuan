package com.example.repository.customer;

import com.example.model.customer.Customer;
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
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
@Modifying
@Query(value = "delete from customer where (id = :id)",nativeQuery = true)
    void remove(@Param("id") int id);
@Query(value = "select * from Customer where name like :name",nativeQuery = true)
    Page<Customer> search(@Param("name") String name, Pageable pageable);
}
