package com.example.service;

import com.example.repository.IMedicalDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalDeclarationService implements IMedicalDeclarationService {

    @Autowired
    private IMedicalDeclarationRepository nameRepository;


}
