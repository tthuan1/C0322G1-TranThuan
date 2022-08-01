package com.example.aop;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    private String showErrorPage(){
        return "error";
    }
}
