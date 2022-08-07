package com.example.dto;

import com.example.model.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CustomerDto implements Validator {
    private Integer id;
    @NotBlank(message = "Không được để trống !!")
    private String name;
    private String birthday;
    private Integer gender;
    @NotBlank(message = "Không được để trống !!")
    private String id_card;
    @NotBlank(message = "Không được để trống !!")
    private String phone;
    @NotBlank(message = "Không được để trống !!")
    @Email(message = "Không đúng định dạng !!")
    private String email;
    @NotBlank(message = "Không được để trống !!")
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String birthday, Integer gender, String id_card, String phone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        String customerDtoName = customerDto.getName();
        String customerDtoPhone = customerDto.getPhone();
        String customerDtoIdCard = customerDto.getId_card();

        if (!customerDtoName.matches("^([A-Z]{1}[a-z]{1,}\\s{1}){1,}([A-Z]{1}[a-z]{1,})+$")) {
            errors.rejectValue("name", "customerDtoName", "kí tự đầu tiên của mỗi từ phải viết hoa");
        }
        if (!customerDtoPhone.matches("^(84|0[3|5|7|8|9])+([0-9]{8})\\b$")) {
            errors.rejectValue("phone", "customerDtoPhone",
               "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc(84)+90xxxxxxx hoặc (84)+91xxxxxxx.");
        }
        if (!customerDtoIdCard.matches("^[0-9]{9}|[0-9]{12}$")) {
            errors.rejectValue("id_card", "customerDtoPhone",
                "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX(X là số 0-9)");
        }
    }
}
