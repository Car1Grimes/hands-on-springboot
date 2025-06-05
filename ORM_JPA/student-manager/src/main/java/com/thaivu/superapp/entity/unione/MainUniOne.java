package com.thaivu.superapp.entity.unione;

import com.thaivu.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainUniOne {
    public static void main(String[] args) {
//        Major m1 = new Major("SE", "Software Engineering");
//        Major m2 = new Major("GD", "Graphics Design");
//
//        Student s1 = new Student("SE10", "An Nguyen", 2004, 8.6);
//        Student s2 = new Student("SE11", "Binh Le", 2004, 8.7);
//        Student s3 = new Student("GD10", "Cuong Vo", 2004, 8.5);
//        Student s4 = new Student("GD11", "Dung Pham", 2004, 8.0);
//
//        m1.addStudent(s1);
//        m1.addStudent(s2); //SE co 2 sv theo quan diem OOP
//
//        m2.addStudent(s3);
//        m2.addStudent(s4);//GD co 2 sv

        //SAVE XUONG DB
        EntityManager em = JpaUtil.getEntityManager(); // goi ong quan ly dam @Entity
//        em.getTransaction().begin();
//        em.persist(m1);
//        em.persist(m2);
//        em.getTransaction().commit();
//        em.close();
        //2 MAJOR DI XUONG, 4 STUDENT DI THEO, KEM KHOA NGOAI TUONG UNG
        // DOC THONG TIN SV VA THAY KO BIET CHUYEN NGANH GI, DO TRON GCLASS STUDENT KO CO THAM CHIEU DEN MAJOR
        em = JpaUtil.getEntityManager();
        List<Student> result = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();

        //in danh sach sv, bi thieu thong tin Major
        //dung bieu thuc lambda
        System.out.println("The list of students (without major info)");
        result.forEach( x -> System.out.println(x.toString()));
    }
}
