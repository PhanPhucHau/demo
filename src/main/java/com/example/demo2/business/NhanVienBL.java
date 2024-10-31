package com.example.demo2.business;

import com.example.demo2.resource.model.Nhanvien;
import com.example.demo2.responsitory.NhanVienResponsitory;
import jakarta.inject.Inject;

import java.util.List;

public class NhanVienBL {
    @Inject
    private NhanVienResponsitory nhanVienResponsitory;

    public void add(Nhanvien nhanvien){
        nhanVienResponsitory.persist(nhanvien);
    }

    public List<Nhanvien> getNhanVien(){
         return nhanVienResponsitory.findAll();
    }

    public void deleteNhanVien(int id) {
        nhanVienResponsitory.deleteById(id);
    }

    public void saveNhanvien(Nhanvien nv) {
        nhanVienResponsitory.saveNhanvien(nv);
    }

}
