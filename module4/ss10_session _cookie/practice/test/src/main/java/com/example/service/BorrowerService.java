package com.example.service;

import com.example.model.Book;
import com.example.model.Borrower;
import com.example.repository.IBorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService implements IBorrowerService{

    @Autowired
    public IBorrowerRepository borrowerRepository;


    @Override
    public void saveBorrower(int code, Integer id) {
        borrowerRepository.saveBorrower( code, id);
    }

    @Override
    public List<Borrower> findByCode(Integer code) {
        return borrowerRepository.findByCode(code);
    }

    @Override
    public void repay(Integer code) {
        borrowerRepository.repay(code);
    }

}
