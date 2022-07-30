package com.example.model;

import javax.persistence.*;

@Entity(name = "borrower")
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double code;
//    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_book",referencedColumnName = "id")
    private Book book;

    public Borrower() {
    }

    public Borrower(double code, Book book) {
        this.code = code;
        this.book = book;
    }

    public Borrower(Integer id, Integer code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
