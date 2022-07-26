package com.example.dto.customer;

import org.springframework.data.repository.query.Param;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private Integer id;
  @NotNull
  @NotEmpty
    private String name;
    private String birthday;
    private Integer gender;
    @Pattern(regexp = "^\\d{9}//\\d{12}$",message = "Nhập 9 chữ số hoặc 12 chữ số !!")
    private String id_card;
    private String phone;
    private String email;
    private String address;

    @Override
    public void validate(Object target, Errors errors) {

    }

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String birthday, Integer gender, String id_card, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


}
