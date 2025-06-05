package com.giaolang.superapp.repository;

import com.giaolang.superapp.entity.Student;
import com.giaolang.superapp.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepository {

    //class nay chua cac ham CRUD table student, choi truc tiep voi table, database
    //cac ham co xu huong dat ten ngan gon, focus vao thao tac table
    //vd: save(), update(), delete(), getAll(), find(), findById()

    //moi ham nay deu nhan object student ben ngoai dua vao
    //object nay den tu UI chuyen xuong, o day chi choi voi object student va table

    public void save(Student obj) {
        //can ong giam doc quan ly entity
        EntityManager em = JPAUtil.getEntityManager();
        //transaction
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    public List<Student> getAll() {
         EntityManager em = JPAUtil.getEntityManager();
         return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
         //tra ve de in tren web, tra ve de con ra json
        //select ko anh huong table, ko can transaction
    }

    //JPA cung cap san 1 ham tim theo key em.find(class nao, key gi)
    public Student findById(String id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Student.class, id);
    }

    //ham update/remove ke thua ham find: xac dinh 1 dua, va update/remove
    public void remove(String id) {
        //xoa la phai theo doi transaction
        EntityManager em = JPAUtil.getEntityManager();
        Student obj = em.find(Student.class, id);
        em.remove(obj);
        em.getTransaction().commit();
    }

    //C1: dua id kem object de do? ngang info
    //C2: chi dua obj, de' vao
    public void update(Student obj) {
        //xoa la phai theo doi transaction
        EntityManager em = JPAUtil.getEntityManager();
        //search va setter la mot cach
        em.merge(obj); //hoac tao. moi' hoac de' vao
        em.getTransaction().commit();
    }
}
