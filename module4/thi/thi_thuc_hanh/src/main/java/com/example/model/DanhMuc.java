package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "danh_muc")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "danhMuc")
    private Set<TinTuc> tinTuc;

    public DanhMuc() {
    }

    public DanhMuc(Integer id, String name, Set<TinTuc> tinTuc) {
        this.id = id;
        this.name = name;
        this.tinTuc = tinTuc;
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

    public Set<TinTuc> getTinTuc() {
        return tinTuc;
    }

    public void setTinTuc(Set<TinTuc> tinTuc) {
        this.tinTuc = tinTuc;
    }
}
