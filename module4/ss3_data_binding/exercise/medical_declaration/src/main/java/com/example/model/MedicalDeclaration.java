package com.example.model;

public class MedicalDeclaration {
    private String name;
    private String yearOfBirth;
    private Integer gender;
    private String nationality;
    private String identityCard;
    private String vehicle;
    private String vehicleNumber;
    private String numberOfSeats;
    private String releaseDate;
    private String endDate;
    private String schedule;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String name, String yearOfBirth, Integer gender, String nationality, String identityCard, String vehicle, String vehicleNumber, String numberOfSeats, String releaseDate, String endDate, String schedule) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.identityCard = identityCard;
        this.vehicle = vehicle;
        this.vehicleNumber = vehicleNumber;
        this.numberOfSeats = numberOfSeats;
        this.releaseDate = releaseDate;
        this.endDate = endDate;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
