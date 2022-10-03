package com.sprint2.demo.services.impl;

import com.sprint2.demo.models.Discount;
import com.sprint2.demo.repository.IDiscountRepository;
import com.sprint2.demo.services.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService implements IDiscountService {
    @Autowired
    private IDiscountRepository iDiscountRepository;

    @Override
    public List<Discount> findAllDiscount() {
        return this.iDiscountRepository.findAll();
    }
}
