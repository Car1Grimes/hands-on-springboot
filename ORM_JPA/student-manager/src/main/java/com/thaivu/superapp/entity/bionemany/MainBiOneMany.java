package com.thaivu.superapp.entity.bionemany;

import com.thaivu.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainBiOneMany {
    public static void main(String[] args) {
        createMajorStudent();
    }
    public static void createMajorStudent() {
        Major se = new Major("SE", "Software Engineering");
        Student s1 = new Student("SE1000", "An Nguyen", 2004, 8.6);
        Student s2 = new Student("SE1001", "Binh Le", 2004, 8.7);

        se.addStudent(s1); //se ket nap s1, hau truong s1.major = se
        se.addStudent(s2);

        EntityManager emf = JpaUtil.getEntityManager();
        emf.getTransaction().begin();
        emf.persist(se);
        emf.getTransaction().commit();
        emf.close();
    }
}
