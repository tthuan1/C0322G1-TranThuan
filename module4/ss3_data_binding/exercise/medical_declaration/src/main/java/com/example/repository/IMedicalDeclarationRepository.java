package com.example.repository;

import com.example.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationRepository {
    void create(MedicalDeclaration medicalDeclaration);

    List<MedicalDeclaration> showAll();

    MedicalDeclaration findIdentityCard(String identityCard);

    void update(String identityCard, MedicalDeclaration medicalDeclaration);
    String[] yearOfBirthList();
    String[] nationalityList();
    String[] vehicleList();
}
