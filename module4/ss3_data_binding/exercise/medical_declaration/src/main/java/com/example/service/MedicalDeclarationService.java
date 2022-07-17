package com.example.service;

import com.example.model.MedicalDeclaration;
import com.example.repository.IMedicalDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationService implements IMedicalDeclarationService {

    @Autowired
    private IMedicalDeclarationRepository medicalDeclarationRepository;


    @Override
    public void create(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.create(medicalDeclaration);
    }

    @Override
    public List<MedicalDeclaration> showAll() {
        return medicalDeclarationRepository.showAll();
    }

    @Override
    public MedicalDeclaration findIdentityCard(String identityCard) {
        return medicalDeclarationRepository.findIdentityCard( identityCard);
    }

    @Override
    public void update(String identityCard, MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.update( identityCard,  medicalDeclaration);
    }

}
