package com.thaivu.superapp.entity.unimany;

import com.thaivu.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainUniMany {
    public static void main(String[] args) {
        Major m1 = new Major("SE", "Software Engineering");
        Major m2 = new Major("GD", "Graphics Design");

        Student s1 = new Student("SE101", "An Nguyen", 2004, 8.6);
        Student s2 = new Student("SE111", "Binh Le", 2004, 8.7);
        Student s3 = new Student("GD101", "Cuong Vo", 2004, 8.5);
        Student s4 = new Student("GD111", "Dung Pham", 2004, 8.0);


        s1.setMajor(m1);
        s2.setMajor(m1);
        s3.setMajor(m2);
        s4.setMajor(m2);

        //SAVE XUONG DB - KO DO? THAC NUOC DC
        EntityManager em = JpaUtil.getEntityManager(); // goi ong quan ly dam @Entity
        em.getTransaction().begin();
//        em.persist(m1);
//        em.persist(m2);
//        em.persist(s1);
//        em.persist(s2);
//        em.persist(s3);
//        em.persist(s4);
        em.getTransaction().commit();
        em.close();

        //2 MAJOR DI XUONG, 4 STUDENT DI THEO, KEM KHOA NGOAI TUONG UNG
        // DOC THONG TIN SV VA THAY KO BIET CHUYEN NGANH GI, DO TRON GCLASS STUDENT KO CO THAM CHIEU DEN MAJOR
        em = JpaUtil.getEntityManager();
        List<com.thaivu.superapp.entity.unimany.Student> result = em.createQuery("SELECT s FROM Student s", com.thaivu.superapp.entity.unimany.Student.class).getResultList();

        //in danh sach sv, bi thieu thong tin Major
        //dung bieu thuc lambda
        System.out.println("The list of students (without major info)");
        result.forEach( x -> System.out.println(x.toString()));
    }
}
