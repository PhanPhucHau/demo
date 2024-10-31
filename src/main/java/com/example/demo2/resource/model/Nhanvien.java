package com.example.demo2.resource.model;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "nhanvien")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "select l from Nhanvien l"),
        @NamedQuery(name = "findByID", query = "select l from Nhanvien  l where l.id = :id")
})
public class Nhanvien {
    @Id
    @Column(name = "MANHANVIEN", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "TENNHANVIEN", length = 50)
    private String tennhanvien;

    @Size(max = 50)
    @Column(name = "EMAIL", length = 50)
    private String email;

    @Size(max = 50)
    @Column(name = "DIACHI", length = 50)
    private String diachi;

    @Column(name = "DIENTHOAI")
    private Integer dienthoai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAPHONGBAN")
    private com.example.demo2.resource.model.Phongban maphongban;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Integer getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(Integer dienthoai) {
        this.dienthoai = dienthoai;
    }

    public com.example.demo2.resource.model.Phongban getMaphongban() {
        return maphongban;
    }

    public void setMaphongban(com.example.demo2.resource.model.Phongban maphongban) {
        this.maphongban = maphongban;
    }

    public Nhanvien() {
    }

    public Nhanvien(Integer id, String tennhanvien, String email, String diachi, Integer dienthoai, Phongban maphongban) {
        this.id = id;
        this.tennhanvien = tennhanvien;
        this.email = email;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.maphongban = maphongban;
    }

    @Override
    public String toString() {
        return "Nhanvien{" +
                "id=" + id +
                ", tennhanvien='" + tennhanvien + '\'' +
                ", email='" + email + '\'' +
                ", diachi='" + diachi + '\'' +
                ", dienthoai=" + dienthoai +
                ", maphongban=" + maphongban +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nhanvien nhanvien = (Nhanvien) o;
        return Objects.equals(id, nhanvien.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}