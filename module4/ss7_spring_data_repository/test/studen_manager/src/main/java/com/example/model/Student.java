package com.example.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String age;
    private Integer gender;

    @ManyToOne
    @JoinColumn(name = "class_id",referencedColumnName = "id")
    private ClassRoom classRoom;


    private String deleteAt;
    private String updateAt;
    private String createAt;

    public Student() {
    }

    public Student(Integer id, String name, String age, Integer gender, ClassRoom classRoom, String deleteAt, String updateAt, String createAt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.classRoom = classRoom;
        this.deleteAt = deleteAt;
        this.updateAt = updateAt;
        this.createAt = createAt;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public String getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(String deleteAt) {
        this.deleteAt = deleteAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
