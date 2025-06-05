package com.thaivu.superapp;

import com.thaivu.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       //  insertStudent();
//        getAll();
       //searchStudent();
       // findById();
       // updateStudent();
        deleteStudent();
    }

    // ham update 1 record, nhung trong orm thi la update/setter 1 object
    //object nao? object lay dc tu ham find()
    // from ORM se biet obj nao bi thay doi trang thai va cap nhat lau dai xuong db -> cat tru lau dai -> persist
    // jpa: java/jakarta persistence api
    // khi co su thay doi trong table/ database, bat buoc phai nhet thay doi nay trong cum lenh transaction
    // transaction: do all or nothing - nguyen ly ACID (Atomic - Consistency - Isolation - Durability)
    // OOP:
    // ABSTRACTION --> ENCAPSULATION --> INHERITENCE --> POLYMORPHISM
    //5. SOLID
    // S: SINGLE RESPONSIBILITY don trach nhiem trong thiet ke class, moi~ class ko nen chua cac thu ko lien quan

    //

    public static void updateStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.thaivu.superapp-PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //gia su muon cap nhat diem cua SE1, loi obj nay tu table
        Student student = em.find(Student.class, "SE1");
        student.setGpa(83.86);
        em.getTransaction().commit();
        // goi lai ham search de in ket qua
        findById();

    }

    public static void deleteStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.thaivu.superapp-PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //gia su muon cap nhat diem cua SE1, loi obj nay tu table
        Student student = em.find(Student.class, "SE1");
        em.remove(student);
        em.getTransaction().commit();
        // show lai ket qua
        em.close();
        emf.close();
        getAll();

    }

    // cac framework ORM deu ho tro ham chuan tim 1 record theo key

    public static void findById() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.thaivu.superapp-PU");
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, "SE1");
        System.out.println("Student info: " + student);
        // danh cho tinh nang edit 1 don hang, khach hang, san pham... khi user chon tu grid/table 1 dong muon edit ben frontend
    }

    // JPQL: 1 dang bien the cua cau sql truyen thong nhung viet theo phong cach OOP: object va dau cham (getter, setter, method)
    // lay tat ca data tu table student -> nay la class Student
    // FROM Student ~ SQL truyen thong: SELECT * FROM STUDENT
    // "SELECT x FROM Student x" ~ SQL truyen thong: SELECT * FROM STUDENT
    //                         x la bien tro vao 1 object Student
    //                         x = new Student() lay tu tung dong trong table
    // ta se select nt (giong nhu forEach...)

    //2. SELECT co WHERE (danh cho SEARCH sau nay)
    // "FROM Student x WHERE x.name = :pName" - pName duoc truyen vao sau
    // "FROM Student x WHERE x.name LIKE :pName" - pName duoc truyen vao sau, THEO FORMAT LIKE "%A%" TEN CO CHUA CHU A
    //                                                                                         "A%" A XUAT HIEN DAU TIEN

    public static void searchStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.thaivu.superapp-PU"); // tai cau hinh server tu file cau hinh xml persistence.xml
        EntityManager em = emf.createEntityManager(); // server xuat hien, y chang connection ben jdbc truyen thong
        List<Student> students = em.createQuery("SELECT x from Student x WHERE x.gpa = 8.7", Student.class).getResultList();

        System.out.println("Search student by gpa = 8.7");
        students.forEach(x -> System.out.println(x));
    }
    public static void getAll() {
        // trieu hoi jpa va hibernate
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.thaivu.superapp-PU"); // tai cau hinh server tu file cau hinh xml persistence.xml
        EntityManager em = emf.createEntityManager(); // server xuat hien, y chang connection ben jdbc truyen thong

        List<Student> students = em.createQuery("SELECT x from Student x", Student.class).getResultList();
//        for (Student x: students) {
//            // System.out.println(x);
//            // in giong le
//            // chu dong lay tung cot, qua getter() ko qua ten cot that
//            System.out.printf("|%8s|%-20s|%4d|%4.1f|\n", x.getId(), x.getName(), x.getYob(), x.getGpa());
//        }
        //lambda
        students.forEach(x -> System.out.printf("|%8s|%-20s|%4d|%4.1f|\n", x.getId(), x.getName(), x.getYob(), x.getGpa()));
        // lanbda dinh dang den streamapi cuc mup
        // xu li, filter du lieu trong RAM
        em.close();
    }
    public static void insertStudent() {
        // 1. Tao object student
        // 2. nho class cua jpa va hibernate de choi voi csdl
        //    tu 2 thang nay tao moi table neu chua ton tai, chen data vao
//        Student an = new Student("SE1", "An nguyen", 2004, 8.7);
//        Student binh = new Student("SE2", "Binh Gold", 2004, 8.7);
        Student cac = new Student("SE3", "fasd Gold", 2004, 8.7);
        // trieu hoi jpa va hibernate
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.thaivu.superapp-PU"); // tai cau hinh server tu file cau hinh xml persistence.xml
        EntityManager em = emf.createEntityManager(); // server xuat hien, y chang connection ben jdbc truyen thong
        em.getTransaction().begin(); // do all or nothing danh cho nhung thao tac co anh huong den database: C, U, D, Nho la R ko anh huong, chi la READ
        em.persist(cac); // INSERT INTO STUDENT VALUES ('SE1', 'An nguyen', ...)
        //em.persist(binh);
        em.getTransaction().commit();
        em.close();
    }
}