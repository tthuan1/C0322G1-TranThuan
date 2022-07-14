package com.example.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailService implements IEmailService{
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    public EmailService() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @Override
    public boolean checkEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
