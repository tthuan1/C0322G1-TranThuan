package com.example.repository;

import com.example.model.MedicalDeclaration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalDeclarationRepository implements IMedicalDeclarationRepository {
    static List<MedicalDeclaration> medicalDeclarationList = new ArrayList<>();

    static {
        medicalDeclarationList.add(new MedicalDeclaration("Bích Huyền", "2001", 1, "VN", "6128", "Ô tô", "123312", "4", "2022-18-09", "2022-20-09", "Hội an"));
        medicalDeclarationList.add(new MedicalDeclaration("Thuân", "1998", 0, "VN", "312", "Ô tô", "123312", "4", "2022-18-09", "2022-20-09", "Hội an"));
        medicalDeclarationList.add(new MedicalDeclaration("Hoàn", "1999", 1, "VN", "789", "Ô tô", "123312", "4", "2022-18-09", "2022-20-09", "VN"));
        medicalDeclarationList.add(new MedicalDeclaration("Trí", "2000", 0, "VN", "163", "Ô tô", "123312", "4", "2022-18-09", "2022-20-09", "đà nẵng"));
    }

    String[] yearOfBirthList = {"1990", "1991", "1992", "1993", "1994"};
    String[] nationalityList = {"Việt Nam", "Laos", "China", "Thai Lan"};
    String[] vehicleList = {"Tàu bay", "Tàu thuyền", "Ô tô", "Khác(ghi rõ)"};


    @Override
    public void create(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationList.add(medicalDeclaration);
    }

    @Override
    public List<MedicalDeclaration> showAll() {
        return medicalDeclarationList;
    }

    @Override
    public MedicalDeclaration findIdentityCard(String identityCard) {
        for (MedicalDeclaration item : medicalDeclarationList) {
            if (item.getIdentityCard().equals(identityCard)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void update(String identityCard, MedicalDeclaration medicalDeclaration) {
        for (MedicalDeclaration item : medicalDeclarationList) {
            if (item.getIdentityCard().equals(identityCard)) {
                System.out.println("ok");
                item.setName(medicalDeclaration.getName());
                item.setYearOfBirth(medicalDeclaration.getYearOfBirth());
                item.setGender(medicalDeclaration.getGender());
                item.setNationality(medicalDeclaration.getNationality());
                item.setVehicle(medicalDeclaration.getVehicle());
                item.setVehicleNumber(medicalDeclaration.getVehicleNumber());
                item.setNumberOfSeats(medicalDeclaration.getNumberOfSeats());
                item.setReleaseDate(medicalDeclaration.getReleaseDate());
                item.setEndDate(medicalDeclaration.getEndDate());
                item.setSchedule(medicalDeclaration.getSchedule());
            }
        }
    }

    @Override
    public String[] yearOfBirthList() {
        return yearOfBirthList;
    }

    @Override
    public String[] nationalityList() {
        return nationalityList;
    }

    @Override
    public String[] vehicleList() {
        return vehicleList;
    }


}
