package com.example.model.customer;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String birthday;
    private Integer gender;
    private String id_card;
    private String phone;
    private String email;
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_type_id",referencedColumnName = "id")
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(Integer id, String name, String birthday, Integer gender, String id_card, String phone, String email, String address, CustomerType customerType) {
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
}
