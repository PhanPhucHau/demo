package com.example.demo2.resource.model;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "phongban")
public class Phongban {
    @Id
    @Column(name = "MAPHONGBAN", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "TENPHONGBAN", length = 50)
    private String tenphongban;

    @OneToMany(mappedBy = "maphongban")
    @JsonbTransient
    private Set<Nhanvien> nhanviens = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenphongban() {
        return tenphongban;
    }

    public void setTenphongban(String tenphongban) {
        this.tenphongban = tenphongban;
    }

    public Set<Nhanvien> getNhanviens() {
        return nhanviens;
    }

    public void setNhanviens(Set<Nhanvien> nhanviens) {
        this.nhanviens = nhanviens;
    }

    public Phongban() {
    }

    public Phongban(Integer id, String tenphongban, Set<Nhanvien> nhanviens) {
        this.id = id;
        this.tenphongban = tenphongban;
        this.nhanviens = nhanviens;
    }

    @Override
    public String toString() {
        return "Phongban{" +
                "id=" + id +
                ", tenphongban='" + tenphongban + '\'' +
                ", nhanviens=" + nhanviens +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phongban phongban = (Phongban) o;
        return Objects.equals(id, phongban.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}