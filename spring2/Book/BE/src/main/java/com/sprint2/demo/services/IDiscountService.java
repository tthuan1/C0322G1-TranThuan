package com.sprint2.demo.services;

import com.sprint2.demo.models.Author;
import com.sprint2.demo.models.Discount;

import java.util.List;

public interface IDiscountService {
    List<Discount> findAllDiscount();
}
