package com.thaivu.superapp.entity.unimany;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    //1 STUDENT THUOC VE 1 CHUYEN NGANH
    //TA SE KHAI BAO BIEN THAM CHIEU TRO? NGUOC VE MAJOR
    //THUC CHAT DATABASE CHI LA COT KHOA NGOAI
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MajorId")
    private Major major; // dem key cua Major lam FK

    //set major cho 1 sv nao do
    public void setMajor(Major major) {
        this.major = major;
    }

    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
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

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                ", major=" + major.getName() +'}';
    }
}
