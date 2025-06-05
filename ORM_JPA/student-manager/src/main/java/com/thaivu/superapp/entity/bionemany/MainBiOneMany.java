package com.thaivu.superapp.entity.bionemany;

import com.thaivu.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainBiOneMany {
    public static void main(String[] args) {
        //createMajorStudent();
        getStudents();
    }

    public static void getStudents() {
        //TA MUON LAY DANH SACH SV NGANH SE
        EntityManager em = JpaUtil.getEntityManager();

        Major se = em.find(Major.class, "SE");
        List<Student> students = se.getStudents();
        System.out.println("List of students of SE: ");
        //lambda
        students.forEach(s -> System.out.println(s));

        //SE1000 thuoc chuyen nganh nao
        //c1: hay xem moi entity ~ table la 1 thu doc lap, vay ta dung ham find() theo key
        Student x = em.find(Student.class, "SE1000");
        System.out.println("\nThe student SE1000 info: " + x);
        System.out.println("Major info: \n" + x.getMajor().toString());
        //JPQL
        //List<Student> result = em.createQuery("select s from Student s where s.name ='SE1000'")
        //
        //c2: tu danh sach sinh vien cua major o tren, ta filter lai ra 1 sv, hoac get 1 sv tu list
        //tan dung cac ham cua stream-api va bieu thuc lambda de filter gia tri trong collection/arraylist
    }



    public static void createMajorStudent() {
        Major se = new Major("SE", "Software Engineering");
        Student s1 = new Student("SE1000", "An Nguyen", 2004, 8.6);
        Student s2 = new Student("SE1001", "Binh Le", 2004, 8.7);

        se.addStudent(s1); //se ket nap s1, hau truong s1.major = se
        se.addStudent(s2);

        EntityManager emf = JpaUtil.getEntityManager();
        emf.getTransaction().begin();
        //emf.persist(se);
        //emf.getTransaction().commit();
        emf.close();
    }
}
