package com.thaivu.superapp.entity.unione;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)")
    //KO DUNG @NATIONALIZED, VI PHU THUOC CUNG VAO HIBERNATE
    //PHONG KHI MINH MUON DUNG ECLIPSELINK DO PHAI SUA CODE
    private String name;

    //THEO QUAN DIEM CUA TABLE, THI STUDENT CAN CO COT KHOA NGOAI!!!!!!!!!!!!!!!!!!!!!!!!!
    //DE TRO? SANG MAJOR
    //THEO QUAN DIEM OOP, THI LA CLASS NAY CO THAM CHIEU (REFERENCE) CLASS KIA

    //CACH 1: TRONG MOI QUAN HE 1-N, MR.ONE CHUA' NHIEU MR.NHIEU
    //CHI? NHIN 1 CHIEU TRONG MOI QH - UNI-DIRECTIONAL XUAT PHAT TU 1 (MAJOR)

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //cascade: to fall quickly and in large amounts
    //fetch: 1 load vao RAM, thi dam N co theo luon hay ko (chieu nguoc lai)
    //EAGER: DOC LUON DAM N; LAZY: KHI NAO CAN MOI LAY


    @JoinColumn(name = "MajorId")  // TEN COT FK TRONG TABLE STUDENT
    private List<Student> students = new ArrayList<>(); // bien students tro den 1 danh sach object Student o dau do trong bo nho
    //ta can co chox nao do de add tung Student dc new vao list nay
    //co 3 cach de so vao students.Add(new Student()) nao do
    // C1: cho students la public -> vi pham Encapsulation
    // C2: cho lay' students qua getStudents() ham get() truyen thong, giong getYob()
    // C3: them ham add() o class nay, new Major() sau do addStudent(...)
    // NGUYEN LY: S xuat hien trong SOLID, SINGLE RESPONSIBILITY
    //TUI, MAJOR DANG NAM DS SINH VIEN, THI ADD THEM 1 BAN LA HOP LY
    public void addStudent(Student obj) {
        students.add(obj); // mot ban sv new dau do dc add vao list
    }

    public Major() {}

    public Major(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
