package com.example.demo2.responsitory;

import com.example.demo2.resource.model.Nhanvien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class NhanVienResponsitory {
    @PersistenceContext(unitName = "hau")
    private EntityManager entityManager;


    public void persist(Nhanvien nhanvien){
        entityManager.persist(nhanvien);
    }

    public List<Nhanvien> findAll(){
        return entityManager.createNamedQuery("findAll").getResultList();
    }
    public void deleteById(int id) {
        Nhanvien nhanvien = entityManager.find(Nhanvien.class, id);
        if (nhanvien != null) {
            entityManager.remove(nhanvien);
        }
    }

    public void saveNhanvien(Nhanvien nv) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(nv);  // Lưu đối tượng nv vào cơ sở dữ liệu
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Nếu có lỗi, hoàn tác giao dịch
            }
            e.printStackTrace();
        }
    }

}
