package com.example.service;

import com.example.model.Book;
import com.example.model.Borrower;

import java.util.List;

public interface IBorrowerService {

    void saveBorrower(int code, Integer id);

    List<Borrower> findByCode(Integer code);

    void repay(Integer code);
}
