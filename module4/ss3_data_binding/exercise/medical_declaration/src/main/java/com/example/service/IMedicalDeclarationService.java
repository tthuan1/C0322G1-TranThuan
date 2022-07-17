package com.example.service;

import com.example.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationService {
    void create(MedicalDeclaration medicalDeclaration);

    List<MedicalDeclaration> showAll();

    MedicalDeclaration findIdentityCard(String identityCard);

    void update(String identityCard, MedicalDeclaration medicalDeclaration);
}
