package com.example.dto;

import com.example.model.Division;
import com.example.model.EducationDegree;
import com.example.model.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EmployeeDto implements Validator {
    private Integer id;
    @NotBlank(message = "Không được để trống !!")
    private String name;
    private String dateOfBirth;
    @NotBlank(message = "Không được để trống !!")
    private String idCard;

    @Min(value = 0,message = "Nhập số dương")
    private Double salary;
    @NotBlank(message = "Không được để trống !!")
    private String phone_number;
    @NotBlank(message = "Không được để trống !!")
    @Email(message = "Không đúng định dạng !!")
    private String email;
    @NotBlank(message = "Không được để trống !!")
    private String address;
    private String createAt;
    private Division division;
    private EducationDegree educationDegree;
    private Position position;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto=(EmployeeDto) target;
        String employeeDtoName=employeeDto.getName();
        String employeeDtoPhone = employeeDto.getPhone_number();
        String employeeDtoIdCard=employeeDto.getIdCard();

        if (!employeeDtoName.matches("^([A-Z]{1}[a-z]{1,}\\s{1}){1,}([A-Z]{1}[a-z]{1,})+$")) {
            errors.rejectValue("name", "employeeDtoName", "kí tự đầu tiên của mỗi từ phải viết hoa");
        }
        if (!employeeDtoPhone.matches("^(84|0[3|5|7|8|9])+([0-9]{8})\\b$")) {
            errors.rejectValue("phone_number", "employeeDtoPhone",
                    "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc(84)+90xxxxxxx hoặc (84)+91xxxxxxx.");
        }
        if (!employeeDtoIdCard.matches("^[0-9]{9}|[0-9]{12}$")) {
            errors.rejectValue("idCard", "employeeDtoIdCard",
                    "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX(X là số 0-9)");
        }
    }

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String dateOfBirth, String idCard, Double salary, String phone_number, String email, String address, String createAt, Division division, EducationDegree educationDegree, Position position) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.createAt = createAt;
        this.division = division;
        this.educationDegree = educationDegree;
        this.position = position;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
