package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer amount;

    @OneToMany(mappedBy = "book")
    private Set<Borrower> borrower;

    public Book() {
    }
    public Book(Integer id, String name, Integer amount, Set<Borrower> borrower) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.borrower = borrower;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<Borrower> getBorrower() {
        return borrower;
    }

    public void setBorrower(Set<Borrower> borrower) {
        this.borrower = borrower;
    }
}
