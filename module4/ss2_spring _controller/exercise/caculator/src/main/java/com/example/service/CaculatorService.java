package com.example.service;

import com.example.repository.ICaculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {

    @Autowired
    private ICaculatorRepository caculatorRepository;

    @Override
    public String calculation(String number1, String number2, String calculation) {
        Double num1;
        Double num2;
        String result = null;
        try {
            num1 = Double.parseDouble(number1);
            num2 = Double.parseDouble(number2);
            switch (calculation) {
                case "+":
                    result = String.valueOf(num1 + num2);
                    break;
                case "-":
                    result = String.valueOf(num1 - num2);
                    break;
                case "X":
                    result = String.valueOf(num1 * num2);
                    break;
                case "/":
                    if (num2 == 0) {
                        result = "không thể chia 0";
                    } else {
                        result = String.valueOf(num1 / num2);
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            result = "nhập không phải là số";
        }
        return result;
    }
}
