package com.example.annotation;

import com.example.common.ValidateAge;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ValidateAgeAnnotation implements ConstraintValidator<ValidateAge, String> {
    @Override
    public void initialize(ValidateAge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.equals("")){
            return false;
        }else{ LocalDate now = LocalDate.now();
            LocalDate bd = LocalDate.parse(value);
            return now.compareTo(bd) - 18 > 0;}
    }
}
